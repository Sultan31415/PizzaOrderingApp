package pizzaordering.model;
import java.util.*;

public class Order {
    private List<Pizza> pizzas;
    private String orderDescription;
    private double payBillAmount;
    private String orderDate;
    private int orderId;
    private Customer customer;
    private Feedback feedback;


	public Order(String orderDescription, double payBillAmount, String orderDate, int orderId, Customer customer) {
    this.orderDescription = orderDescription;
    this.payBillAmount = payBillAmount;
    this.orderDate = orderDate;
    this.orderId = orderId;
    this.customer = customer; 
    this.pizzas = new ArrayList<>();
}


	public void addFeedback(Feedback feedback) {
	    this.feedback = feedback;
	}

	public Feedback getFeedback() {
	    return feedback;
	}


    public void addPizzaToOrder(Pizza pizza) {
        pizzas.add(pizza);
    }



	public int getOrderId() {
	    return orderId;
	}
	public void setOrderId(int orderId) {
	    this.orderId = orderId;
	}



	public String getOrderDate() {
	    return orderDate;
	}
	public void setOrderDate(String orderDate) {
	    this.orderDate = orderDate;
	}




	public Double getPayBillAmount() {
	    return payBillAmount;
	}
	public void setPayBillAmount(Double payBillAmount) {
	    this.payBillAmount = payBillAmount;
	}


	public String getOrderDescription() {
	    return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
	    this.orderDescription = orderDescription;
	}



    public List<Pizza> getPizzasInOrder() {
        return pizzas;
    }
    public void setPizzasForOrder(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }



@Override
public String toString() {
    return "Order Details => ID: " + orderId + ", Description: " + orderDescription + "\n" +
           "Total Amount: $" + payBillAmount + "\n" +
           "Order Date: " + orderDate;
}




}
