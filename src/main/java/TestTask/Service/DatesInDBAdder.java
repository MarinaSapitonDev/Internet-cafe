package TestTask.Service;

import TestTask.Model.CoffeeOrder;
import TestTask.Model.CoffeeOrderItem;
import TestTask.Model.HibernateUtil;
import org.hibernate.Session;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * добавляет необходимые данные в базу данных после подтверждения заказа
 */
public class DatesInDBAdder {
    private int order_id;
    private Session session;
    private CoffeeOrder coffeeOrder;
    private double cost;
    private List<CoffeeOrderItem> coffeeItemsList=new LinkedList<CoffeeOrderItem>();
    private List values;


   public DatesInDBAdder(CoffeeOrder coffeeOrder, double cost,List values) {
      this.coffeeOrder=coffeeOrder;
      this.cost=cost;
      this.values=values;
      setType_idsandQuatitys();
    }

    public void addDatesToDB(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        addOrder();
        addOrderItems();
        session.getTransaction().commit();
        session.close();
    }


    private void addOrder(){
        coffeeOrder.setCost(cost);
        coffeeOrder.setOrder_date(new Date());
        session.save(coffeeOrder);
        order_id=coffeeOrder.getId();
    }

    private void addOrderItems(){

     for (Iterator iterator=coffeeItemsList.iterator();iterator.hasNext();)  {
         CoffeeOrderItem item = (CoffeeOrderItem) iterator.next();
         item.setOrder_id(order_id);
         session.save(item);
     }

    }

    private void setType_idsandQuatitys(){

        ServiceCoffee sc= new ServiceCoffee();
        for (Iterator iterator = values.iterator(); iterator.hasNext();){
            CoffeeItemValues value = (CoffeeItemValues) iterator.next();
            int type_id= sc.getId(value.getType());
            CoffeeOrderItem item= new CoffeeOrderItem();
            item.setType_id(type_id);
            item.setQuantity(value.getQuantity());
            coffeeItemsList.add(item);
        }

    }


}
