package sample;

import Inventory.HardwareElement;
import Inventory.SoftwareElement;
import Management.Category;
import Management.FileUtils;
import User.Client;
import User.Supplier;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class
 * will initialize the application.
 */
public class Main extends Application {

    //This method will load the first window of the program .
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ControlIT");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();
    }

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
