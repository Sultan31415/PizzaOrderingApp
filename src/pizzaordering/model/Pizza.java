package pizzaordering.model;

import java.util.*;
public class Pizza {

    private static int nextPizzaId = 1;

    private PizzaBase pizzaBase;
    private Topping topping;
    private String size;
    private double price;
    private String pizzaName;
    private int pizzaId;

    public Pizza(){

    }

    public Pizza(PizzaBase pizzaBase, Topping topping, String size, double price, String pizzaName) {
        this.pizzaBase = pizzaBase;
        this.topping = topping;
        this.size = size;
        this.price = price;
        this.pizzaName = pizzaName;
        this.pizzaId = nextPizzaId++;
    }



    public int getPizzaId() {
        return pizzaId;
    }
    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }




    public String getPizzaName() {
        return pizzaName;
    }
    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }



    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }



    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }



    public Topping getTopping() {
        return topping;
    }
    public void setTopping(Topping topping) {
        this.topping = topping;
    }



    public PizzaBase getPizzaBase() {
        return pizzaBase;
    }
    public void setPizzaBase(PizzaBase pizzaBase) {
        this.pizzaBase = pizzaBase;
    }




    @Override
    public String toString() {
        return "\nPizza Details => ID: " + getPizzaId() +  ", Name : " + getPizzaName() + ", Price : " + getPrice()+"$, Size :" + getSize() + getTopping() + getPizzaBase();
    }
}
