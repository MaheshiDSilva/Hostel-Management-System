package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.RoomBo;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;

import java.sql.SQLException;

public class RoomFormController {
    public TableView tableView;
    public TableColumn colRoomTypeId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colRoomQty;
    public JFXComboBox cmbRoomTypeId;
    public JFXComboBox cmbType;
    public JFXComboBox cmbKeyMoney;
    public JFXTextField txtRoomsQty;

    private RoomBo roomBo= (RoomBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    public void initialize(){
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colRoomQty.setCellValueFactory(new PropertyValueFactory<>("qty"));


        try {
            ObservableList<RoomDTO>list=  roomBo.loadAll();
            tableView.setItems(list);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String roomTypeId= (String) cmbRoomTypeId.getValue();
        String type= (String) cmbType.getValue();
        String keyMoney= (String) cmbKeyMoney.getValue();
        int qty= Integer.parseInt(txtRoomsQty.getText());

        try {
            boolean isAdded = roomBo.save(new RoomDTO(roomTypeId,type,keyMoney,qty));

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room Added!").show();
                initialize();
                clear();
                roomBo.loadAll();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
                clear();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String roomTypeId= (String) cmbRoomTypeId.getValue();
        try {
            boolean delete = roomBo.delete(roomTypeId);
            if (delete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room deleted!").show();
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
            boolean update = roomBo.update(new RoomDTO(String.valueOf(cmbRoomTypeId.getValue()),String.valueOf(cmbType.getValue()), String.valueOf(cmbKeyMoney.getValue()),Integer.parseInt(txtRoomsQty.getText())));
            if (update) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room updated!").show();
                initialize();
                clear();
                roomBo.loadAll();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            clear();
        }
    }

    public void clear(){
        txtRoomsQty.clear();
    }
}
