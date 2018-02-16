package TestTask.Service;


import TestTask.Model.Configuration;
import TestTask.Model.HibernateUtil;
import org.hibernate.Session;
import java.util.Iterator;
import java.util.List;


public class ServiceConfiguration {

    public String getValue(String var){
     String value="";

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List conf = session.createQuery("FROM Configuration").list();
        for (Iterator iterator = conf .iterator(); iterator.hasNext();){
            Configuration configuration = (Configuration) iterator.next();
            String Id=configuration.getId();
            if (Id.equals(var))
                value=configuration.getValue();
        }
        session.getTransaction().commit();
        session.close();
        return value;
    }
}
