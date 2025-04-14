# Pizza Ordering System

## Overview
The **Pizza Ordering System** is a Java-based application designed to simulate a real-world pizza ordering experience. The system allows customers to choose a pizza, add various toppings, and finalize their orders. This project helps in understanding core concepts of object-oriented programming (OOP) while handling various customer interactions, order management, and feedback systems.

The system contains classes for managing pizzas, toppings, customer data, addresses, and feedback, as well as services for processing and handling orders. The project uses custom exceptions and basic data structures to maintain the flow of the pizza ordering process.

## Features
- **Pizza Selection**: Customers can choose a pizza base (e.g., Thin Crust, Deep Dish) and add toppings (e.g., Pepperoni, Mushrooms, Olives) to customize their pizza.
- **Customer Management**: Customers provide their personal information, including delivery address, for processing their orders.
- **Order Management**: The system processes the order, calculates the total, and generates an invoice.
- **Feedback System**: After completing an order, customers can provide feedback on their experience, which is stored for further analysis.

## Project Structure

The project is organized into several packages and classes:
PizzaOrderingSystem └── src └── pizzaordering ├── exception │ └── PizzaNotFound.java # Custom exception for pizza not found ├── model │ ├── Pizza.java # Pizza class with details about a pizza (base + toppings) │ ├── PizzaBase.java # Class defining different pizza bases │ ├── Topping.java # Class defining available pizza toppings │ ├── Address.java # Class for managing the customer's address │ ├── Customer.java # Customer class storing personal and order details │ └── Order.java # Order class to hold order details such as items, total, etc. ├── service │ └── PizzaService.java # Service class for processing orders, calculating total price, and managing orders ├── store │ └── PizzaStore.java # Store class that manages available pizzas, bases, and toppings ├── feedback │ └── Feedback.java # Class for storing and managing customer feedback └── main └── PizzaOrderingApp.java # Main class to run the application, interact with users, and execute business logic


### Package Descriptions

1. **exception**: This package contains custom exception classes. Currently, there is a single exception:
    - `PizzaNotFound.java`: This exception is thrown when a requested pizza is unavailable or cannot be found in the store.

2. **model**: This package holds the core data model classes for the system:
    - `Pizza.java`: Represents a pizza with its base and selected toppings.
    - `PizzaBase.java`: Defines the base of a pizza (e.g., Thin Crust, Deep Dish).
    - `Topping.java`: Represents toppings that can be added to a pizza (e.g., Pepperoni, Mushrooms).
    - `Address.java`: Stores customer address details for delivery purposes.
    - `Customer.java`: Stores customer details including name, phone number, and address.
    - `Order.java`: Represents a customer's order, containing the pizza, order total, and customer details.

3. **service**: This package handles the business logic of the pizza ordering system.
    - `PizzaService.java`: Manages pizza selection, calculating order totals, processing feedback, and managing customer orders.

4. **store**: This package simulates the pizza store where pizzas and toppings are stored.
    - `PizzaStore.java`: A class that manages the inventory of pizzas, bases, and toppings, and allows customers to make orders based on available items.

5. **feedback**: This package manages customer feedback.
    - `Feedback.java`: Stores customer feedback after an order is placed, including ratings and comments.

6. **main**: This package contains the entry point of the program.
    - `PizzaOrderingApp.java`: The main class to start the pizza ordering system, allowing interaction with customers and running the core application logic.

## How to Run

To run the Pizza Ordering System, follow these steps:

1. **Clone the Repository**:
   First, clone the repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/pizza-ordering-system.git
2. **Navigate to the Project Directory: Go to the directory where the project is located:**:
   cd pizza-ordering-system
3. **Compile the Code: Use the following command to compile the Java code:**
   javac src/pizzaordering/main/PizzaOrderingApp.java
4. **Run the Application: Finally, run the application:**
   java src.pizzaordering.main.PizzaOrderingApp


## Upon running the application, users will be prompted with a series of choices, including selecting a pizza base, adding toppings, entering customer information, and providing feedback on their experience.



## Usage

Once the application is launched:

1. **Choose Pizza Base**: Customers are presented with available pizza base options.
2. **Add Toppings**: Customers can select from a variety of available toppings to customize their pizza.
3. **Enter Customer Information**: Customers will be asked for their name, phone number, and delivery address.
4. **Place Order**: After finalizing the pizza, the customer can confirm the order, view the total price, and make the purchase.
5. **Leave Feedback**: Once the order is completed, customers are encouraged to provide feedback on their ordering experience.

## Dependencies

This project uses only standard Java libraries. No external dependencies are required.

## Contributing

Contributions are welcome! If you would like to contribute to this project, you can:

- Fork the repository and create a pull request with your proposed changes or improvements.
- Open an issue if you find bugs or want to suggest improvements.
- Submit a pull request for new features after discussing the proposed changes.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

