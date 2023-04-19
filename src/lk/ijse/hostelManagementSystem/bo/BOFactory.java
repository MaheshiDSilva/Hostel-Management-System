package lk.ijse.hostelManagementSystem.bo;

import lk.ijse.hostelManagementSystem.bo.custom.impl.RoomBOImpl;
import lk.ijse.hostelManagementSystem.bo.custom.impl.StudentBOImpl;
import lk.ijse.hostelManagementSystem.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;

    }

    public enum BOTypes {
        STUDENT, ROOM, USER, DASHBOARD, LOGIN
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
//            case STUDENT:
//                return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;

        }
    }
}


