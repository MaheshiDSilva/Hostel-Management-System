package lk.ijse.hostelManagementSystem.dao.impl;

import lk.ijse.hostelManagementSystem.dao.StudentDAO;
import lk.ijse.hostelManagementSystem.entity.Student;
import lk.ijse.hostelManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Session session;
    private StudentDAOImpl(){

    }
    private static StudentDAOImpl studentDAO;

    public static StudentDAOImpl getInstance(){
        return studentDAO=studentDAO==null?new StudentDAOImpl() :studentDAO;
    }
    @Override
    public String save(Student object) {
       return (String) session.save(object);

    }

    @Override
    public void update(Student object) {

    }

    @Override
    public Student get(String s) {
        return null;
    }

    @Override
    public void delete(Student object) {

    }

    @Override
    public void setSession(Session session) {
        this.session=session;

    }

//    public boolean save(Student student) {
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(student);
//        transaction.commit();
//        session.close();
//        return true;
//    }
//
//    public boolean update(Student student){
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        session.update(student);
//        transaction.commit();
//        session.close();
//        return true;
//    }
//
//    public boolean delete(String s){
//        Session session = SessionFactoryConfig.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        Student student = session.load(Student.class, s);
//        session.delete(student);
//        transaction.commit();
//        session.close();
//        return true;
//    }
//
//    public Student search(String s){
//        return null;
//    }

}