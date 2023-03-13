package com.epam.learn.producer;

import java.util.concurrent.CompletableFuture;

import org.apache.avro.specific.SpecificRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

/**
 * Kafka avro dog producer
 */
@Service
public class KafkaAvroDogProducer {

    @Value("${avro.topic.name}")
    private String topic;

    private final KafkaTemplate<String, SpecificRecord> kafkaTemplate;

    @Autowired
    public KafkaAvroDogProducer(KafkaTemplate<String, SpecificRecord> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Sends dog message wrapped in a specific record with a version of the schema
     *
     * @param record - specific record
     */
    public void sendVersionedDog(SpecificRecord record) {
        CompletableFuture<SendResult<String, SpecificRecord>> completableFuture = this.kafkaTemplate.send(topic, record.getSchema().getProp("version"), record);
        completableFuture.whenComplete((input, exception) -> {
            if (exception != null) {
                System.err.println(exception.getMessage());
            }
        });
    }

}
