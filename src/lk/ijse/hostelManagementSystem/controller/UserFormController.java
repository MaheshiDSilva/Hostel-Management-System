package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.RoomBo;
import lk.ijse.hostelManagementSystem.bo.custom.UserBo;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.UserDTO;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserFormController {
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public JFXTextField txtName;
    public JFXTextField txtContactNo;
    public JFXTextField txtAddress;
    public TableView tableView;
    public TableColumn colUserName;
    public TableColumn colPassword;
    public TableColumn colName;
    public TableColumn colContactNo;
    public TableColumn colAddress;
    public AnchorPane UserFormContext;
    public Label lblUserName;
    public Label lblPassword;
    public Label lblName;
    public Label lblContactNo;
    public Label lblAddress;

    private UserBo userBo= (UserBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize(){
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));


        try {
            ObservableList<UserDTO>list=userBo.loadAll();
            tableView.setItems(list);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        }

    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String userName =txtUserName.getText();
        String password=txtPassword.getText();
        String name=txtName.getText();
        String contactNo=txtContactNo.getText();
        String address=txtAddress.getText();

        try {
            boolean isAdded = userBo.save(new UserDTO(userName,password,name,contactNo,address));

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
                initialize();
                clear();
                userBo.loadAll();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                clear();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String userName= txtUserName.getText();
        try {
            boolean delete = userBo.delete(userName);
            if (delete) {
                new Alert(Alert.AlertType.CONFIRMATION, "User deleted!").show();
                initialize();
                clear();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                clear();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        try {
            boolean update = userBo.update(new UserDTO(txtUserName.getText(),txtPassword.getText(),txtName.getText(),txtContactNo.getText(),txtAddress.getText()));
            if (update) {
                new Alert(Alert.AlertType.CONFIRMATION, "User updated!").show();
                initialize();
                clear();
                userBo.loadAll();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            clear();
        }
    }

    public void clear(){
        txtUserName.clear();
        txtPassword.clear();
        txtName.clear();
        txtContactNo.clear();
        txtAddress.clear();
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

    public void txtAddressOnKeyReleased(KeyEvent keyEvent) {
    }
}
