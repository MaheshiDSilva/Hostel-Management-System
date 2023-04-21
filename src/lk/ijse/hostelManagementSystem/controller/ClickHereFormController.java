package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClickHereFormController {
    public AnchorPane clickhereId;
    public JFXTextField txtUserName;
    public JFXTextField txtName;
    public JFXTextField txtPassword;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public Label lblUserName;
    public Label lblPassword;
    public Label lblName;
    public Label lblContactNo;
    public Label lblAddress;

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) clickhereId.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/LoginForm.fxml"))));
        stage.centerOnScreen();
    }


    public void txtUserNameOnKeyReleased(KeyEvent keyEvent) {
        if (txtUserName.getText().equals("")) {
            lblUserName.setText("");
        } else {
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{1,}$");
            Matcher matcher = pattern.matcher(txtUserName.getText());

            boolean isMatches = matcher.matches();

            if (!isMatches) {
                lblUserName.setText("Invalid UserName !!!");
            } else {
                lblUserName.setText("");
            }
        }
    }

    public void txtPasswordOnKeyReleased(KeyEvent keyEvent) {
        if (txtPassword.getText().equals("")) {
            lblPassword.setText("");
        } else {
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{1,}$");
            Matcher matcher = pattern.matcher(txtPassword.getText());

            boolean isMatches = matcher.matches();

            if (!isMatches) {
                lblPassword.setText("Invalid Password !!!");
            } else {
                lblPassword.setText("");
            }
        }
    }

    public void txtNameOnKeyReleased(KeyEvent keyEvent) {
        if (txtName.getText().equals("")) {
            lblName.setText("");
        } else {
            Pattern pattern = Pattern.compile("^[a-zA-Z]{1,}$");
            Matcher matcher = pattern.matcher(txtName.getText());

            boolean isMatches = matcher.matches();

            if (!isMatches) {
                lblName.setText("Invalid Name !!!");
            } else {
                lblName.setText("");
            }
        }
    }

    public void txtAddressOnKeyReleased(KeyEvent keyEvent) {
    }

    public void txtContactNoOnKeyReleased(KeyEvent keyEvent) {
        if (txtContactNo.getText().equals("")) {
            lblContactNo.setText("");
        } else {
            Pattern pattern = Pattern.compile("^[0]{1}[7]{1}[01245678]{1}[0-9]{7}$");
            Matcher matcher = pattern.matcher(txtContactNo.getText());

            boolean isMatches = matcher.matches();

            if (!isMatches) {
                lblContactNo.setText("Invalid Mobile No !!!");
            } else {
                lblContactNo.setText("");
            }
        }
    }
}
