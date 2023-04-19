package lk.ijse.hostelManagementSystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.sql.SQLException;

public interface StudentBo extends SuperBO {
     ObservableList loadAll() ;
     String save(StudentDTO d) throws Exception;
     boolean delete(String id) throws SQLException, ClassNotFoundException;
     boolean update(StudentDTO dto) throws SQLException, ClassNotFoundException;
     StudentDTO search(String id) throws SQLException, ClassNotFoundException;
}
