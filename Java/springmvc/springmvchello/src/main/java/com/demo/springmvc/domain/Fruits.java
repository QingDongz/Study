package com.demo.springmvc.domain;

public class Fruits {
    private long id;
    private String fruitName;
    private float fruitPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public float getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(float fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public Fruits(long id, String fruitName, float fruitPrice) {
        this.id = id;
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
    }

    public Fruits() {
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "id=" + id +
                ", fruitName='" + fruitName + '\'' +
                ", fruitPrice=" + fruitPrice +
                '}';
    }
}
