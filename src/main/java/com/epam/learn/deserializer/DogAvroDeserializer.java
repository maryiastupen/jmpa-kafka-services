package com.epam.learn.deserializer;

import com.epam.learn.DogV1;
import com.epam.learn.DogV2;
import com.epam.learn.entity.DogVersion1;
import com.epam.learn.entity.DogVersion2;
import org.apache.avro.specific.SpecificRecord;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

/**
 * Deserializes values based on the corresponding avro schema
 */
@Service
public class DogAvroDeserializer {

    /**
     * Deserializes specific record's value depending on the schema's version.
     * Throws {@link IllegalStateException} in case version is not supported.
     *
     * @param version version of the schema
     * @param value   - specific record where we expect either {@link DogV1} or {@link DogV2}
     */
    public void deserializeValue(int version, SpecificRecord value) {
        switch (version) {
            case (1) -> deserializeDogV1((DogV1) value);
            case (2) -> deserializeDogV2((DogV2) value);
            default -> throw new IllegalStateException(format("Can not deserialize the record %s. Version %d is not supported.", value.toString(), version));
        }
    }

    private void deserializeDogV1(DogV1 dogv1) {
        DogVersion1 dogVersion1 = new DogVersion1().newBuilder()
                .setId(dogv1.getId())
                .setName(dogv1.getName())
                .setBreed(dogv1.getBreed())
                .setAge(dogv1.getAge())
                .build();
        System.out.println(dogVersion1.toString());
    }

    private void deserializeDogV2(DogV2 dogv2) {
        DogVersion2 dogVersion2 = new DogVersion2().newBuilder()
                .setId(dogv2.getId())
                .setName(dogv2.getName())
                .setBreed(dogv2.getBreed())
                .setAge(dogv2.getAge())
                .setWeight(dogv2.getWeight())
                .build();
        System.out.println(dogVersion2.toString());
    }

}
