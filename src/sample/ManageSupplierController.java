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
 * The class ManageSupplierController have to control every xml object of
 * the Supplier window and have the  methods.
 * @author jorge.sacristan
 * @version 1.0
 */
public class ManageSupplierController implements Initializable {
    @FXML
    private TableView tvSupplier;
    @FXML
    private TableColumn colPhoneSupplier;
    @FXML
    private TableColumn colAddressSupplier;
    @FXML
    private TableColumn colEmailSupplier;
    @FXML
    private TableColumn colBussinesnameSuppliere;
    @FXML
    private TableColumn colCifdniSupplier;
    @FXML
    private Button btUpdateSupplier;
    @FXML
    private Button btDeleteSupplier;
    @FXML
    private Button btAddSupplier;


    @FXML
    private TextField tfPhoneC;
    @FXML
    private TextField tfAddressC;
    @FXML
    private TextField tfEmailC;
    @FXML
    private TextField tfBussinesnameC;
    @FXML
    private TextField tfCifdniS;

    private ArrayList<Supplier> suppliers;
    private ObservableList<Supplier> supplierOL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * This method will change the data of the suppliers using
     * the data of the formulary and It will upgrade the table on the window.
     * @param event
     */
    @FXML
    private void UpgradeSupplier(ActionEvent event){
        Supplier h = (Supplier) this.tvSupplier.getSelectionModel().getSelectedItem();
        if(h==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("You must select a supplier");
            alert.showAndWait();
        }
        else{
            String phone = this.tfPhoneC.getText();
            String address = this.tfAddressC.getText();
            String email = this.tfEmailC.getText();
            String bussinesName = this.tfBussinesnameC.getText();
            String cifDni = this.tfCifdniS.getText();

            Supplier newSuppier = new Supplier(phone,address,cifDni,email,bussinesName);

            if(!this.supplierOL.contains(newSuppier)){
                h.setPhone(newSuppier.getPhone());
                h.setAddress(newSuppier.getAddress());
                h.setEmail(newSuppier.getEmail());
                h.setBussinesName(newSuppier.getBussinesName());
                h.setCif_dni(newSuppier.getCif_dni());

                this.tvSupplier.refresh();
                int locationUpdateObject = suppliers.indexOf(h);
                suppliers.set(locationUpdateObject,newSuppier);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("The supplier exist already");
                alert.showAndWait();
            }
        }
    }

    /**
     * This method will add the data of the suppleirs using
     * the data of the formulary and It will upgrade the table on the window.
     * @param event
     */
    @FXML
    private void AddSupplier(ActionEvent event){
        String phone = this.tfPhoneC.getText();
        String address = this.tfAddressC.getText();
        String email = this.tfEmailC.getText();
        String bussinesName = this.tfBussinesnameC.getText();
        String cifDni = this.tfCifdniS.getText();


        Supplier newSuppier = new Supplier(phone,address,cifDni,email,bussinesName);

        if(!this.supplierOL.contains(newSuppier)){
            this.supplierOL.add(newSuppier);
            this.tvSupplier.refresh();
            suppliers.add(newSuppier);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("The Supplier exist already");
            alert.showAndWait();
        }


    }

    /**
     * //This method will select a supplier object of the window table
     *     //and It will write the data of the client on the formulary
     * @param event
     */
    @FXML
    private void seleccionar (MouseEvent event){
        Supplier h = (Supplier) this.tvSupplier.getSelectionModel().getSelectedItem();


        if(h!=null) {
            this.tfPhoneC.setText(h.getPhone());
            this.tfAddressC.setText(h.getAddress());
            this.tfEmailC.setText(h.getEmail());
            this.tfBussinesnameC.setText(h.getBussinesName());
            this.tfCifdniS.setText(h.getCif_dni());
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
     *     //this method will delete on the window table a supplier.
     * @param event
     */
    @FXML
    private void DeleteSupplier (ActionEvent event){
        Supplier h = (Supplier) this.tvSupplier.getSelectionModel().getSelectedItem();
        if(h==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("You must select a supplier");
            alert.showAndWait();
        }
        else{
            this.supplierOL.remove(h);
            this.tvSupplier.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("You have deleted the supplier");
            alert.showAndWait();

            suppliers.remove(h);
        }
    }

    /**
     *     //this method will come back the array of suppliers.
     * @return
     */
    public ArrayList<Supplier> getSupplier() {
        return suppliers;
    }

    /**
     *     //This method will load the array of suppliers and show on the table window.
     * @param supplier
     */
    public void setSupplier(ArrayList<Supplier> supplier) {
        this.suppliers = supplier;
        supplierOL = FXCollections.observableArrayList();

        this.colPhoneSupplier.setCellValueFactory(new PropertyValueFactory("phone"));
        this.colAddressSupplier.setCellValueFactory(new PropertyValueFactory("address"));
        this.colCifdniSupplier.setCellValueFactory(new PropertyValueFactory("cif_dni"));
        this.colEmailSupplier.setCellValueFactory(new PropertyValueFactory("email"));
        this.colBussinesnameSuppliere.setCellValueFactory(new PropertyValueFactory("bussinesName"));

        if(suppliers.size()>0)
        {
            for(int i=0;i<suppliers.size();i++)
            {
                supplierOL.add(suppliers.get(i));
            }
        }
        this.tvSupplier.setItems(supplierOL);
    }
}