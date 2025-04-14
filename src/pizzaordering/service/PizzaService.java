package pizzaordering.service;
import pizzaordering.model.*;
import pizzaordering.exception.*;
import pizzaordering.store.*;


import java.util.List;


public class PizzaService implements PizzaInterface {
    private PizzaStore pizzaStore;
    private List<Pizza> pizzas;

    public PizzaService(PizzaStore pizzaStore) {
        this.pizzaStore = pizzaStore;
        this.pizzas = pizzaStore.getAllAvailablePizzas();
    }

    // @Override
    // public Pizza addPizzaToMenu(Pizza pizza) {
    //     pizzas.add(pizza);
    //     return pizza;
    // }
    @Override
    public Pizza addPizzaToMenu(Pizza pizza) {
        if (pizza == null || pizza.getPizzaName() == null || pizza.getPizzaName().trim().isEmpty()) {
            throw new IllegalArgumentException("Pizza or pizza name cannot be null or empty");
        }

        for (Pizza existingPizza : pizzas) {
            if (existingPizza.getPizzaName().equals(pizza.getPizzaName())) {
                throw new IllegalArgumentException("A pizza with the name " + pizza.getPizzaName() + " already exists.");
            }
        }
        pizzas.add(pizza);
        return pizza;
    }

    @Override
    public void removePizzaFromMenu(Pizza pizza) {
        pizzas.remove(pizza);
    }

    @Override
    public Pizza updatePizzaPrice(Pizza pizza, double newPrice) {
        for (Pizza p : pizzas) {
            if (p.equals(pizza)) {
                p.setPrice(newPrice);
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Pizza> getAllPizzasFromMenu() {
        return pizzas;
    }

    @Override
    public Pizza orderNewPizza(Pizza pizza, Customer customer) {
        return pizza;
    }

    @Override

    public Pizza findPizzaByNameInMenu(String pizzaName) {
        if (pizzaName == null || pizzaName.trim().isEmpty()) {
            throw new IllegalArgumentException("Pizza name cannot be null or empty");
        }
        for (Pizza pizza : pizzas) {
            if (pizza.getPizzaName().equals(pizzaName)) {
                return pizza;
            }
        }
        throw new PizzaNotFound("Pizza with name " + pizzaName + " not found");
    }


    @Override
    public Pizza findPizzaByIdInMenu(int pizzaId) {
        if (pizzaId <= 0) {
            throw new IllegalArgumentException("Pizza ID must be positive.");
        }
        for (Pizza pizza : pizzas) {
            if (pizza.getPizzaId() == pizzaId) {
                return pizza;
            }
        }
        throw new PizzaNotFound("Pizza with ID " + pizzaId + " not found");
    }


    @Override
    public Pizza findPizzaBySizeInMenu(String pizzaSize) {
        if (pizzaSize == null || pizzaSize.trim().isEmpty()) {
            throw new IllegalArgumentException("Pizza size cannot be null or empty.");
        }
        for (Pizza pizza : pizzas) {
            if (pizza.getSize().equals(pizzaSize)) {
                return pizza;
            }
        }
        throw new PizzaNotFound("Pizza with size " + pizzaSize + " not found");
    }

}
