package com.bittech.pc;

/**
 * Author: secondriver
 * Created: 2019/4/21
 */
public class Goods {
    
    private String name;
    private Double price;
    
    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public Double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
