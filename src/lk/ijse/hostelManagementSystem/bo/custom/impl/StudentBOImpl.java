package lk.ijse.hostelManagementSystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.custom.StudentBo;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.StudentDAO;
import lk.ijse.hostelManagementSystem.dao.impl.StudentDAOImpl;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.entity.Student;
import lk.ijse.hostelManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class StudentBOImpl implements StudentBo {
    private Session session;

    private StudentBOImpl(){

    }
    private StudentDAO studentDAO;

    public static StudentBOImpl getInstance(){
        return studentBo=studentBo==null?new StudentBOImpl():studentBo;
    }
    private static StudentBOImpl studentBo;


    @Override
    public ObservableList loadAll() {
        return null;
    }

    @Override
    public String save(StudentDTO d) throws Exception {
        studentDAO = StudentDAOImpl.getInstance();
        session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        studentDAO.setSession(session);
        String save = studentDAO.save(d.toEntity());
        transaction.commit();
        session.close();
        return save;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public StudentDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
