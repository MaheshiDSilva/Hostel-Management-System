package lk.ijse.hostelManagementSystem.dto;

public class ReservationDTO {
    private String res_id;
    private String student_id;
    private String room_type_id;
    private String date;
    private String status;

    public ReservationDTO() {
    }

    public ReservationDTO(String res_id, String student_id, String room_type_id, String date, String status) {
        this.res_id = res_id;
        this.student_id = student_id;
        this.room_type_id = room_type_id;
        this.date = date;
        this.status = status;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(String room_type_id) {
        this.room_type_id = room_type_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "res_id='" + res_id + '\'' +
                ", student_id='" + student_id + '\'' +
                ", room_type_id='" + room_type_id + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
