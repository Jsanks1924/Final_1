package sample.view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private static String photo;
    private static BorderPane rootLayout;
    private static ObservableList<Hospital> hospitalData = FXCollections.observableArrayList();

    public  HospitalListView() throws IOException {
       LoadHospital();
       initRootLayout();
       showHospitalView();
        Parent hospitalListView = FXMLLoader.load(getClass().getResource("HospitalList.fxml"));
        //hospitalListStage.setTitle("Hospital List Page");
        Scene hospitalListScene = new Scene(hospitalListView,600,600);
        hospitalListStage.setScene(hospitalListScene);
        hospitalListStage.show();
    }


    public static void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HospitalListView.class.getResource("RootLayout.fxml"));
            rootLayout = loader.load();

            Scene scene =new Scene(rootLayout);
            hospitalListStage.setScene(scene);
            hospitalListStage.show();
        } catch(IOException e){
            System.out.println("0000000000000000000"); // print test
            e.printStackTrace();
        }
    }

    public static void LoadHospital()  {
        MyBST<Hospital> hospitalTree = new MyBST<>();
        List hospitalList = null;
        try {
            hospitalList = ReadExcel.excelReader("PersonList.xls");
        } catch (Exception e) {
            System.out.println("problem yo");
            e.printStackTrace();
        }
        // ReadExcel.showExcelData(hospitalList); // print test
            for (int i = 1; i < hospitalList.size(); i++) {
                List record = (List) hospitalList.get(i);
                name =  String.valueOf(record.get(0));
                streetAddress = String.valueOf(record.get(1));
                city = String.valueOf(record.get(2));
                state = String.valueOf(record.get(3));
                zip = String.valueOf(record.get(4));
                latitude = String.valueOf(record.get(5));
                longitude = String.valueOf(record.get(6));
                email = String.valueOf(record.get(7));
                phone =String.valueOf(record.get(8));
                Hospital hospital = new Hospital(name,streetAddress,city,state,zip,latitude,longitude,email, phone, photo);
                hospitalTree.add(hospital);
                hospitalData.add(hospital);
            }

           // System.out.println(hospitalData);//print test
    }

   static public ObservableList<Hospital> getHospitalData() {
        return hospitalData;
    }

    public void showHospitalView() {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(HospitalListView.class.getResource("HospitalList.fxml"));
            AnchorPane personOverview = loader.load();
            rootLayout.setCenter(personOverview);
            HospitalListController controller = loader.getController();
            controller.setHospitalApp((HospitalListView)this.getHospitalData());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("111111111111111"); // print test
        }
        System.out.println((this.getHospitalData()+ " jjjjj"));

    }



}
