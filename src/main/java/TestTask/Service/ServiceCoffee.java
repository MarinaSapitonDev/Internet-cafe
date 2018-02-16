package TestTask.Service;

import TestTask.Model.CoffeeType;
import TestTask.Model.HibernateUtil;
import org.hibernate.Session;
import java.util.Iterator;
import java.util.List;


public class ServiceCoffee {

    public static List coffees=null;

    public void putInListCoffees( ){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        coffees = session.createQuery("FROM CoffeeType WHERE disabled <>  'Y' ").list();

        session.getTransaction().commit();
        session.close();


    }

    public double getPrice (String name){
        double price=0;

        for (Iterator iterator = coffees.iterator(); iterator.hasNext();){
            CoffeeType type = (CoffeeType) iterator.next();
            if(name.equals(type.getType_name()))
                price=type.getPrice();
        }
        return  price;
    }


    public int getId(String name){
        int id=0;

        for (Iterator iterator = coffees.iterator(); iterator.hasNext();){
            CoffeeType type = (CoffeeType) iterator.next();
            if(name.equals(type.getType_name()))
                id=type.getId();
        }
        return  id;
    }

}
