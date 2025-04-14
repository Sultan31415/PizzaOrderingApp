package pizzaordering.model;
import java.util.*;

public class Customer {
    private List<Order> orders;
    private Address address;
    private long mobile;
    private String email;
    private String customerName;
    private int customerId;
    private static int nextId = 1;

    public Customer(){

    }
   public Customer( Address address, long mobile, String email, String customerName) {
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.customerName = customerName;
        this.customerId = nextId++; 
        this.orders = new ArrayList<>();
    }


    public void addOrder(Order order){
    	 orders.add(order);

    }



    // public double getPayableAmout(){
    //     re

    // }

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }



    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }



    public String getCustomerEmail() {
        return email;
    }
    public void setCustomerEmail(String email) {
        this.email = email;
    }


    public long getCustomerMobile() {
        return mobile;
    }
    public void setCustomerMobile(long mobile) {
        this.mobile = mobile;
    }



    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }



    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public double calculateTotalBill() {
        if (orders.isEmpty()) {
            throw new IllegalStateException("No orders present for calculation.");
        }
        double totalBill = 0.0;
        for (Order order : orders) {
            totalBill += order.getPayBillAmount();
        }
        return totalBill;
    }








    @Override
    public String toString() {
        return "Customer Details => ID: " + getCustomerId() +  ", Name : " + getCustomerName() + ", Email: " + getCustomerEmail()+", mobile:" + getCustomerMobile();
    }

}
