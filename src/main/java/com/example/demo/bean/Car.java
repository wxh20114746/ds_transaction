package com.example.demo.bean;

public class Car {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", car='" + car + '\'' +
                '}';
    }

    private int id;
    private String car;
}
