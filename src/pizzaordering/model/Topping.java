package pizzaordering.model;
public class Topping {
    private String description;
    private String spiceLevel;
    private String toppingName;

    public Topping(String toppingName, String spiceLevel, String description) {
        setToppingName(toppingName);
        setSpiceLevel(spiceLevel);
        setDescription(description);
    }




    public String getToppingName() {
        return toppingName;
    }




    public void setToppingName(String toppingName) {
        if (toppingName == null || toppingName.trim().isEmpty()) {
            throw new IllegalArgumentException("Topping name cannot be null or empty");
        }
        this.toppingName = toppingName;
    }




    public String getSpiceLevel() {
        return spiceLevel;
    }





    public void setSpiceLevel(String spiceLevel) {
        if (spiceLevel == null || spiceLevel.trim().isEmpty()) {
            throw new IllegalArgumentException("Spice level cannot be null or empty");
        }
        this.spiceLevel = spiceLevel;
    }




    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = description;
    }




    @Override
    public String toString() {
        return "\nTopping Details => Name: " + toppingName + ", Spice Level: " + spiceLevel + ", Description: " + description;
    }
}
