package pizzaordering.exception;
import java.util.*;
public class PizzaNotFound extends RuntimeException {
    public PizzaNotFound(String message) {
        super(message);
    }
}
