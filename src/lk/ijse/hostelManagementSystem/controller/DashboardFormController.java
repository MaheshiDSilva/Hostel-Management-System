package lk.ijse.hostelManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class DashboardFormController {
    public TableColumn colResId;
    public TableColumn colDate;
    public TableColumn colStdId;
    public TableColumn colRoomTypeId;
    public TableColumn colStatus;
    public TableView tableView;
    public Label lblAvailableRooms1;
    public Label lblTotalStudents;
    public Label lblBookingRooms;
    public Label lblDate;
    public Label lblTime;
    public AnchorPane DashboardFormContext;
    public AnchorPane dashboardFormContext;


    public void initialize(){
        setDate();
        setTime();
    }
    public void btnRoomOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/RoomForm");
    }

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/StudentForm");
    }

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) DashboardFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/DashboardForm.fxml"))));
        stage.centerOnScreen();
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) DashboardFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/LoginForm.fxml"))));
        stage.centerOnScreen();
    }

    private void setUi(String ui) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        dashboardFormContext.getChildren().clear();
        dashboardFormContext.getChildren().add(load);
    }

    public void btnUser1OnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/UserForm");
    }
    private void setTime(){
        LocalTime time=LocalTime.now();
        lblTime.setText(String.valueOf(time));
    }
    private void setDate(){
        LocalDate date=LocalDate.now();
        lblDate.setText(String.valueOf(date));
    }
}
