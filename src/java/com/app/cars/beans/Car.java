/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.cars.beans;

/**
 *
 * @author shastrula
 */
public class Car {
    private CarModel model;
    private String color;
    private int year;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarModel getModel() {
        return model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
