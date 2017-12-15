package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.model.Hospital;
import sample.view.HospitalListView;
import sample.view.Main;

import java.io.IOException;

/**
 * Created by tkanchanawanchai6403 on 7/25/2016.
 */
public class HospitalListController {
    @FXML
    private TextField searchKey;
    @FXML
    private TableView<Hospital> hospitalTable;
    @FXML
    private TableColumn<Hospital, String> cName;
    @FXML
    private TableColumn<Hospital, String> cAddress;
    @FXML
    private TableColumn<Hospital, String> cCity;
    @FXML
    private TableColumn<Hospital, String> cState;
    @FXML
    private TableColumn<Hospital, String> cZip;
    @FXML
    private TableColumn<Hospital, String> cLat;
    @FXML
    private TableColumn<Hospital, String> cLong;
    @FXML
    private TableColumn<Hospital, String> cPhoto;

    // Reference to the main application.
    private HospitalListView hospitalApp;

    /*public HospitalListController() {
        searchKey.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    System.out.println(searchKey.getText());
                }
            }
        });
    }*/
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        cName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        cAddress.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        cCity.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        cState.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        cZip.setCellValueFactory(cellData -> cellData.getValue().zipProperty());
        cLat.setCellValueFactory(cellData -> cellData.getValue().latitudeProperty());
        cLong.setCellValueFactory(cellData -> cellData.getValue().longitudeProperty());
        cPhoto.setCellValueFactory(cellData -> cellData.getValue().photoProperty());
    }

    public void setHospitalApp(HospitalListView hospitalApp) {
        this.hospitalApp = hospitalApp;

        // Add observable list data to the table
        hospitalTable.setItems(hospitalApp.getHospitalData());
    }

    //search logic and update table view for the result
    public void handleEnterPressed(KeyEvent event) {
        String latitude = "";
        String longitude = "";
        String key = "";
        boolean coordinate = true;
        Hospital hospitalKey;
        ObservableList<Hospital> searchHospitalResultTable = FXCollections.observableArrayList();

        if (event.getCode() == KeyCode.ENTER) {
            key = searchKey.getText();
            System.out.println(searchKey.getText());
            //first add logic to check if key is coordinate or others
            //if key is empty
            if (key.equals("")) {
                hospitalTable.setItems(hospitalApp.getHospitalData());
            }
            //if coordinate
            if (coordinate) {
                latitude = key.split(",")[0];
                longitude = key.split(",")[1];
                System.out.println(latitude + " " + longitude);
                hospitalKey = new Hospital(latitude, longitude);
                if (hospitalApp.getHospitalBSTree().contains(hospitalKey)) {
                    //create the new observable list and add the result to this list
                    searchHospitalResultTable.add(hospitalApp.getHospitalBSTree().get(hospitalKey));
                    //set new result of search to observrable list
                    // hospitalApp.setHospitalData(searchHospitalResultTable);
                    //update view
                    hospitalTable.setItems(searchHospitalResultTable);
                } else {
                    //reset the observable list
                    searchHospitalResultTable.clear();
                    //set new result of search to observrable list
                    //hospitalApp.setHospitalData(searchHospitalResultTable);
                    //update view
                    hospitalTable.setItems(searchHospitalResultTable);

                }
            }
        }
    }
    public void exitPrompt() {
        System.exit(0);
    }

    public void signOut() throws IOException {
       boolean logged = false;
        Stage memberStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Start.fxml"));
        AnchorPane member = loader.load();
        Scene scene = new Scene(member);
        memberStage.setScene(scene);
        memberStage.show();

    }
}