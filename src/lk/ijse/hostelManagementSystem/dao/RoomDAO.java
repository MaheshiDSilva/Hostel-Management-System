package lk.ijse.hostelManagementSystem.dao;

import lk.ijse.hostelManagementSystem.entity.Room;


public interface RoomDAO extends SuperDAO {

    boolean save(Room entity);

    boolean update(Room entity);

    Object get(Object o);

    boolean delete(String s);
}
