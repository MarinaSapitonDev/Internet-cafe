package TestTask.Model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;



public class CoffeeOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CoffeeOrder_seq_gen")
    @SequenceGenerator(name = "CoffeeOrder_seq_gen", sequenceName = "Order_seq")
private Integer id;
private Date order_date;
private  String   name;
    @NotEmpty
    @NotNull
    private  String  delivery_address;
    private double     cost;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public String getName() {
        return name;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public double getCost() {
        return cost;
    }
}
