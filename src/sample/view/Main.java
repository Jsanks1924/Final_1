package sample.view;

import Hash.MyHashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.model.User;

import java.io.IOException;

public class Main extends Application {
private Stage primaryStage;
private AnchorPane mainLayout;



        @Override
        public void start(Stage primaryStage) throws Exception{
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("welcome");
            showMainView();
        }

        public void showMainView() throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Start.fxml"));
            mainLayout = loader.load();
            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }}