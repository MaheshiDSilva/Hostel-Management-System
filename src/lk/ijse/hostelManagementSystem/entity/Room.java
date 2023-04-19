package lk.ijse.hostelManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id",columnDefinition = "VARCHAR (64)")
    private String roomTypeId;
    @Column(name = "type")
    private String type;
    @Column(name = "key_money")
    private String keyMoney;
    @Column(name = "qty")
    private int qty;

    @OneToMany(mappedBy = "room")
    private List<Student>studentList=new ArrayList<>();

    public Room(String roomTypeId, String type, String keyMoney, int qty) {

    }
}
