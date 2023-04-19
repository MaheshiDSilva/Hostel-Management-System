package lk.ijse.hostelManagementSystem.util;

import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.entity.Student;
import lk.ijse.hostelManagementSystem.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfiguration;
    private  SessionFactory sessionFactory;


    private SessionFactoryConfig() {
        Configuration configuration = new Configuration().mergeProperties(Utility.getProperties())
                .addAnnotatedClass(Student.class).addAnnotatedClass(Room.class).addAnnotatedClass(User.class);
        sessionFactory=configuration.buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfiguration)
                ? factoryConfiguration = new SessionFactoryConfig()
                : factoryConfiguration;
    }

    public  Session getSession() throws HibernateException {
        // Opens a new Session through the Session Factory & returns the Session created
        return sessionFactory.openSession();
    }
}
