package TestTask.Model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import java.io.Serializable;


public class CoffeeOrderItem implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "OrderItem _seq_gen")
    @SequenceGenerator(name = "OrderItem _seq_gen", sequenceName = "Item _seq")
    private Integer id;
    private Integer type_id;
    private Integer order_id;
    private Integer quantity;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public Integer getQuantity() {
        return quantity;
    }


}
