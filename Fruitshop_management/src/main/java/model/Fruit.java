/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HELLO
 */
public class Fruit {
    
    private int fruitId;
    private String fruitName;
    private double fruitPrice;
    private int fruitQuantity;
    private String fruitOrigin;
    
    public int getFruitId() {
        return fruitId;
    }

    public Fruit(int fruitId, String fruitName, double fruitPrice, int fruitQuantity, String fruitOrigin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.fruitQuantity = fruitQuantity;
        this.fruitOrigin = fruitOrigin;
    }
    
    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    public String getFruitOrigin() {
        return fruitOrigin;
    }

    public void setFruitOrigin(String fruitOrigin) {
        this.fruitOrigin = fruitOrigin;
    }

    @Override
    public String toString() {
        return "   " + fruitId + "   " + fruitName + "   " + fruitPrice + "   " + fruitQuantity + "   " + fruitOrigin;
    }
}
