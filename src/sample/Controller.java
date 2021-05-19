package sample;


import Management.Category;
import Management.FileUtils;
import User.Client;
import User.Supplier;
import Inventory.HardwareElement;
import Inventory.SoftwareElement;
import User.Bussines;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * The class Controller have to control every xml object of
 * the main window and have the main methods.
 * @author jorge.sacristan
 * @version 1.0
 */

public class Controller implements Initializable {
    @FXML
    private Button btUpdateHardwareList;
    @FXML
    private TableColumn colIdSoftware;
    @FXML
    private TableColumn colNameSoftware;
    @FXML
    private TableColumn colStockSoftware;
    @FXML
    private TableColumn colBuydateSoftware;
    @FXML
    private TableColumn colLocationSoftware;
    @FXML
    private TableColumn colIdhardware;
    @FXML
    private TableColumn colNameHardware;
    @FXML
    private TableColumn colStockHardware;
    @FXML
    private TableColumn colBuydateHardware;
    @FXML
    private TableColumn colLocationHardware;
    @FXML
    private TableView<HardwareElement> tblHardware;
    @FXML
    private TableColumn colHardwareId;
    @FXML
    private TableColumn colHardwareNombre;
    @FXML
    private TableColumn colHardwareStock;
    @FXML
    private TableColumn colHardwareBuydate;
    @FXML
    private Button btnHardware;
    @FXML
    private Button btnSoftware;
    @FXML
    private Button btnClients;
    @FXML
    private Button btnSuppliers;

    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<HardwareElement> hardwareElements = new ArrayList<HardwareElement>();
    private ArrayList<SoftwareElement> softwareElements = new ArrayList<SoftwareElement>();
    private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
    private ArrayList<Category> categories = new ArrayList<Category>();

    /**
     * This method will load the data from the files txt and
     * It will detect errors of file.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Initial load of data.
        clients = FileUtils.loadClients();
        categories = FileUtils.loadCategories();
        suppliers = FileUtils.loadSuppliers();
        hardwareElements = FileUtils.loadHardwareElements();
        softwareElements = FileUtils.loadSoftwareElements();

        if (clients == null || categories == null || suppliers == null || hardwareElements == null || softwareElements == null) {
            errorFileNotFound();
            return;
        }
    }

    /**
     * this method will load the hardare Window , will send to the window
     * the hardware array to manage , will get the new hardware array and
     * will call to save method to save the data.
     * @param event
     */
    @FXML
    private void hardwareWindows (ActionEvent event){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manageHardware.fxml"));
            Parent root =loader.load();

            //manageHardwareController.setHardwareElements(hardwareElements);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); //We can only use the new window.
            stage.setScene(scene);

            ManageHardwareController manageHardwareController = loader.getController();

            manageHardwareController.setHardwareElements(hardwareElements);
            manageHardwareController.setCategories(categories);
            manageHardwareController.setClients(clients);
            manageHardwareController.setSuppliers(suppliers);
            stage.showAndWait();

            this.hardwareElements=manageHardwareController.getHardwareElements();
            FileUtils.saveHardwareElements(hardwareElements);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method will load the software Window , will send to the window
     * the software array to manage , will get the new software array and
     * will call to save method to save the data.
     * @param event
     */
    @FXML
    private void softwareWindows (ActionEvent event){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manageSoftware.fxml"));
            Parent root =loader.load();

            //manageHardwareController.setHardwareElements(hardwareElements);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); //We can only use the new window.
            stage.setScene(scene);

            ManageSoftwareController manageSoftwareController = loader.getController();

            //ManageSoftwareController.setHardwareElements(hardwareElements);
            manageSoftwareController.setSoftwareElements(softwareElements);
            manageSoftwareController.setCategories(categories);
            manageSoftwareController.setClients(clients);
            manageSoftwareController.setSuppliers(suppliers);
            stage.showAndWait();

            this.softwareElements=manageSoftwareController.getSoftwareElements();
            FileUtils.saveSoftwareElements(softwareElements);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * this method will load the client Window , will send to the window
     * the client array to manage , will get the new client array and
     *  will call to save method to save the data.
     * @param event
     */
    @FXML
    private void ClientWindow (ActionEvent event){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manageClient.fxml"));
            Parent root =loader.load();

            //manageHardwareController.setHardwareElements(hardwareElements);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); //We can only use the new window.
            stage.setScene(scene);

            ManageClientController manageClientController = loader.getController();


            manageClientController.setClients(clients);
            stage.showAndWait();

            this.clients=manageClientController.getClients();
            FileUtils.saveClients(clients);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * this method will load the supplier Window , will send to the window
     * the supplier array to manage , will get the new supplier array and
     * will call to save method to save the data.
     * @param event
     */
    @FXML
    private void SupplierWindow (ActionEvent event){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manageSupplier.fxml"));
            Parent root =loader.load();


            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);

            ManageSupplierController manageSupplierController = loader.getController();
            manageSupplierController.setSupplier(suppliers);
            stage.showAndWait();

            this.suppliers=manageSupplierController.getSupplier();
            FileUtils.saveSuppliers(suppliers);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * this method will show on console an error
     * if the program doesn't find the data base files.
     */
    private static void errorFileNotFound() {
        System.out.println("File not found");
    }

}
