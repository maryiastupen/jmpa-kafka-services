package com.epam.learn.entity;

/**
 * Pojo class that represents to Dog's schema version 1
 */
public class DogVersion1 {

    private int id;
    private String name;
    private String breed;
    private int age;

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

    @Override
    public String toString() {
        return "DogVersion1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                '}';
    }

    public DogVersion1Builder newBuilder() {
        return new DogVersion1Builder();
    }

    public DogVersion1() {}

    private DogVersion1(DogVersion1Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.breed = builder.breed;
        this.age = builder.age;
    }

    public static class DogVersion1Builder {

        private int id;
        private String name;
        private String breed;
        private int age;

        public DogVersion1 build() {
            return new DogVersion1(this);
        }

        public DogVersion1Builder setId(int id) {
            this.id = id;
            return this;
        }

        public DogVersion1Builder setName(String name) {
            this.name = name;
            return this;
        }

        public DogVersion1Builder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public DogVersion1Builder setAge(int age) {
            this.age = age;
            return this;
        }

    }

}
