package pizzaordering.store;
import pizzaordering.model.*;
import pizzaordering.exception.*;
import pizzaordering.service.*;


import java.util.*;

public class PizzaStore {
    private List<Customer> customers;
    private List<Pizza> pizzas;
    private String storeLocation;
    private String storeName;
    private int id;


    public PizzaStore() {
        this.pizzas = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public PizzaStore(int storeId,String storeName,String storeLocation){
        this.id = storeId;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        
    }

    public void addPizzaToStore(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public void removePizzaFromStore(Pizza pizza) {
        pizzas.remove(pizza);
    }



    public int getStoreId(){
        return id;
    }
    public void setStoreId(int storeId){
        this.id = storeId;
    }



    public String getStoreName(){
        return storeName;
    }
    public void setStoreName(String storeName){
        this.storeName = storeName;
    }



    public String getStoreLocation(){
        return storeLocation;
    }
    public void setStoreLocation(String storeLocation){
        this.storeLocation = storeLocation;
    }




    public List<Pizza> getAllAvailablePizzas() {
        return pizzas;
    }
    public void setAvailablePizzasInStore(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }



    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }




    public Customer findCustomerByName(String customerName) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(customerName)) {
                return customer;
            }
        }
        return null; 
    }

    public Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null; 
    }



   public Customer findCustomerByNamePhoneEmail(String name, long phone, String email) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(name) && 
                customer.getCustomerMobile() == phone &&
                customer.getCustomerEmail().equals(email)) {
                return customer;
            }
        }
        return null; 
    }

    public Order findOrderById(int orderId) {
        for (Customer customer : customers) {
            for (Order order : customer.getOrders()) {
                if (order.getOrderId() == orderId) {
                    return order;
                }
            }
        }
        return null; 
    }

    @Override
    public String toString() {
        return "PizzaStore{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", storeLocation='" + storeLocation + '\'' +
                '}';
    }




}
 