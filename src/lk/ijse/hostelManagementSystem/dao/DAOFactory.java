package lk.ijse.hostelManagementSystem.dao;

import lk.ijse.hostelManagementSystem.dao.impl.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.dao.impl.StudentDAOImpl;
import lk.ijse.hostelManagementSystem.dao.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        STUDENT, ROOM, USER, LOGIN
    }

    //Object creation logic for DAO objects
    public SuperDAO getDAO(DAOFactory.DAOTypes types) {
        switch (types) {
//            case STUDENT:
//                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;

        }
    }
}