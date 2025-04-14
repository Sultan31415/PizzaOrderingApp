package pizzaordering.model;
public class PizzaBase {
    private String description;
    private String baseType;
    private String baseName;

    public PizzaBase(String baseName, String baseType, String description) {
        setDescription(description);
        setBaseType(baseType);
        setBaseName(baseName);
    }



    public String getBaseName() {
        return baseName;
    }




    public void setBaseName(String baseName) {
        if (baseName == null || baseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Base name cannot be null or empty");
        }
        this.baseName = baseName;
    }




    public String getBaseType() {
        return baseType;
    }



    public void setBaseType(String baseType) {
        if (baseType == null || baseType.trim().isEmpty()) {
            throw new IllegalArgumentException("Base type cannot be null or empty");
        }
        this.baseType = baseType;
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
        return "\nBase Details => Base Name : " + baseName + ", Base Type : " + baseType + ", Description : " + description;
    }
}
