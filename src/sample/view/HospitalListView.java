package sample.view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Collection.MyBST;
import sample.Controller.HospitalListController;
import sample.Excel.ReadExcel;
import sample.model.Hospital;
import java.io.IOException;
import java.util.List;

public class HospitalListView {
    private static Stage hospitalListStage = new Stage();
    private static String name;
    private static String streetAddress;
    private static String city;
    private static String state;
    private static String zip;
    private static String latitude;
    private static String longitude;
    private static String phone;
    private static String email;
    private static BorderPane rootLayout;
    private static ObservableList<Hospital> hospitalData = FXCollections.observableArrayList();

    public  HospitalListView() throws IOException {
       loadHospital();
       initRootLayout();
       showHospitalView();
        //Parent hospitalListView = FXMLLoader.load(getClass().getResource("HospitalList.fxml"));
        hospitalListStage.setTitle("Hospital List Page");
       // Scene hospitalListScene = new Scene(hospitalListView,600,600);
       // hospitalListStage.setScene(hospitalListScene);
      //  hospitalListStage.show();
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
            hospitalListStage.setResizable(true);

            hospitalListStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadHospital() {
        MyBST hospitalTree = new MyBST<Hospital>();
        List hospitalList = null;

        try {
            hospitalList = ReadExcel.excelReader("PersonList.xls");
        } catch (Exception e) {
            System.err.println("Problem reading  file.");
            e.printStackTrace();
        }
        //ReadExcelFile.showExcelData(restaurantList);
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
            email = String.valueOf(record.get(8));
            Hospital hospital = new Hospital(name, streetAddress, city, state, zip, latitude, longitude, phone, email);
            hospitalTree.add(hospital);
            hospitalData.add(hospital);
        }
        hospitalTree.reset(MyBST.INORDER); //Set the order of the BST as Inorder
    }


    public void showHospitalView() {
        try {
            // Load restaurant overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HospitalListView.class.getResource("PersonList.xls.fxml"));
            SplitPane restaurantOverview = loader.load();

            // Set restaurant overview into the center of root layout.
            rootLayout.setCenter(restaurantOverview);
            ScrollPane pane = new ScrollPane();
            pane.prefWidthProperty().bind(restaurantOverview.widthProperty());
            pane.prefHeightProperty().bind(restaurantOverview.heightProperty());
            pane.setContent(restaurantOverview);
            pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

            // Give the controller access to the main app.
            HospitalListController controller = loader.getController();
            controller.setHospitalApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public ObservableList<Hospital> getHospitalData() { return hospitalData; }

    public void setRestaurantData(ObservableList<Hospital> restaurantData) {
        this.hospitalData = hospitalData;
    }




}
