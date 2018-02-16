package TestTask.Model;

import java.util.List;


public class TypeQuantitys {
    private String[] types;
    private String [] quantitys;
    private List<Double> price;

    public void setPrice(List<Double> price) {
        this.price = price;
    }

    public List<Double> getPrice() {
        return price;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String[] getQuantitys() {
        return quantitys;
    }

    public void setQuantitys(String[] quantitys) {
        this.quantitys = quantitys;
    }

    public String  getQuantity(int i){return quantitys[i];}

    public String getType(int i){
        return  types[i];
    }
}
