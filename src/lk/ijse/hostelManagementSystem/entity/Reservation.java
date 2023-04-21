package lk.ijse.hostelManagementSystem.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Reservation {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String resId;
    @EmbeddedId
    private ReservationPK reservationPK;
    private String date;
    private String status;
    @ManyToOne
    @JoinColumn(name = "student_id",insertable = false,updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "room_type_id",insertable = false,updatable = false)
    private Room room;

}
