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
 * The class ManageClientController have to control every xml object of
 * the manage client window and have the  methods.
 * @author jorge.sacristan
 * @version 1.0
 */
public class ManageClientController implements Initializable {

    @FXML
    private TableColumn colPhoneClient;
    @FXML
    private TableColumn colAddressClient;
    @FXML
    private TableColumn colEmailClient;
    @FXML
    private TableColumn colBussinesnameCliente;
    @FXML
    private TableColumn colFirstNameClient;
    @FXML
    private TableColumn colSecondNameClient;
    @FXML
    private TableColumn colIbanClient;
    @FXML
    private TableView tvClient;
    @FXML
    private TextField tfPhoneC;
    @FXML
    private TextField tfAddressC;
    @FXML
    private TextField tfEmailC;
    @FXML
    private TextField tfBussinesnameC;
    @FXML
    private TextField tfFirstnameC;
    @FXML
    private Button btUpdateClient;
    @FXML
    private Button btDeleteClient;
    @FXML
    private Button btAddClient;
    @FXML
    private TextField tfSecondNameC;
    @FXML
    private TextField tfIbanC;

    private ArrayList<Client> clients;

     private ObservableList<Client> clientOL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * This method will change the data of the client using
     * the data of the formulary and It will upgrade the table on the window.
     * @param event
     */
    @FXML
    private void UpgradeClient(ActionEvent event){
        Client h = (Client) this.tvClient.getSelectionModel().getSelectedItem();
        if(h==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un cliente");
            alert.showAndWait();
        }
        else{
            String phone = this.tfPhoneC.getText();
            String address = this.tfAddressC.getText();
            String email = this.tfEmailC.getText();
            String bussinesName = this.tfBussinesnameC.getText();
            String fName = this.tfFirstnameC.getText();
            String lName = this.tfSecondNameC.getText();
            String iban = this.tfIbanC.getText();

            Client newClient = new Client(phone,address,"2233X",email,bussinesName,fName,lName,iban);

            if(!this.clientOL.contains(newClient)){
                h.setPhone(newClient.getPhone());
                h.setAddress(newClient.getAddress());
                h.setEmail(newClient.getEmail());
                h.setBussinesName(newClient.getBussinesName());
                h.setFirstName(newClient.getFirstName());
                h.setLastName(newClient.getLastName());
                h.setIban(newClient.getIban());


                this.tvClient.refresh();
                int locationUpdateObject = clients.indexOf(h);
                clients.set(locationUpdateObject,newClient);


            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("The hardware exist already");
                alert.showAndWait();
            }
        }
    }

    /**
     * This method will add the data of the client using
     * the data of the formulary and It will upgrade the table on the window.
     * @param event
     */
    @FXML
    private void AddClient(ActionEvent event){
        String phone = this.tfPhoneC.getText();
        String address = this.tfAddressC.getText();
        String email = this.tfEmailC.getText();
        String bussinesName = this.tfBussinesnameC.getText();
        String fName = this.tfFirstnameC.getText();
        String lName = this.tfSecondNameC.getText();
        String iban = this.tfIbanC.getText();


        Client newClient = new Client(phone,address,"2233X",email,bussinesName,fName,lName,iban);
        if(!this.clientOL.contains(newClient)){
            this.clientOL.add(newClient);
            this.tvClient.refresh();
            clients.add(newClient);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("The hardware exist already");
            alert.showAndWait();
        }


    }

    /**
     *This method will select a client object of the window table
     *and It will write the data of the client on the formulary
     * @param event
     */
    @FXML
    private void seleccionar (MouseEvent event){
        Client h = (Client) this.tvClient.getSelectionModel().getSelectedItem();


        if(h!=null) {
            this.tfPhoneC.setText(h.getPhone());
            this.tfAddressC.setText(h.getAddress());
            this.tfEmailC.setText(h.getEmail());
            this.tfBussinesnameC.setText(h.getBussinesName());
            this.tfFirstnameC.setText(h.getFirstName());
            this.tfSecondNameC.setText(h.getLastName());
            this.tfIbanC.setText(h.getIban());

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("You must select a client");
            alert.showAndWait();
        }
    }


    /**
     * this method will delete on the window table a client.
     * @param event
     */
    @FXML
    private void DeleteClient (ActionEvent event){
        Client h = (Client) this.tvClient.getSelectionModel().getSelectedItem();
        if(h==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("You must select a client");
            alert.showAndWait();
        }
        else{
            this.clientOL.remove(h);
            this.tvClient.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("You deleted a client");
            alert.showAndWait();

            clients.remove(h);
        }
    }

    /**
     * this method will come back the array of clients.
     * @return
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * This method will load the array of clients and show on the table window.
     * @param clients
     */
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
        clientOL = FXCollections.observableArrayList();

        this.colPhoneClient.setCellValueFactory(new PropertyValueFactory("phone"));
        this.colAddressClient.setCellValueFactory(new PropertyValueFactory("address"));
        this.colEmailClient.setCellValueFactory(new PropertyValueFactory("email"));
        this.colBussinesnameCliente.setCellValueFactory(new PropertyValueFactory("bussinesName"));
        this.colFirstNameClient.setCellValueFactory(new PropertyValueFactory("firstName"));
        this.colSecondNameClient.setCellValueFactory(new PropertyValueFactory("lastName"));
        this.colIbanClient.setCellValueFactory(new PropertyValueFactory("iban"));

        if(clients.size()>0)
        {
            for(int i=0;i<clients.size();i++)
            {
                clientOL.add(clients.get(i));
            }
        }
        this.tvClient.setItems(clientOL);

    }

}

