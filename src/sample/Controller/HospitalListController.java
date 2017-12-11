package sample.Controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import sample.Collection.MyBST;
import sample.Excel.ReadExcel;
import sample.model.Hospital;
import sample.view.HospitalListView;
import sample.view.Main;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class HospitalListController extends Application {
    @FXML
    private TableView<Hospital> hospitalTable;
    @FXML
    private TableColumn<Hospital, String> cName;
    @FXML
    private TableColumn<Hospital, String> cAddress;
    @FXML
    private TableColumn<Hospital, String> cState;
    @FXML
    private TableColumn<Hospital, String> cCity;
    @FXML
    private TableColumn<Hospital, String> cZip;
    @FXML
    private TableColumn<Hospital, String> cLat;
    @FXML
    private TableColumn<Hospital, String> cLong;
    @FXML
    private TableColumn<Hospital, String> cPhone;
    @FXML
    private TableColumn<Hospital, String> cMail;
    @FXML
    private TableColumn<Hospital, String> cPhoto;

    private HospitalListView hospitalApp;


    @FXML
    public void initialize() {
        //(URL location, ResourceBundle resources) // parameters
        // Initialize the person table with the two columns and a default map of the U.S.
       // selectedMap.addMapInializedListener(this);
        //address.bind(searchKey.textProperty());
       // to.bindBidirectional(toTextField.textProperty());
        //from.bindBidirectional(searchKey.textProperty()

        cName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        cAddress.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        cCity.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        cState.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        cZip.setCellValueFactory(cellData -> cellData.getValue().zipProperty());
        cLat.setCellValueFactory(cellData -> cellData.getValue().latitudeProperty());
        cLong.setCellValueFactory(cellData -> cellData.getValue().longitudeProperty());
        cPhone.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        cMail.setCellValueFactory(cellData ->  cellData.getValue().emailProperty());
        cPhoto.setCellValueFactory(cellData -> cellData.getValue().photoProperty());

    }


    public void setHospitalApp(HospitalListView hospitalApp) {
        this.hospitalApp = hospitalApp;
        hospitalTable.setItems(hospitalApp.getHospitalData());
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public HospitalListView getHospitalApp() {

        return hospitalApp;
    }
}
