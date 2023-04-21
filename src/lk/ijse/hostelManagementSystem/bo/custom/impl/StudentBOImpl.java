package lk.ijse.hostelManagementSystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.custom.StudentBo;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.impl.StudentDAOImpl;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.sql.SQLException;

public class StudentBOImpl implements StudentBo {
    StudentDAOImpl studentDAO = (StudentDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public ObservableList loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(StudentDTO d) throws SQLException, ClassNotFoundException {
        return studentDAO.save(new Student(d.getId(),d.getName(),d.getAddress(),d.getContactNo(),d.getDob(),d.getGender()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.delete(id);
    }

    @Override
    public boolean update(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentDAO.update(new Student(dto.getId(),dto.getName(),dto.getAddress(),dto.getContactNo(),dto.getDob(),dto.getGender()));
    }

    @Override
    public StudentDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
