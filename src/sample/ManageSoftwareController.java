package sample;

import Inventory.SoftwareElement;
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
 * The class ManageSoftwareController have to control every xml object of
 * the software window and have the  methods.
 * @author jorge.sacristan
 * @version 1.0
 */
public class ManageSoftwareController implements Initializable {
    @FXML
    private TableColumn colValiditySoftware;
    @FXML
    private TableColumn colLicenseSoftware;
    @FXML
    private TableColumn colMaintenanceSoftware;
    @FXML
    private TableColumn tcLicenseSoftware;
    @FXML
    private TableColumn tcMaintenanceSoftware;
    @FXML
    private TextField tfLicenseSoftware;
    @FXML
    private ComboBox cbMaintenanceSoftware;
    @FXML
    private TextField tfValiditySoftware;
    @FXML
    private ComboBox cbUsedSoftware;
    @FXML
    private ComboBox cbRentedSoftware;
    @FXML
    private ComboBox cbWarrantySoftware;
    @FXML
    private Button btUpdateSoftware;
    @FXML
    private Button btDeleteSoftware;
    @FXML
    private Button btAddSoftware;
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
    private TableColumn colCategorySoftware;
    @FXML
    private TableColumn colSupplierSoftware;
    @FXML
    private TableColumn colClientSoftware;
    @FXML
    private TableColumn colUsedSoftware;
    @FXML
    private TableColumn colRentedSoftware;
    @FXML
    private TableColumn colWarrantySoftware;
    @FXML
    private TableColumn colStatusSoftware;
    @FXML
    private TableView tvSoftware;
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

    private ArrayList<SoftwareElement> softwareElements;
    private ArrayList<Category> categories;
    private ArrayList<Client> clients;
    private ArrayList<Supplier> suppliers;


