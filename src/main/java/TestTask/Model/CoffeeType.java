package TestTask.Model;


public class CoffeeType {

    private Integer  id;
    private String type_name;
    private double price;
    private char disabled;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setDisabled(char disabled) {
        this.disabled = disabled;
    }
    public char getDisabled() {
        return disabled;
    }

}
