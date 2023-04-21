package lk.ijse.hostelManagementSystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.UserDTO;

import java.sql.SQLException;

public interface UserBo extends SuperBO {
    ObservableList loadAll() throws SQLException, ClassNotFoundException;
    boolean save(UserDTO dto) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    boolean update(UserDTO dto) throws SQLException, ClassNotFoundException;
    RoomDTO search(String id) throws SQLException, ClassNotFoundException;
}
