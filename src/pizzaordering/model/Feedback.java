package pizzaordering.model;
public class Feedback {
    private final int orderId;
    private final String feedbackText;

    public Feedback(int orderId, String feedbackText) {
        this.orderId = orderId;
        this.feedbackText = feedbackText;
    }


    public int getOrderId() {
        return orderId; 
    }
    public String getFeedbackText() {
         return feedbackText;
     }

    @Override
    public String toString() {
        return "Feedback for Order ID " + orderId + ": " + feedbackText;
    }
}
