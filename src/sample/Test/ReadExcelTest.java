package sample.Test;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import sample.Collection.MyBST;
import sample.Excel.ReadExcel;
import sample.model.Hospital;


import java.util.List;

class ReadExcelTest {
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String latitude;
    private String longitude;
    private String phone;
    private String email;
    private String photo;
    private static ObservableList<Hospital> hospitalData = FXCollections.observableArrayList();

    @Test
    void excelReader() throws Exception {
        MyBST<Hospital> hospitalTree = new MyBST<>();
        //Hospital hospital = new Hospital();
        List hospitalList = ReadExcel.excelReader("PersonList.xls");
        //ReadExcel.showExcelData(hospitalList);


        //System.out.println("Number of records in the excel document: " + hospitalList.size());

        //System.out.println("Get values of List data: ");
        for (int i = 1; i < hospitalList.size(); i++) {
            List record = (List) hospitalList.get(i);
            //System.out.println(record);
            name = (String) String.valueOf(record.get(0));
            streetAddress = String.valueOf(record.get(1));
            city = String.valueOf(record.get(2));
            state = String.valueOf(record.get(3));
            zip = String.valueOf(record.get(4));
            latitude = String.valueOf(record.get(5));
            longitude = String.valueOf(record.get(6));
            email = String.valueOf(record.get(7));
            phone =String.valueOf(record.get(8));
            photo = String.valueOf(record.get(9));


            Hospital hospital = new Hospital(name,streetAddress,city,state,zip,latitude,longitude,email, phone);
            hospitalTree.add(hospital);
            hospitalData.add(hospital);
        }

            System.out.println(hospitalData);
        }
//Hospital element= null;
        //int treesize=hospitalTree.reset(MyBST.INORDER);
       // System.out.println("the tree inorder is:");
        //for (int count =  1; count <= treesize; count++){
           // element= hospitalTree.getNext((MyBST.INORDER));
         //   System.out.println(element);
        }


