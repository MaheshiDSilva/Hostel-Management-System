package lk.ijse.hostelManagementSystem.dao;


import lk.ijse.hostelManagementSystem.entity.User;

public interface UserDAO extends SuperDAO{
    boolean save(User entity);

    boolean update(User entity);

    Object get(Object o);

    boolean delete(String s);
}
