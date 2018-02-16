package TestTask.Model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.io.FileInputStream;
import java.util.Properties;

public class HibernateUtil {


    private static SessionFactory sessionFactory=buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {

            Properties properties = new Properties();
            String path=System.getProperty("config.path");
            properties.load(new FileInputStream(path));

            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml").addProperties(properties);

            ServiceRegistry serviceRegistry   = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}