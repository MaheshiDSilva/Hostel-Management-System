package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class ClickHereFormController {
    public AnchorPane clickhereId;
    public JFXTextField txtUserName;
    public JFXTextField txtName;
    public JFXTextField txtPassword;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) clickhereId.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/LoginForm.fxml"))));
        stage.centerOnScreen();
    }


}
