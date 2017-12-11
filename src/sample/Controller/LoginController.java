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
import sample.view.HospitalListView;
import sample.view.Main;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

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
    TextField signup_gender;
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

        //if (!signup_first.getText().contains("1,2,3,4,5,6,7,8,9,0"))
        //message.addNotify();
        // message.setText("no numbers in Name");
        // message.;

        // if (!signup_last.getText().contains("1,2,3,4,5,6,7,8,9,0"))
        // message.addNotify();

        //message.setText("no numbers in Name");


        for (int i=0; i <list.size(); i++) {
            if (signup_user.getText().equals(list.get(i).getUser())){
                System.out.println("same user name");}
            //message.addNotify();

            //message.setText("username Already taken");
            else{
                User newUser = new User(signup_first.getText(), signup_last.getText(),
                        signup_gender.getText(), Integer.parseInt(signup_birth.getText()),
                        signup_user.getText(), signup_email.getText(), signup_pWord.getText(),
                        signup_confirm.getText(), Integer.parseInt(signup_phone.getText()));
                System.out.println(newUser.toString());

                if ((newUser.validateEmail() == true)&&(newUser.confirmPassword()==true)){
                    System.out.println(newUser.toString());
                    list.add(newUser);
                    System.out.println(list.size());
                    System.out.println(list.get(0).getPassword() + "index 0");
                    System.out.println(signup_pWord.getText() + "current ?");
                    Stage memberStage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("Member.fxml"));
                    AnchorPane member = loader.load();
                    Scene scene = new Scene(member);
                    memberStage.setScene(scene);
                    memberStage.show();
                }
                else{
                    System.out.println("error:(");
                }

            }
        }
    }

    public void login() throws IOException {
        logged = true;
        //for (int i = 0; i < list.size(); i++) {


            //if (usNameFld.getText().equals(list.get(i).getUser())) { //&& (signup_pWord.getText().contains(list.get(i).getPassword()))) ;
              // logged = true;
               // if (logged == true) {
                    Stage memberStage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("HospitalList.fxml"));
                    AnchorPane member = loader.load();
                    Scene scene = new Scene(member);
                    memberStage.setScene(scene);
                    memberStage.show(); }
          //  }
      //  }
       // return logged;
    //}

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










