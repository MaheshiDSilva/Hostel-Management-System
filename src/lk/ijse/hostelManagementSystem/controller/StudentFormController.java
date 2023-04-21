package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
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
import lk.ijse.hostelManagementSystem.bo.custom.StudentBo;
import lk.ijse.hostelManagementSystem.bo.custom.impl.StudentBOImpl;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentFormController {
    public AnchorPane ManageStudentFormContext;
    public JFXTextField txtStdName;
    public JFXTextField txtStdId;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXTextField txtDob;
    public JFXCheckBox chbMale;
    public JFXCheckBox chbFemale;
    public TableView tableView;
    public TableColumn colStdId;
    public TableColumn colStdName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colDob;
    public TableColumn colGender;
    public Label lblId;
    public Label lblName;
    public Label lblAddress;
    public Label lblContactNo;
    public Label lblDob;
    public JFXComboBox cmbGender;

    private StudentBo studentBo= (StudentBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);


    public void initialize(){
        colStdId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colStdName.setCellValueFactory(new PropertyValueFactory<>("student_name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        try {
            ObservableList<StudentDTO> list= studentBo.loadAll();
            tableView.setItems(list);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String id=txtStdId.getText();
        String name=txtStdName.getText();
        String address=txtAddress.getText();
        String contactNo=txtContactNo.getText();
        String dob=txtDob.getText();
        String gender= (String) cmbGender.getValue();

        try {
            boolean isAdded = studentBo.save(new StudentDTO(id,name,address,contactNo,dob,gender));

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student Added!").show();
                initialize();
                clear();
                studentBo.loadAll();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                clear();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtStdId.getText();
        try {
            boolean delete = studentBo.delete(id);
            if (delete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student deleted!").show();
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
        String id=txtStdId.getText();
        String name=txtStdName.getText();
        String address=txtAddress.getText();
        String contactNo=txtContactNo.getText();
        String dob=txtDob.getText();
        String gender= (String) cmbGender.getValue();


        try {
            if(studentBo.update(new StudentDTO(id,name,address,contactNo,dob,gender))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated.!").show();
                clear();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }
    }
    public void txtStdIdOnAction(ActionEvent actionEvent) {
        String id=txtStdId.getText();
        searchData(id);
    }

    private void fillData(StudentDTO student) {
        txtStdId.setText(student.getId());
        txtStdName.setText(student.getName());
        txtAddress.setText(student.getAddress());
        txtContactNo.setText(student.getContactNo());
        txtDob.setText(student.getContactNo());
        chbMale.setText(student.getGender());
        chbFemale.setText(student.getGender());
    }

    public void searchData(String id) {

        try {
            StudentDTO studentDTO=studentBo.search(id);
            if (studentDTO != null) {
                fillData(studentDTO);
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                clear();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void clear(){
        txtStdId.clear();
        txtStdName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        txtDob.clear();

    }


    public void txtStdNameOnKeyReleased(KeyEvent keyEvent) {
        if (txtStdName.getText().equals("")) {
            lblName.setText("");
        } else {
            Pattern pattern = Pattern.compile("^[a-zA-Z]{1,}$");
            Matcher matcher = pattern.matcher(txtStdName.getText());

            boolean isMatches = matcher.matches();

            if (!isMatches) {
                lblName.setText("Invalid Name !!!");
            } else {
                lblName.setText("");
            }
        }
    }

    public void txtStdIdOnKeyReleased(KeyEvent keyEvent) {
        if (txtStdId.getText().equals("")) {
            lblId.setText("");
        } else {
            Pattern pattern = Pattern.compile("(S0)([1-9]{1})([0-9]{0,})");
            Matcher matcher = pattern.matcher(txtStdId.getText());

            boolean isMatches = matcher.matches();

            if (!isMatches) {
                lblId.setText("Invalid Id !!!");
            } else {
                lblId.setText("");
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

    public void txtDobOnKeyReleased(KeyEvent keyEvent) {
        if (txtDob.getText().equals("")) {
            lblDob.setText("");
        } else {
            Pattern pattern = Pattern.compile("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
            Matcher matcher = pattern.matcher(txtDob.getText());

            boolean isMatches = matcher.matches();

            if (!isMatches) {
                lblDob.setText("Invalid !!!");
            } else {
                lblDob.setText("");
            }
        }
    }
}