    private ObservableList<SoftwareElement> softwareOL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * This method will change the data of the software using
     * the data of the formulary and It will upgrade the table on the window.
     * @param event
     */
    @FXML
    private void UpgradeSoftware(ActionEvent event){
        SoftwareElement h = (SoftwareElement) this.tvSoftware.getSelectionModel().getSelectedItem();
        if(h==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("You have to select a software");
            alert.showAndWait();
        }
        else{
            try{
                String name = this.tfNombreH.getText();
                int stock = Integer.parseInt(tfStockH.getText());
                String buyDate = this.tfBuydateH.getText();
                String location = this.tfLocationH.getText();
                Category cat = (Category) this.cbCategoryH.getSelectionModel().getSelectedItem();
                Supplier sup = (Supplier) this.cbSupplierH.getSelectionModel().getSelectedItem();
                Client cli = (Client) this.cbClientrentedH.getSelectionModel().getSelectedItem();
                String newNotes = this.taNotesH.getText();
                String newLicense = this.tfLicenseSoftware.getText();
                boolean newMaintenance = this.cbMaintenanceSoftware.isFocused();
                int newValidity = Integer.parseInt(this.tfValiditySoftware.getText());


                SoftwareElement auxSoftware = new SoftwareElement(softwareElements.size()+1,name,stock,buyDate,sup,location,cat,newNotes,newLicense,newMaintenance,newValidity,cli);
                if(!this.softwareOL.contains(auxSoftware)){
                    h.setName(auxSoftware.getName());
                    h.setStock(auxSoftware.getStock());
                    h.setBuyDate(auxSoftware.getBuyDate());
                    h.setSupplier(auxSoftware.getSupplier());
                    h.setLocation(auxSoftware.getLocation());
                    h.setCategory(auxSoftware.getCategory());
                    h.setNotes(auxSoftware.getNotes());
                    h.setLicense(auxSoftware.getLicense());
                    h.setMaintenance(auxSoftware.getMaintenance());
                    h.setValidity(auxSoftware.getValidity());

                    this.tvSoftware.refresh();
                    int locationUpdateObject = softwareElements.indexOf(h);
                    softwareElements.set(locationUpdateObject,auxSoftware);

                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("The software exist already");
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
     * this method will add the data of the software using
     * the data of the formulary and It will upgrade the table on the window.
     * @param event
     */
    @FXML
    private void AddSoftware(ActionEvent event){
        try{
            String name = this.tfNombreH.getText();
            int stock = Integer.parseInt(tfStockH.getText());
            String buyDate = this.tfBuydateH.getText();
            String location = this.tfLocationH.getText();
            Category cat = (Category) this.cbCategoryH.getSelectionModel().getSelectedItem();
            Supplier sup = (Supplier) this.cbSupplierH.getSelectionModel().getSelectedItem();
            Client cli = (Client) this.cbClientrentedH.getSelectionModel().getSelectedItem();
            String newNotes = this.taNotesH.getText();
            String newLicense = this.tfLicenseSoftware.getText();
            boolean newMaintenance = this.cbMaintenanceSoftware.isFocused();
            int newValidity = Integer.parseInt(this.tfValiditySoftware.getText());

            SoftwareElement newSoftware = new SoftwareElement(softwareElements.size()+1,name,stock,buyDate,sup,location,cat,newNotes,newLicense,newMaintenance,newValidity,cli);
            if(!this.softwareOL.contains(newSoftware)){
                this.softwareOL.add(newSoftware);
                this.tvSoftware.refresh();
                softwareElements.add(newSoftware);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("The software exist already");
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

    /**
     * This method will select a software object of the window table
     *  and It will write the data of the client on the formulary
     * @param event
     */
    @FXML
    private void seleccionar (MouseEvent event){
        SoftwareElement h = (SoftwareElement) this.tvSoftware.getSelectionModel().getSelectedItem();


        if(h!=null) {
            this.tfNombreH.setText(h.getName());
            this.tfStockH.setText(h.getStock() + "");
            this.tfBuydateH.setText(h.getBuyDate());
            this.tfLocationH.setText(h.getLocation());
            this.cbCategoryH.setValue(h.getCategory());
            this.cbSupplierH.setValue(h.getSupplier());
            this.cbClientrentedH.setValue(h.getClientRented());
            this.tfLicenseSoftware.setText(h.getLicense());
            if(h.getMaintenance()==true){
                this.cbMaintenanceSoftware.setValue(true);
            }
            else
                this.cbMaintenanceSoftware.setValue(false);

            this.tfValiditySoftware.setText(h.getValidity()+"");
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
     * this method will delete on the window table a software.
     * @param event
     */
    @FXML
    private void DeleteSoftware (ActionEvent event){
        SoftwareElement h = (SoftwareElement) this.tvSoftware.getSelectionModel().getSelectedItem();
        if(h==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("You must select a software");
            alert.showAndWait();
        }
        else{
            this.softwareOL.remove(h);
            this.tvSoftware.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("You deleted the software");
            alert.showAndWait();

            softwareElements.remove(h);
        }
    }

    /**
     * this method will come back the array of software.
     * @return
     */
    public ArrayList<SoftwareElement> getSoftwareElements() {
        return this.softwareElements;
    }

    /**
     * This method will load the array of software and show on the table window.
     * @param softwareElements
     */
    public void setSoftwareElements(ArrayList<SoftwareElement> softwareElements) {
        this.softwareElements = softwareElements;
        softwareOL = FXCollections.observableArrayList();
        cbMaintenanceSoftware.getItems().addAll(true,false);

        this.colIdSoftware.setCellValueFactory(new PropertyValueFactory("id"));
        this.colNameSoftware.setCellValueFactory(new PropertyValueFactory("name"));
        this.colStockSoftware.setCellValueFactory(new PropertyValueFactory("stock"));
        this.colBuydateSoftware.setCellValueFactory(new PropertyValueFactory("buyDate"));
        this.colLocationSoftware.setCellValueFactory(new PropertyValueFactory("location"));
        this.colCategorySoftware.setCellValueFactory(new PropertyValueFactory("category"));
        this.colSupplierSoftware.setCellValueFactory(new PropertyValueFactory("supplier"));

        this.colLicenseSoftware.setCellValueFactory(new PropertyValueFactory("license"));
        this.colMaintenanceSoftware.setCellValueFactory(new PropertyValueFactory("maintenance"));
        this.colValiditySoftware.setCellValueFactory(new PropertyValueFactory("validity"));

        if(softwareElements.size()>0)
        {
            for(int i=0;i<softwareElements.size();i++)
            {
                softwareOL.add(softwareElements.get(i));
            }
        }
        this.tvSoftware.setItems(softwareOL);

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
     * This method will load de array of clients
     * @param clients
     */
    public void setClients (ArrayList<Client> clients){
        this.clients=clients;
        ObservableList<Client> cli1 = FXCollections.observableArrayList(this.clients);
        cbClientrentedH.setItems(cli1);
    }
}
