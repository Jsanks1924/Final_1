package sample.Controller;


import Hash.MyHashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.model.User;
import sample.view.Main;

import java.io.IOException;


public class Controller{

    //private static Stack<User>list = new Stack();
    private static MyHashMap<Integer, User> list = new MyHashMap<Integer, User>();
    private static boolean logged;
    private static int count = 0;
  private static String gender;
    ObservableList<String> genderList = FXCollections.observableArrayList
            ("female", "male", "non-binary", "prefer not to say");
    AnchorPane member;

    @FXML
    TextField usNameFld;
    @FXML
    PasswordField psWordFld;
    @FXML
    TextField signup_first;
    @FXML
    TextField signup_last;
    @FXML
    TextField signup_user;
    @FXML
    TextField signup_email;
    @FXML
    PasswordField signup_pWord;
    @FXML
    PasswordField signup_confirm;
    @FXML
    PasswordField signup_ssn;
    @FXML
    TextField signup_phone;
    @FXML
    DatePicker date;
    @FXML
    ChoiceBox genderChoice;
    @FXML
    private void  initialize(){ //fix
        ChoiceBox<String> genderChoice = new ChoiceBox<>();
        genderChoice.setValue("unknown");
        System.out.println(genderChoice.getValue());
        genderChoice.show();
        genderChoice.setItems(genderList);
        genderChoice.getItems();


    }

    public void showSignupView() throws IOException {
        Stage signUpStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("signUp.fxml"));
        AnchorPane SignUpScene = loader.load();
        Scene scene = new Scene(SignUpScene);
        signUpStage.setScene(scene);
        signUpStage.show();


    }

    public void exitPrompt() {
        System.exit(0);
    }



    public void signSubmit() throws IOException {
        gender = "unknown"; // fix
        User newUser = new User(signup_first.getText(), signup_last.getText(),gender, date.getValue(), Integer.parseInt(signup_ssn.getText()), signup_user.getText(),
                signup_email.getText(), signup_pWord.getText(), signup_confirm.getText(), Integer.parseInt(signup_phone.getText()));

        System.out.println(newUser.toString());// print
        /*if (newUser.validateFirst()!=true){
 //error message for first name
}else if(newUser.validateLast()!=true){
    //error mesage for last name
}else if(newUser.validateDate()!=true){
//error message for date
}else if(newUser.validateEmail()!=true){
//error message for email
}else if(newUser.validatePhone()!=true){
//error message for phone #
}else if(newUser.validateSsn()!=true){
//error message for social
{
 if (newUser.confirmPassword()!=true){
    //error message for pascode field
}
else
*/
        list.add(count, newUser);
        count++;
        Stage memberStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Member.fxml"));
        AnchorPane member = loader.load();
        Scene scene = new Scene(member);
        memberStage.setScene(scene);
        memberStage.show();
 
    }



    public boolean login() throws IOException {
        logged = false;
        for (int i = 0; i < list.size(); i++) {


            if (usNameFld.getText().equals(list.get(i).getUser())) { //&& (signup_pWord.getText().contains(list.get(i).getPassword()))) ;
                logged = true;
                if (logged == true) {
                    Stage memberStage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("Member.fxml"));
                    AnchorPane member = loader.load();
                    Scene scene = new Scene(member);
                    memberStage.setScene(scene);
                    memberStage.show();
                }
            }
        }
        return logged;
    }

    public void signOut() throws IOException {
        logged = false;
        Stage memberStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Start.fxml"));
        AnchorPane member = loader.load();
        Scene scene = new Scene(member);
        memberStage.setScene(scene);
        memberStage.show();

    }

}











