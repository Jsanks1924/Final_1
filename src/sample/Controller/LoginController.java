package sample.Controller;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.model.User;
import sample.model.UserDB;
import sample.model.UserIO;
import sample.view.HospitalListView;
import sample.view.Main;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import sample.view.HospitalListView;


public class LoginController {
    private static Stack<User>list = new Stack();
    private static boolean logged;
    @FXML
    AnchorPane member;
    @FXML
    TextField signup_ssn;

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
    TextField signup_phone;
    @FXML
    TextField signup_birth;
    @FXML
    TextField signup_Gender;
    Label message = new Label();

    public LoginController() throws Exception {
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
boolean validFormat = false;
        if (signup_first.getText().contains("1,2,3,4,5,6,7,8,9,0")){
            signup_first.setStyle("-fx-background-color: red ; -fx-text-fill: white; -fx-border-color: red");
validFormat=false;}

        if (signup_last.getText().contains("1,2,3,4,5,6,7,8,9,0")){
            signup_last.setStyle("-fx-background-color: red ; -fx-text-fill: white; -fx-border-color: red");
        validFormat=false;}

        if (signup_birth.getText().contains("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z")){
            signup_birth.setStyle("-fx-background-color: red ; -fx-text-fill: white; -fx-border-color: red");
            validFormat=false;}

       // if (!signup_pWord.getText().contains("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z")
        //       || (!signup_birth.getText().contains("1,2,3,4,5,6,7,8,9,0"))
         //       ||signup_birth.getLength()<4){
         //   signup_pWord.setStyle("-fx-background-color: red ; -fx-text-fill: white; -fx-border-color: red");
         //   validFormat=false;}

        if (signup_ssn.getText().contains("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z")){
            signup_ssn.setStyle("-fx-background-color: red ; -fx-text-fill: white; -fx-border-color: red");
            validFormat=false;}

            if (!signup_Gender.getText().equalsIgnoreCase("male")
                    ||!signup_Gender.getText().equalsIgnoreCase("female")) {
                //signup_Gender.setStyle("-fx-background-color: red ; -fx-text-fill: white; -fx-border-color: red");
                validFormat=false;}

                if (signup_phone.getText().contains("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z")){
                    signup_phone.setStyle("-fx-background-color: red ; -fx-text-fill: white; -fx-border-color: red");
                    validFormat=false;}
                    else{
                    validFormat=true;
                }
        if(signup_pWord.getText().equals(signup_confirm.getText())&&(validFormat=true)) {
            User user = new User(signup_first.getText(), signup_last.getText(),
                    signup_Gender.getText(),
                    Integer.parseInt(signup_birth.getText()),
                    signup_user.getText(), signup_email.getText(), signup_pWord.getText(),
                    signup_confirm.getText(), Integer.parseInt(signup_phone.getText()));
            UserDB.getUsers().add(user);

            signOut();
        } else {
            signup_pWord.setStyle("-fx-background-color: red ; -fx-text-fill: white; -fx-border-color: red");
            signup_confirm.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-border-color: red");
        }
        System.out.println(UserDB.getUsers());
    }



boolean exist = false;
    public void login() {
        //iterate thru the userDB to find if username exists
       // for(int i = 0; i< UserDB.getUsers().size(); i++) {
            //compare uname from user input to each username from userDB
            //if (usNameFld.getText().equals(UserDB.getUsers().get(i).getUser())) {
                //&& pw.getText().equals(UserDB.getUsers().get(i).getPassword()
               // System.out.println("Welcome " +usNameFld.getText());
                try {
                    new HospitalListView();
                } catch (IOException e) {
                    System.err.println("Error opening hospital list view!");
                    e.printStackTrace();
                }
                exist = true;
            }


    public void openSignupView() throws IOException {
        System.out.println("Open signup view");
        new HospitalListView();
    }



    public void signOut() throws IOException{
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










