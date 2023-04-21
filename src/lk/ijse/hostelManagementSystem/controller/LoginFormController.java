package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginFormController {
    public JFXPasswordField txtPassword;
    public JFXTextField txtUsername;
    public AnchorPane LoginFormContext;
    public AnchorPane loginId;
    public Label lblUserName;
    public Label lblPassword;

    public void btnCloseEyeOnAction(ActionEvent actionEvent) {
    }

    public void btnOpenEyeOnAction(ActionEvent actionEvent) {
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        setUi1("/lk/ijse/hostelManagementSystem/view/DashboardForm");
    }

    private void setUi1(String ui) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        LoginFormContext.getChildren().clear();
        LoginFormContext.getChildren().add(load);
    }
    private void setUi(String ui) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        loginId.getChildren().clear();
        loginId.getChildren().add(load);
    }

    public void btnClickHereOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/ClickHereForm");
    }

    public void txtUserNameOnKeyReleased(KeyEvent keyEvent) {

    }

    public void txtPasswordOnKeyReleased(KeyEvent keyEvent) {
    }
}
