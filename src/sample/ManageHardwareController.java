package sample;

import Inventory.HardwareElement;
import Management.Category;
import User.Client;
import User.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * The class ManageHardwareController have to control every xml object of
 * the hardware window and have the  methods.
 * @author jorge.sacristan
 * @version 1.0
 */
public class ManageHardwareController implements Initializable {

    @FXML
    private ComboBox cbUsedHardware;
    @FXML
    private ComboBox cbRentedHardware;
    @FXML
    private ComboBox cbWarrantyHardware;
    @FXML
    private Button btUpdateHardware;
    @FXML
    private Button btDeleteHardware;
    @FXML
    private Button btAddHardware;
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
    private TableColumn colCategoryHardware;
    @FXML
    private TableColumn colSupplierHardware;
    @FXML
    private TableColumn colClientHardware;
    @FXML
    private TableColumn colUsedHardware;
    @FXML
    private TableColumn colRentedHardware;
    @FXML
    private TableColumn colWarrantyHardware;
    @FXML
    private TableColumn colStatusHardware;
    @FXML
    private TableView tvHardware;
    @FXML
    private TextField tfNombreH;
    @FXML
    private TextField tfStockH;
    @FXML
    private TextField tfBuydateH;
    @FXML
    private TextField tfLocationH;
    @FXML
    private TextArea taNotesH;
    @FXML
    private ComboBox cbClientrentedH;
    @FXML
    private ComboBox cbCategoryH;
    @FXML
    private ComboBox cbSupplierH;
    @FXML
    private RadioButton rbUsedTrueH;
    @FXML
    private RadioButton rbUsedFalseH;
    @FXML
    private RadioButton tbRentedTrueH;
    @FXML
    private RadioButton tbRentedFalseH;
    @FXML
    private RadioButton tbWarrantyTrueH;
    @FXML
    private RadioButton tbWarrantyFalseH;
    @FXML
    private TextField tfStatusH;

    private ArrayList<HardwareElement> hardwareElements;
    private ArrayList<Category> categories;
    private ArrayList<Client> clients;
    private ArrayList<Supplier> suppliers;


