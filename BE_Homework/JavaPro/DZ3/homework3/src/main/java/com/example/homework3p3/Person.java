package com.example.homework3p3;

public class Person {
    @Save
    private int weight;
    @Save
    private String name;
    @Save
    private int height;
    @Save
    private String region;

    public Person() {
        super();
    }

    public Person(int weight, String name, int height, String region) {
        this.weight = weight;
        this.name = name;
        this.height = height;
        this.region = region;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public String getRegion() {
        return region;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Person{" +
                "weight = " + weight +
                ", name = " + name +
                ", height = " + height +
                ", region = " + region +
                "}";
    }
}
