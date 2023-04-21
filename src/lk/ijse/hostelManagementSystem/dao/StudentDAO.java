package lk.ijse.hostelManagementSystem.dao;


import lk.ijse.hostelManagementSystem.entity.Student;

public interface StudentDAO extends SuperDAO {
    boolean save(Student entity);

    boolean update(Student entity);

    Object get(Object o);

    boolean delete(String s);
}