    private ObservableList<HardwareElement> hardwareOL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * This method will change the data of the hardware using
     * the data of the formulary and It will upgrade the table on the window.
     * @param event
     */
    @FXML
    private void UpgradeHardware(ActionEvent event){
        HardwareElement h = (HardwareElement) this.tvHardware.getSelectionModel().getSelectedItem();
        if(h==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("You have to select a hardware item");
            alert.showAndWait();
        }
        else{

            try{
                String name = this.tfNombreH.getText();
                int stock = Integer.parseInt(tfStockH.getText()+1);
                String buyDate = this.tfBuydateH.getText();
                String location = this.tfLocationH.getText();
                Category cat = (Category) this.cbCategoryH.getSelectionModel().getSelectedItem();
                Supplier sup = (Supplier) this.cbSupplierH.getSelectionModel().getSelectedItem();
                Client cli = (Client) this.cbClientrentedH.getSelectionModel().getSelectedItem();
                String newNotes = this.taNotesH.getText();
                boolean newUsed = this.cbUsedHardware.isFocused();
                boolean newRented = this.cbRentedHardware.isFocused();
                boolean newWarranty = this.cbWarrantyHardware.isFocused();
                String newStatus = this.tfStatusH.getText();

                HardwareElement auxHardware = new HardwareElement(hardwareElements.size(),name,stock,buyDate,sup,location,cat,newNotes,newRented,cli,newStatus,newWarranty,newUsed);

                if(!this.hardwareOL.contains(auxHardware)){
                    h.setName(auxHardware.getName());
                    h.setStock(auxHardware.getStock());
                    h.setBuyDate(auxHardware.getBuyDate());
                    h.setSupplier(auxHardware.getSupplier());
                    h.setLocation(auxHardware.getLocation());
                    h.setCategory(auxHardware.getCategory());
                    h.setNotes(auxHardware.getNotes());
                    h.setRented(auxHardware.getRented());
                    h.setPersonRented(auxHardware.getPersonRented());
                    h.setStatus(auxHardware.getStatus());
                    h.setWarranty(auxHardware.getWarranty());
                    h.setUsed(auxHardware.getUsed());

                    this.tvHardware.refresh();
                    int locationUpdateObject = hardwareElements.indexOf(h);
                    hardwareElements.set(locationUpdateObject,auxHardware);


                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("The hardware existe already");
                    alert.showAndWait();
                }
            }catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Wrong Format" + e.getMessage());
                alert.showAndWait();
            }

        }
    }

    /**
     * this method will add the data of the hardware using
     * the data of the formulary and It will upgrade the table on the window.
     * @param event
     */
    @FXML
    private void AddHardware(ActionEvent event){
        try{
            String name = this.tfNombreH.getText();
            int stock = Integer.parseInt(tfStockH.getText());
            String buyDate = this.tfBuydateH.getText();
            String location = this.tfLocationH.getText();
            Category cat = (Category) this.cbCategoryH.getSelectionModel().getSelectedItem();
            Supplier sup = (Supplier) this.cbSupplierH.getSelectionModel().getSelectedItem();
            Client cli = (Client) this.cbClientrentedH.getSelectionModel().getSelectedItem();
            String newNotes = this.taNotesH.getText();
            boolean newUsed = this.cbUsedHardware.isFocused();
            boolean newRented = this.cbRentedHardware.isFocused();
            boolean newWarranty = this.cbWarrantyHardware.isFocused();
            String newStatus = this.tfStatusH.getText();

            HardwareElement newHardware = new HardwareElement(hardwareElements.size()+1,name,stock,buyDate,sup,location,cat,newNotes,newRented,cli,newStatus,newWarranty,newUsed);
            if(!this.hardwareOL.contains(newHardware)){
                this.hardwareOL.add(newHardware);
                this.tvHardware.refresh();
                hardwareElements.add(newHardware);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("The hardware existe already");
                alert.showAndWait();
            }
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Wrong Format" + e.getMessage());
            alert.showAndWait();
        }

    }

    /**
     * This method will select a hardware object of the window table
     * and It will write the data of the client on the formulary
     * @param event
     */
    @FXML
    private void seleccionar (MouseEvent event){
        HardwareElement h = (HardwareElement) this.tvHardware.getSelectionModel().getSelectedItem();


        if(h!=null) {
            this.tfNombreH.setText(h.getName());
            this.tfStockH.setText(h.getStock() + "");
            this.tfBuydateH.setText(h.getBuyDate());
            this.tfLocationH.setText(h.getLocation());
            this.cbCategoryH.setValue(h.getCategory());
            this.cbSupplierH.setValue(h.getSupplier());
            this.cbClientrentedH.setValue(h.getPersonRented());
            if (h.getUsed() == true) {
                this.cbUsedHardware.setValue(true);
            } else
                this.cbUsedHardware.setValue(false);


            if (h.getRented() == true) {
                this.cbRentedHardware.setValue(true);
            } else
                this.cbRentedHardware.setValue(false);

            if (h.getWarranty() == true) {
                this.cbWarrantyHardware.setValue(true);
            } else
                this.cbWarrantyHardware.setValue(false);

            this.tfStatusH.setText(h.getStatus());
            this.taNotesH.setText(h.getNotes());
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Wrong selection");
            alert.showAndWait();
        }
    }

    /**
     * this method will delete on the window table a hardware.
     * @param event
     */
    @FXML
    private void DeleteHardware (ActionEvent event){
        HardwareElement h = (HardwareElement) this.tvHardware.getSelectionModel().getSelectedItem();
        if(h==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("You must select a hardware");
            alert.showAndWait();
        }
        else{
            this.hardwareOL.remove(h);
            this.tvHardware.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("You have deleted the hardware");
            alert.showAndWait();

            hardwareElements.remove(h);
        }
    }

    /**
     * this method will come back the array of hardware.
     * @return
     */
    public ArrayList<HardwareElement> getHardwareElements() {
        return hardwareElements;
    }

    //This method will load the array of hardware and show on the table window.
    public void setHardwareElements(ArrayList<HardwareElement> hardwareElements) {
        this.hardwareElements = hardwareElements;
        hardwareOL = FXCollections.observableArrayList();
        cbUsedHardware.getItems().addAll(true,false);
        cbRentedHardware.getItems().addAll(true,false);
        cbWarrantyHardware.getItems().addAll(true,false);


        this.colIdhardware.setCellValueFactory(new PropertyValueFactory("id"));
        this.colNameHardware.setCellValueFactory(new PropertyValueFactory("name"));
        this.colStockHardware.setCellValueFactory(new PropertyValueFactory("stock"));
        this.colBuydateHardware.setCellValueFactory(new PropertyValueFactory("buyDate"));
        this.colLocationHardware.setCellValueFactory(new PropertyValueFactory("location"));
        this.colCategoryHardware.setCellValueFactory(new PropertyValueFactory("category"));
        this.colSupplierHardware.setCellValueFactory(new PropertyValueFactory("supplier"));
        this.colClientHardware.setCellValueFactory(new PropertyValueFactory("personRented"));
        this.colUsedHardware.setCellValueFactory(new PropertyValueFactory("used"));
        this.colRentedHardware.setCellValueFactory(new PropertyValueFactory("rented"));
        this.colWarrantyHardware.setCellValueFactory(new PropertyValueFactory("warranty"));
        this.colStatusHardware.setCellValueFactory(new PropertyValueFactory("status"));



        if(hardwareElements.size()>0)
        {
            for(int i=0;i<hardwareElements.size();i++)
            {
                hardwareOL.add(hardwareElements.get(i));
            }
        }
        this.tvHardware.setItems(hardwareOL);

    }

    /**
     * This method will load the array of categories
     * @param categories
     */
    public void setCategories(ArrayList<Category> categories){
        this.categories=categories;
        ObservableList<Category> c1 = FXCollections.observableArrayList(this.categories);
        cbCategoryH.setItems(c1);

    }

    /**
     * This method will load the array of suppliers
     * @param suppliers
     */
    public void setSuppliers(ArrayList<Supplier> suppliers){
        this.suppliers = suppliers;
        ObservableList<Supplier> s1 = FXCollections.observableArrayList(this.suppliers);
        cbSupplierH.setItems(s1);

    }

    /**
     * this method will load de array of clients
     * @param clients
     */
    public void setClients (ArrayList<Client> clients){
        this.clients=clients;
        ObservableList<Client> cli1 = FXCollections.observableArrayList(this.clients);
        cbClientrentedH.setItems(cli1);
    }
}
