package lk.ijse.hostelManagementSystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.custom.UserBo;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.impl.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.dao.impl.UserDAOImpl;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.UserDTO;
import lk.ijse.hostelManagementSystem.entity.User;

import java.sql.SQLException;

public class UserBOImpl implements UserBo {
   UserDAOImpl userDAO= (UserDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public ObservableList loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.save(new User(dto.getUserName(),dto.getPassword(),dto.getName(),dto.getContactNo(),dto.getAddress()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return userDAO.delete(id);
    }

    @Override
    public boolean update(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.update(new User(dto.getUserName(),dto.getPassword(),dto.getName(),dto.getContactNo(),dto.getAddress()));
    }

    @Override
    public RoomDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
