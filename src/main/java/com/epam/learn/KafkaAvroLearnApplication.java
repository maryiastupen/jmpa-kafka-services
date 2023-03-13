package com.epam.learn;

import com.epam.learn.producer.KafkaAvroDogProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaAvroLearnApplication {

    private final KafkaAvroDogProducer kafkaAvroDogProducer;

    public KafkaAvroLearnApplication(KafkaAvroDogProducer kafkaAvroDogProducer) {this.kafkaAvroDogProducer = kafkaAvroDogProducer;}

    public static void main(String[] args) {
        SpringApplication.run(KafkaAvroLearnApplication.class, args);
    }

    /**
     * Produces versioned dogs messages on the startup of the application
     */
    @EventListener(ApplicationReadyEvent.class)
    public void produceMessages() {
        DogV1 dogV1 = DogV1.newBuilder()
                .setId(1)
                .setAge(2)
                .setBreed("samoyed")
                .setName("Norty")
                .build();

        DogV2 dogV2 = DogV2.newBuilder()
                .setId(1)
                .setAge(2)
                .setBreed("samoyed")
                .setName("Norty")
                .setWeight(22)
                .build();
        kafkaAvroDogProducer.sendVersionedDog(dogV1);
        kafkaAvroDogProducer.sendVersionedDog(dogV2);
    }

}
