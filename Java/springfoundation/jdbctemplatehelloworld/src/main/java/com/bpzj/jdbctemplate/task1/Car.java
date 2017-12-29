package com.bpzj.jdbctemplate.task1;

public class Car {
    private String brand;
    private String corp;
    private int price;
    private double maxSpeed;

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void init() {
        System.out.println("执行init方法...");
    }

    public void destroy() {
        System.out.println("执行destroy方法");
    }

    public Car(String brand, String corp, int price) {
        super();
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    public Car(String brand, String corp, double maxSpeed) {
        super();
        this.brand = brand;
        this.corp = corp;
        this.maxSpeed = maxSpeed;
    }

    public Car() {
        super();
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", corp=" + corp + ",price="
                + price + ",maxSpeed=" + maxSpeed + "]";

    }
}
