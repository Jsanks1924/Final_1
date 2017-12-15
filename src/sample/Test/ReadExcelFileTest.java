package sample.Test;

import org.junit.Test;
import sample.Collection.MyBST;
import sample.Excel.ReadExcel;
import sample.model.Hospital;

import java.util.List;

/**
 * Created by tkanchanawanchai6403 on 7/25/2016.
 */
public class ReadExcelFileTest {
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String latitude;
    private String longitude;
    private String phone;
    private String photo;

    @Test
    public void excelReader() throws Exception {

        MyBST<Hospital> hospitalBSTree = new MyBST<>();
        List hospitalList = ReadExcel.excelReader("Workbook2.xls");
        ReadExcel.showExcelData(hospitalList);
       // System.out.println(hospitalList.size());}}

        for (int i = 0; i < hospitalList.size(); i++) {
            List record = (List) hospitalList.get(i);
            System.out.println(record);
            //System.out.println(record);
            //System.out.println(record.get(col));
            name = String.valueOf(record.get(0));
            streetAddress = String.valueOf(record.get(1));
            System.out.println(name + "/t" + streetAddress);
            city = String.valueOf(record.get(2));
            state = String.valueOf(record.get(3));
            zip = String.valueOf(record.get(4));
            latitude = String.valueOf(record.get(5));
            longitude = String.valueOf(record.get(6));
            phone = String.valueOf(record.get(7));
            photo = String.valueOf(record.get(8));

            Hospital hospital = new Hospital(name, streetAddress, city, state, zip, latitude, longitude, phone, photo);
            hospitalBSTree.add(hospital);}}}
/*
        Hospital element = null;
        int treeSize = hospitalBSTree.reset(BinarySearchTree.INORDER);
        System.out.println("The tree in Inorder is:");
        for (int count = 1; count <= treeSize; count++) {
            element = hospitalBSTree.getNext(BinarySearchTree.INORDER);
            System.out.println(element);
        }


    */
