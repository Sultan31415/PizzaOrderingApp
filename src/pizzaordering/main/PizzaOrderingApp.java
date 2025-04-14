package pizzaordering.main;

import pizzaordering.service.PizzaService;
import pizzaordering.store.PizzaStore;
import pizzaordering.model.Pizza;
import pizzaordering.model.PizzaBase;
import pizzaordering.model.Topping;
import pizzaordering.model.Address;
import pizzaordering.model.Customer;
import pizzaordering.model.Order;
import pizzaordering.exception.PizzaNotFound;
import pizzaordering.model.Feedback;



import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Date;
import java.text.SimpleDateFormat;





public class PizzaOrderingApp {

        private static Scanner in = new Scanner(System.in);
        // private static List<Pizza> pizzas = new ArrayList<>();
        // private static List<Order> orders = new ArrayList<>();
         // private static List<Customer> customers = new ArrayList<>();
        private static PizzaStore pizzaStore = new PizzaStore();
        private static PizzaService pizzaService = new PizzaService(pizzaStore);
        private static int orderIdCounter = 1;
        private static Customer newCustomer;

// MAIN CLASS , MAINMENU SWITCH - CASE:
                public static void main(String[] args) {
                    boolean exitProgram = false;
                    while (!exitProgram) {
                        try{
                            displayMainMenu();
                            int choice = in.nextInt();
                            switch (choice) {
                                case 1:
                                    AdminConsole();
                                    break;
                                case 2:
                                    CustomerConsole();
                                    break;
                                case 3:
                                    System.out.println("You are exiting...");
                                    exitProgram = true;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            in.nextLine();
                        } catch (PizzaNotFound e) {
                            System.out.println(e.getMessage());
                        }
                    }

                }

       public static String getCurrentDate() {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            return formatter.format(date);
        }

                    public static void displayMainMenu() {
                        System.out.println("\nChoose your role to log in: ");
                        System.out.println("1. As Admin");
                        System.out.println("2. As Customer");
                        System.out.println("3. Exit");
                        System.out.print("Enter your choice: ");
                    }

                    public static void displayAdminMenu() {
                        System.out.println("\nChoose an Option");
                        System.out.println("1) Add Pizza");
                        System.out.println("2) Update Price");
                        System.out.println("3) Delete Pizza");
                        System.out.println("4) View all Pizza");
                        System.out.println("5) Search Pizza");
                        System.out.println("6) View All Feedback");
                        System.out.println("7) Exit");
                        System.out.print("Your choice: ");
                    }

                    public static void displayCustomerMenu() {
                        System.out.println("\nChoose an Option");
                        System.out.println("1) Order Pizza");
                        System.out.println("2) Pay Bill");
                        System.out.println("3) View All Pizza");
                        System.out.println("4) View Your Orders");
                        System.out.println("5) Search Pizza");
                        System.out.println("6) Leave Feedback");
                        System.out.println("7) Exit");
                        System.out.print("Your choice: ");
                    }
//ALL ABOUT ADMINCONSOLE:
public static void AdminConsole() {
            System.out.println("Welcome to Admin console: !!!");


            while (true) {
                   displayAdminMenu();
                   int choice = in.nextInt();
                    switch (choice) {
                        case 1:
                            addPizza();
                            break;
                        case 2:
                            updatePrice();
                            break;
                        case 3:
                            deletePizza();
                            break;
                        case 4:
                            viewAllPizzas();
                            break;
                        case 5:
                            searchPizza();
                            break;
                        case 6:
                            viewAllFeedback();
                            break;
                        case 7:
                            System.out.println("You are exiting...");
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
            }
        }
    public static void addPizza(){
        try{
            System.out.println("\n <     ADD NEW PIZZA MENU       >");
            in.nextLine();  
            System.out.print("Enter topping name: ");
            String toppingName = readStringInput();
            System.out.print("Enter spice level (basic/mediate/full): ");
            String spiceLevel = readStringInput() ;
            System.out.print("Enter description: ");
            String toppingDescription = readStringInput() ;
            Topping newTopping = new Topping(toppingName, spiceLevel, toppingDescription);

            System.out.print("\nEnter Base name: ");
            String baseName = readStringInput() ;
            System.out.print("Enter type (thin/thik): ");
            String baseType = readStringInput() ;
            System.out.print("Enter description: ");
            String baseDescription = readStringInput() ;
            PizzaBase newBase = new PizzaBase(baseName, baseType,baseDescription);

            System.out.print("\nEnter pizza name: ");
            String pizzaName = readStringInput() ;
            System.out.print("Enter price: ");
            double pizzaPrice = in.nextDouble();
            in.nextLine(); 
            System.out.print("Enter size(small, medium, large): ");
            String pizzaSize = readStringInput() ;
            Pizza newPizza = new Pizza(newBase, newTopping, pizzaSize, pizzaPrice, pizzaName);

            pizzaService.addPizzaToMenu(newPizza); 

            System.out.println("You added Pizza successfully");

            System.out.println(newPizza.toString());
            // System.out.println(newTopping.toString());
            // System.out.println(newBase.toString());
           } catch (IllegalArgumentException e) {
            System.out.println("Error adding pizza: " + e.getMessage());
        }
    }



        public static void updatePrice() {
            try {
                System.out.println("Choose a pizza to update price:");
                for (Pizza pizza : pizzaStore.getAllAvailablePizzas()) {
                    System.out.println(pizza.getPizzaName() + ": $" + pizza.getPrice());
                }
                in.nextLine(); 
                System.out.print("Enter the name of the pizza to update: ");
                String pizzaName = readStringInput() ;
                System.out.print("Enter the new price: ");
                double newPrice = in.nextDouble();
                Pizza pizzaToUpdate = pizzaService.findPizzaByNameInMenu(pizzaName);
                pizzaService.updatePizzaPrice(pizzaToUpdate, newPrice);
                System.out.println("Price updated successfully.");
               
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                in.nextLine();
            } catch (PizzaNotFound e) {
                System.out.println(e.getMessage());
            }
        }


    public static void deletePizza() {
        try {
            System.out.println("Choose a pizza to delete: ");
            System.out.println();
            for (Pizza pizza : pizzaStore.getAllAvailablePizzas()) {
                System.out.println(pizza.getPizzaName());
            }
            in.nextLine(); 
            System.out.print("Enter the name of the pizza to delete: ");
            String pizzaName = readStringInput() ;

            Pizza pizzaToDelete = pizzaService.findPizzaByNameInMenu(pizzaName);
            pizzaService.removePizzaFromMenu(pizzaToDelete);
            System.out.println("Pizza deleted successfully.");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            in.nextLine();
        } catch (PizzaNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    public static void searchPizza() {
        try {
            in.nextLine();
            System.out.print("Enter the search type (name/id/size): ");
            String searchType = in.nextLine().trim().toLowerCase();

            Pizza pizzaForSearch = null;

            switch (searchType) {
                case "name":
                    System.out.print("Enter the name of the pizza to search: ");
                    String pizzaName = in.nextLine();
                    pizzaForSearch = pizzaService.findPizzaByNameInMenu(pizzaName);
                    break;

                case "id":
                    System.out.print("Enter the ID of the pizza to search: ");
                    int pizzaId = in.nextInt();
                    in.nextLine();
                    pizzaForSearch = pizzaService.findPizzaByIdInMenu(pizzaId);
                    break;

                case "size":
                    System.out.print("Enter the size of the pizza to search: ");
                    String pizzaSize = in.nextLine();
                    pizzaForSearch = pizzaService.findPizzaBySizeInMenu(pizzaSize);
                    if (pizzaForSearch == null) {
                        throw new PizzaNotFound("Pizza with size " + pizzaSize + " not found");
                    }
                    break;

                default:
                    System.out.println("Invalid search type");
                    return;
            }

            System.out.println("Pizza found:");
            System.out.println(pizzaForSearch);

        } catch (PizzaNotFound e) {
            System.out.println(e.getMessage());
        } 
    }

//All ABOUT CUSTOMER CONSOLE:
public static void CustomerConsole() {
            System.out.println("Welcome to Customer console !!!");
            addNewCustomer();
            while (true) {
                displayCustomerMenu();
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        orderPizza();
                        break;
                    case 2:
                        payBill();
                        break;
                    case 3:
                        viewAllPizzas();
                        break;
                    case 4:
                        viewAllOrders();
                        break;
                    case 5:
                        searchPizza();
                        break;
                    case 6:
                        leaveFeedback();
                        break;

                    case 7:
                        System.out.println("You are exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }


    public static void addNewCustomer() {
        in.nextLine();
        System.out.print("\nEnter your name: ");
        String customerName = readStringInput() ;
        System.out.print("Enter your mobile: ");
        long customerMobile = in.nextLong();
        in.nextLine(); 
        String customerEmail;
            while (true) {
                System.out.print("Enter your email: ");
                customerEmail = in.nextLine();
                if (customerEmail.contains("@") && customerEmail.endsWith("sdu.kz")) {
                    break;
                } else {
                    System.out.println("Invalid email. Please enter an email that contains '@' and ends with 'sdu.kz'");
                }
        }



        Customer existingCustomer = pizzaStore.findCustomerByNamePhoneEmail(customerName, customerMobile, customerEmail);
        
        if (existingCustomer != null) {

            newCustomer = existingCustomer;
            System.out.println("\nWelcome back, " + existingCustomer.getCustomerName());

        } else {

            System.out.print("\nEnter your state: ");
            String customerState = readStringInput() ;
            System.out.print("Enter your district: ");
            String customerDistrict = readStringInput() ;
            System.out.print("Enter your city: ");
            String customerCity = readStringInput() ;
            System.out.print("Enter your street: ");
            String customerStreet = readStringInput() ;
            System.out.print("Enter your doorNumber: ");
            int doorNumber = in.nextInt();
            in.nextLine(); 

            Address address = new Address(customerState, customerDistrict, customerCity, customerStreet, doorNumber);
            newCustomer = new Customer(address, customerMobile, customerEmail, customerName);
            pizzaStore.addCustomer(newCustomer);

            System.out.println("\nWe added you as our new customer");
            System.out.println(newCustomer);
            System.out.println();
            System.out.println(address);
        }
    }



    public static void orderPizza() {
        try {
            in.nextLine();
            System.out.print("Enter the name of the pizza to order: ");
            String pizzaName = in.nextLine();

            Pizza selectedPizza = pizzaService.findPizzaByNameInMenu(pizzaName);
            if (selectedPizza == null) {
                throw new PizzaNotFound("Pizza not found. Please enter a valid pizza name.");
            }

            System.out.print("Enter the quantity: ");
            int quantity = in.nextInt();
            in.nextLine(); 

            Order order = new Order("Pizza order", selectedPizza.getPrice() * quantity, getCurrentDate(), orderIdCounter++, newCustomer); 
            for (int i = 0; i < quantity; i++) {
                order.addPizzaToOrder(selectedPizza); 
            }


            newCustomer.addOrder(order);

            System.out.println("Order placed successfully:");
            System.out.println(order);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            in.nextLine(); 
        } catch (PizzaNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    public static void payBill() {
        try {
            in.nextLine();
            System.out.print("Enter your customer ID: ");
            int customerId = in.nextInt();


            Customer customer = pizzaStore.findCustomerById(customerId);
            
            if (customer == null) {
                System.out.println("Customer not found. Please enter a valid customer ID.");
                return;
            }

            double totalBill = customer.calculateTotalBill();

            System.out.println("Your total bill amount is: $" + totalBill);


            System.out.println("You paid $" + totalBill);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            in.nextLine(); 
        }catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void viewAllPizzas() {
        try {
            List<Pizza> availablePizzas = pizzaStore.getAllAvailablePizzas();
            if (availablePizzas.isEmpty()) {
                System.out.println("No pizzas are available at the moment.");
                return;
            }
            System.out.println("Available Pizzas: ");
            for (Pizza pizzaDetails : availablePizzas) {
                System.out.print("\nPizza number: " + pizzaDetails.getPizzaId());
                System.out.println(pizzaDetails);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving pizzas: " + e.getMessage());
        }
    }




    public static void viewAllOrders() {
        try {
            List<Customer> customers = pizzaStore.getCustomers();
            if (customers.isEmpty()) {
                System.out.println("No orders available.");
                return;
            }

            System.out.println("All Orders:");
            for (Customer customer : customers) {
                System.out.println("\nCustomer: " + customer.getCustomerName());
                System.out.println("Phone number: " + customer.getCustomerMobile());
                System.out.println("Email: " + customer.getCustomerEmail());
                List<Order> orders = customer.getOrders();
                if (orders.isEmpty()) {
                    System.out.println("No orders for this customer.");
                    continue;
                }
                for (Order order : orders) {
                    System.out.println(order);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving orders: " + e.getMessage());
        }
    }




    public static void leaveFeedback() {
        System.out.print("Enter your order ID: ");
        int orderId = in.nextInt();
        in.nextLine(); 
        System.out.print("Enter your feedback: ");
        String feedbackText = in.nextLine();

        Order order = pizzaStore.findOrderById(orderId);
        if (order != null) {
            Feedback feedback = new Feedback(orderId, feedbackText);
            order.addFeedback(feedback);
            System.out.println("Thank you for your feedback!");
        } else {
            System.out.println("Order not found.");
        }
    }

    public static void viewAllFeedback() {
        for (Customer customer : pizzaStore.getCustomers()) {
            for (Order order : customer.getOrders()) {
                Feedback feedback = order.getFeedback();
                if (feedback != null) {
                    System.out.println(feedback);
                }
            }
        }
    }
private static String readStringInput() {
    while (true) {
        String input = in.nextLine().trim();
        if (!input.isEmpty() && !input.matches(".*\\d.*")) {
            return input;
        } else {
            System.out.print("Invalid input. Please enter a valid string without numbers: ");
        }
    }
}




}
