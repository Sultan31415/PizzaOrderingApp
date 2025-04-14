package pizzaordering.model;
import java.util.List;


public interface PizzaInterface {
    Pizza findPizzaBySizeInMenu(String size);
    Pizza findPizzaByIdInMenu(int pizzaId);
    Pizza findPizzaByNameInMenu(String pizzaName);
    Pizza orderNewPizza(Pizza pizza, Customer customer);
    List<Pizza> getAllPizzasFromMenu();
    Pizza updatePizzaPrice(Pizza pizza, double newPrice);
    void removePizzaFromMenu(Pizza pizza);
    Pizza addPizzaToMenu(Pizza pizza) ;
}
