package lk.ijse.hostelManagementSystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;

import java.sql.SQLException;

public interface RoomBo extends SuperBO {
    ObservableList loadAll() throws SQLException, ClassNotFoundException;
    boolean save(RoomDTO d) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    boolean update(RoomDTO dto) throws SQLException, ClassNotFoundException;
    RoomDTO search(String id) throws SQLException, ClassNotFoundException;
}
