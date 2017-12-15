package sample.view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Collection.MyBST;
import sample.Controller.HospitalListController;
import sample.model.Hospital;
import sample.Excel.ReadExcel;



import java.io.IOException;
import java.util.List;

/**
 * Created by tkanchanawanchai6403 on 7/25/2016.
 */
public class HospitalListView {
    private static Stage hospitalListStage = new Stage();
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String latitude;
    private String longitude;
    private String phone;
    private String photo;
    private ObservableList<Hospital> hospitalData = FXCollections.observableArrayList();
    private MyBST<Hospital> hospitalBSTree;
    private BorderPane rootLayout;

    public HospitalListView() throws IOException {

        loadHospital();
        initRootLayout();
        showHospitalView();
        //   Parent hospitalListView = FXMLLoader.load(getClass().getResource("HospitalListJavaFx.fxml"));
        hospitalListStage.setTitle("Hospital List Page");
        //  Scene hospitalListScene = new Scene(hospitalListView, 575, 575);
        // hospitalListStage.setScene(hospitalListScene);
        // hospitalListStage.show();
    }

    public MyBST<Hospital> getHospitalBSTree() {
        return hospitalBSTree;
    }

    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HospitalListView.class.getResource("RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            hospitalListStage.setScene(scene);
            hospitalListStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadHospital() {
        hospitalBSTree = new MyBST<>();
        List hospitalList = null;
        try {
            hospitalList = ReadExcel.excelReader("Workbook2.xls");
        } catch (Exception e) {
            System.err.println("Problem reading HospitalLis.xls file");
            e.printStackTrace();
        }
        //ReadExcelFile.showExcelData(hospitalList);
        for (int i = 0; i < hospitalList.size(); i++) {
            List record = (List) hospitalList.get(i);
            //System.out.println(record);
            //System.out.println(record.get(col));
            name = String.valueOf(record.get(0));
            streetAddress = String.valueOf(record.get(1));
            city = String.valueOf(record.get(2));
            state = String.valueOf(record.get(3));
            zip = String.valueOf(record.get(4));
            latitude = String.valueOf(record.get(5));
            longitude = String.valueOf(record.get(6));
            phone = String.valueOf(record.get(7));
            photo = String.valueOf(record.get(8));
            Hospital hospital = new Hospital(name, streetAddress, city, state, zip, latitude, longitude,phone,  photo);
            hospitalBSTree.add(hospital);
            hospitalData.add(hospital);
        }
    }

    public void showHospitalView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HospitalListView.class.getResource("HospitalList.fxml"));
            AnchorPane hospitalOverview = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(hospitalOverview);

            // Give the controller access to the main app.
            HospitalListController controller = loader.getController();
            controller.setHospitalApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the data as an observable list of Hospitals.
     *
     * @return
     */
    public ObservableList<Hospital> getHospitalData() {
        return hospitalData;
    }

    public void setHospitalData(ObservableList<Hospital> hospitalData) {
        this.hospitalData = hospitalData;
    }
}