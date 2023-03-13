package com.epam.learn.consumer;

import com.epam.learn.deserializer.DogAvroDeserializer;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Kafka avro dog consumer
 */
@Service
public class KafkaAvroDogConsumer {

    private final DogAvroDeserializer dogAvroDeserializer;

    @Autowired
    public KafkaAvroDogConsumer(DogAvroDeserializer dogAvroDeserializer) {
        this.dogAvroDeserializer = dogAvroDeserializer;
    }

    /**
     * Consumes record and deserializes it to one of the entities
     *
     * @param record specific record
     */
    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void consumeDog(ConsumerRecord<String, SpecificRecord> record) {
        int version = Integer.parseInt(record.key());
        dogAvroDeserializer.deserializeValue(version, record.value());
    }

}