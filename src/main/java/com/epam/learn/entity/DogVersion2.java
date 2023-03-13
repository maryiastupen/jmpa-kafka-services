package com.epam.learn.entity;

/**
 * Pojo class that represents to Dog's schema version 2
 */
public class DogVersion2 {

    private int id;
    private String name;
    private String breed;
    private int age;
    private int weight;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "DogVersion2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public DogVersion2Builder newBuilder() {
        return new DogVersion2Builder();
    }

    public DogVersion2() {}

    private DogVersion2(DogVersion2Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.breed = builder.breed;
        this.age = builder.age;
        this.weight = builder.weight;
    }

    public static class DogVersion2Builder {

        private int id;
        private String name;
        private String breed;
        private int age;
        private int weight;

        public DogVersion2 build() {
            return new DogVersion2(this);
        }

        public DogVersion2Builder setId(int id) {
            this.id = id;
            return this;
        }

        public DogVersion2Builder setName(String name) {
            this.name = name;
            return this;
        }

        public DogVersion2Builder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public DogVersion2Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public DogVersion2Builder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

    }

}
