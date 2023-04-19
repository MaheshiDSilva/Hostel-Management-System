package lk.ijse.hostelManagementSystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.hostelManagementSystem.bo.custom.RoomBo;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.impl.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.entity.Room;

import java.sql.SQLException;

public class RoomBOImpl implements RoomBo {
    RoomDAOImpl roomDAO = (RoomDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public ObservableList loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(RoomDTO d) throws SQLException, ClassNotFoundException {
        return roomDAO.save(new Room(d.getRoomTypeId(),d.getType(),d.getKeyMoney(),d.getQty()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return roomDAO.delete(id);
    }

    @Override
    public boolean update(RoomDTO d) throws SQLException, ClassNotFoundException {
        return roomDAO.update(new Room(d.getRoomTypeId(),d.getType(),d.getKeyMoney(),d.getQty()));
    }

    @Override
    public RoomDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
