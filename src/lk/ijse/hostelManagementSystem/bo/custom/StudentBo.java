package lk.ijse.hostelManagementSystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.sql.SQLException;

public interface StudentBo extends SuperBO {
     ObservableList loadAll() throws SQLException, ClassNotFoundException;
     boolean save(StudentDTO d) throws SQLException, ClassNotFoundException;
     boolean delete(String id) throws SQLException, ClassNotFoundException;
     boolean update(StudentDTO dto) throws SQLException, ClassNotFoundException;
     StudentDTO search(String id) throws SQLException, ClassNotFoundException;
}
