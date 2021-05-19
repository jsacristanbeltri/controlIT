package Management;
/*
This class will manage the load and save of data on the files
with txt extension.
 */

import Inventory.HardwareElement;
import Inventory.SoftwareElement;
import User.Client;
import User.Supplier;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {

    //This method will read the clients on a file with txt extension
    //and will create and write an array with the data.
    public static ArrayList<Client> loadClients()
    {
        ArrayList<Client> clients = new ArrayList<Client>();

        if(!(new File("clients.txt")).exists())
        {
            System.out.println("File clients.txt not found");
            return null;
        }
        else
        {
            try
            {
                BufferedReader inputFile = new BufferedReader(
                        new FileReader(new File("clients.txt")));
                String line = inputFile.readLine();
                while(line!=null)
                {
                    String[] infoClients = line.split(";");
                   //String phone, String address, String cif_dni, String email, String bussinesName, String firstName, String lastName
                    Client client = new Client(infoClients[0],infoClients[1],infoClients[2],infoClients[3],infoClients[4],infoClients[5],infoClients[6],infoClients[7]);
                    clients.add(client);

                    line = inputFile.readLine();
                }
                inputFile.close();

            }
            catch (IOException e)
            {
                System.out.println("There has been some problems: " + e.getMessage());
            }
            return clients;
        }

    }
    //This method will read the hardware on a file with txt extension
    //and will create and write an array with the data.
    public static ArrayList<HardwareElement> loadHardwareElements()
    {

        ArrayList<HardwareElement> hardwareElements = new ArrayList<HardwareElement>();


        if(!(new File("hardwareelements.txt")).exists())
        {
            System.out.println("File clients.txt not found");
            return null;
        }
        else
        {
            try
            {
                BufferedReader inputFile = new BufferedReader(
                        new FileReader(new File("hardwareelements.txt")));
                String line = inputFile.readLine();
                while(line!=null)
                {
                    String[] infoHardwareElement = line.split(";");
                    //int id, String name, int stock, String buyDate, Supplier supplier, String location, Category category, String notes, String status, Boolean warranty, Boolean used, Boolean rented, Client client
                    //String phone, String address, String cif_dni, String email,String bussinesName
                    //int referenceCat, String nameCat
                    //String phone, String address, String cif_dni, String email, String bussinesName, String firstName, String lastName, String iban
                    Supplier supplier = new Supplier(
                            infoHardwareElement[4],
                            infoHardwareElement[5],
                            infoHardwareElement[6],
                            infoHardwareElement[7],
                            infoHardwareElement[8]

                    );
                    Category category = new Category(
                        Integer.parseInt(infoHardwareElement[10]),
                        infoHardwareElement[11]
                    );
                    Client client = new Client(
                        infoHardwareElement[17],
                            infoHardwareElement[18],
                            infoHardwareElement[19],
                            infoHardwareElement[20],
                            infoHardwareElement[21],
                            infoHardwareElement[22],
                            infoHardwareElement[23],
                            infoHardwareElement[24]
                    );
                    boolean warranty;
                    if(infoHardwareElement[14].equals("1"))
                        warranty=true;
                    else
                        warranty=false;

                    boolean used;
                    if(infoHardwareElement[15].equals("1"))
                        used=true;
                    else
                        used=false;

                    boolean rented;
                    if(infoHardwareElement[16].equals("1"))
                        rented=true;
                    else
                        rented=false;

                    //int id, String name, int stock, String buyDate, Supplier supplier,
                    // String location, Category category, String notes, Boolean rented,
                    // Client personRented, String status, Boolean warranty, Boolean used
                    HardwareElement hardwareElement = new HardwareElement(
                            Integer.parseInt(infoHardwareElement[0]),//id
                            infoHardwareElement[1],//name
                            Integer.parseInt(infoHardwareElement[2]),//stock
                            infoHardwareElement[3],//buydate
                            supplier,
                            infoHardwareElement[9], //location
                            category,
                            infoHardwareElement[12],//notes
                            rented, //1 o 0
                            client,
                            infoHardwareElement[13], //status
                            warranty, //bool, 1 o 0
                            used//bool, 1 o 0


                    );
                    hardwareElements.add(hardwareElement);

                    line = inputFile.readLine();
                }
                inputFile.close();

            }
            catch (IOException e)
            {
                System.out.println("There has been some problems: " + e.getMessage());
            }
            return hardwareElements;
        }

    }

    //This method will read the software on a file with txt extension
    //and will create and write an array with the data.
    public static ArrayList<SoftwareElement> loadSoftwareElements()
    {

        ArrayList<SoftwareElement> softwareElements = new ArrayList<SoftwareElement>();


        if(!(new File("softwareelements.txt")).exists())
        {
            System.out.println("File clients.txt not found");
            return null;
        }
        else
        {
            try
            {
                BufferedReader inputFile = new BufferedReader(
                        new FileReader(new File("softwareelements.txt")));
                String line = inputFile.readLine();
                while(line!=null)
                {
                    String[] infoSoftwareElement = line.split(";");

                    Supplier supplier = new Supplier(
                            infoSoftwareElement[4],
                            infoSoftwareElement[5],
                            infoSoftwareElement[6],
                            infoSoftwareElement[7],
                            infoSoftwareElement[8]

                    );
                    Category category = new Category(
                            Integer.parseInt(infoSoftwareElement[10]),
                            infoSoftwareElement[11]
                    );

                    Client client = new Client (
                            infoSoftwareElement[16],
                            infoSoftwareElement[17],
                            infoSoftwareElement[18],
                            infoSoftwareElement[19],
                            infoSoftwareElement[20],
                            infoSoftwareElement[21],
                            infoSoftwareElement[22],
                            infoSoftwareElement[23]

                            );

                    boolean maintenance;
                    if(infoSoftwareElement[14].equals("1"))
                        maintenance=true;
                    else
                        maintenance=false;

                    SoftwareElement softwareElement = new SoftwareElement(
                            Integer.parseInt(infoSoftwareElement[0]),
                            infoSoftwareElement[1],
                            Integer.parseInt(infoSoftwareElement[2]),
                            infoSoftwareElement[3],
                            supplier,
                            infoSoftwareElement[9],
                            category,
                            infoSoftwareElement[12],
                            infoSoftwareElement[13],
                            maintenance, //bool
                            Integer.parseInt(infoSoftwareElement[15]),
                            client


                    );
                    softwareElements.add(softwareElement);

                    line = inputFile.readLine();
                }
                inputFile.close();

            }
            catch (IOException e)
            {
                System.out.println("There has been some problems: " + e.getMessage());
            }
            return softwareElements;
        }

    }
    //This method will read the suppliers on a file with txt extension
    //and will create and write an array with the data.
    public static ArrayList<Supplier> loadSuppliers()
    {

        ArrayList<Supplier> suppliers = new ArrayList<Supplier>();


        if(!(new File("suppliers.txt")).exists())
        {
            System.out.println("File clients.txt not found");
            return null;
        }
        else
        {
            try
            {
                BufferedReader inputFile = new BufferedReader(
                        new FileReader(new File("suppliers.txt")));
                String line = inputFile.readLine();
                while(line!=null)
                {
                    String[] infoSupplier = line.split(";");
                    //String phone, String address, String cif_dni, String email, String bussinesName, String firstName, String lastName
                    Supplier supplier = new Supplier(infoSupplier[0],infoSupplier[1],infoSupplier[2],infoSupplier[3],infoSupplier[4]);
                    suppliers.add(supplier);

                    line = inputFile.readLine();
                }
                inputFile.close();

            }
            catch (IOException e)
            {
                System.out.println("There has been some problems: " + e.getMessage());
            }
            return suppliers;
        }

    }

    //This method will read the categories on a file with txt extension
    //and will create and write an array with the data.
    public static ArrayList<Category> loadCategories()
    {

        ArrayList<Category> categories = new ArrayList<Category>();


        if(!(new File("categories.txt")).exists())
        {
            System.out.println("File categories.txt not found");
            return null;
        }
        else
        {
            try
            {
                BufferedReader inputFile = new BufferedReader(
                        new FileReader(new File("categories.txt")));
                String line = inputFile.readLine();
                while(line!=null)
                {
                    String[] infoCategorie = line.split(";");
                    Category category = new Category(Integer.parseInt(infoCategorie[0]),infoCategorie[1]);
                    categories.add(category);

                    line = inputFile.readLine();
                }
                inputFile.close();

            }
            catch (IOException e)
            {
                System.out.println("There has been some problems: " + e.getMessage());
            }
            return categories;
        }

    }
    //This method will write the clients on a file with txt extension
    //using the data stored on a array
    public static void saveClients(ArrayList<Client> clients)
    {

        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter("clients.txt");
            for (int i=0;i<clients.size();i++){

                printWriter.println(clients.get(i).getPhone() +";"
                        +clients.get(i).getAddress() +";"
                        +clients.get(i).getCif_dni() +";"
                        +clients.get(i).getEmail() +";"
                        +clients.get(i).getBussinesName() +";"
                        +clients.get(i).getFirstName() +";"
                        +clients.get(i).getLastName() +";"
                        +clients.get(i).getIban()
                );
            }
        }
        catch (IOException e){
            System.out.println("Failed to save data! Error: " + e.getMessage());
        }
        finally {
            if(printWriter!=null)
                printWriter.close();
        }
    }
    //This method will write the suppliers on a file with txt extension
    //using the data stored on a array
    public static void saveSuppliers(ArrayList<Supplier> suppliers)
    {

        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter("suppliers.txt");
            for (int i=0;i<suppliers.size();i++){

                printWriter.println(suppliers.get(i).getPhone() +";"
                        +suppliers.get(i).getAddress() +";"
                        +suppliers.get(i).getCif_dni() +";"
                        +suppliers.get(i).getEmail() +";"
                        +suppliers.get(i).getBussinesName()
                );
            }
        }
        catch (IOException e){
            System.out.println("Failed to save data! Error: " + e.getMessage());
        }
        finally {
            if(printWriter!=null)
                printWriter.close();
        }
    }
    //This method will write the categories on a file with txt extension
    //using the data stored on a array
    public static void saveCategories(ArrayList<Category> categories)
    {


        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter("categories.txt");
            for (int i=0;i<categories.size();i++){
                printWriter.println(categories.get(i).getReferenceCat() + ";"
                        +categories.get(i).getNameCat()
                );
            }
        }
        catch (IOException e){
            System.out.println("Failed to save data! Error: " + e.getMessage());
        }
        finally {
            if(printWriter!=null)
                printWriter.close();
        }
    }
    //This method will write the hardware on a file with txt extension
    //using the data stored on a array
    public static void saveHardwareElements(ArrayList<HardwareElement> hardwareElements)
    {
        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter("hardwareelements.txt");
            for (int i=0;i<hardwareElements.size();i++){

                String warranty;
                if(hardwareElements.get(i).getWarranty()==true)
                    warranty="1";
                else
                    warranty="2";

                String used;
                if(hardwareElements.get(i).getUsed()==true)
                    used="1";
                else
                    used="2";

                String rented;
                if(hardwareElements.get(i).getRented()==true)
                    rented="1";
                else
                    rented="2";

                //String phone, String address, String cif_dni, String email, String bussinesName, String firstName, String lastName, String iban
                String client;
                if(hardwareElements.get(i).getPersonRented() == null){
                    client=" ; ; ; ; ; ; ; ";
                }
                else {
                    client=hardwareElements.get(i).getPersonRented().getPhone() + ";" +
                            hardwareElements.get(i).getPersonRented().getAddress() + ";" +
                            hardwareElements.get(i).getPersonRented().getCif_dni() + ";" +
                            hardwareElements.get(i).getPersonRented().getEmail() + ";" +
                            hardwareElements.get(i).getPersonRented().getBussinesName() + ";" +
                            hardwareElements.get(i).getPersonRented().getFirstName() + ";" +
                            hardwareElements.get(i).getPersonRented().getLastName() + ";" +
                            hardwareElements.get(i).getPersonRented().getIban();
                }
                String supplier;
                if(hardwareElements.get(i).getSupplier()==null){
                    supplier = " ; ; ; ; ";
                }else{
                    supplier=hardwareElements.get(i).getSupplier().getPhone() + ";" +
                            hardwareElements.get(i).getSupplier().getAddress() + ";" +
                            hardwareElements.get(i).getSupplier().getCif_dni() + ";" +
                            hardwareElements.get(i).getSupplier().getEmail() + ";" +
                            hardwareElements.get(i).getSupplier().getBussinesName();
                }
                //int id, String name, int stock, String buyDate, Supplier supplier, String location,
                // Category category, String notes, Boolean rented, Client personRented, String status,
                // Boolean warranty, Boolean used
                String categorie;
                if(hardwareElements.get(i).getCategory()==null){
                    categorie = " ; ";
                }else{
                    categorie=hardwareElements.get(i).getCategory().getReferenceCat() + ";" +
                            hardwareElements.get(i).getCategory().getNameCat();
                }

                printWriter.println(
                    hardwareElements.get(i).getId() + ";" +
                    hardwareElements.get(i).getName() + ";" +
                            hardwareElements.get(i).getStock() + ";" +
                            hardwareElements.get(i).getBuyDate() + ";" +
                            supplier + ";" +
                            hardwareElements.get(i).getLocation() + ";" +
                            categorie + ";" +
                            hardwareElements.get(i).getNotes() + ";" +
                            rented + ";" +
                            client + ";" +
                            hardwareElements.get(i).getStatus() + ";" +
                            warranty + ";" +
                            used


                );
            }
        }
        catch (IOException e){
            System.out.println("Failed to save data! Error: " + e.getMessage());
        }
        finally {
            if(printWriter!=null)
                printWriter.close();
        }
    }
    //This method will write the software on a file with txt extension
    //using the data stored on a array
    public static void saveSoftwareElements(ArrayList<SoftwareElement> softwareElements)
    {
        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter("softwareelements.txt");
            for (int i=0;i<softwareElements.size();i++){

                String maitenance;
                if(softwareElements.get(i).getMaintenance()==true)
                    maitenance="1";
                else
                    maitenance="2";

                String supplier;
                if(softwareElements.get(i).getSupplier()==null){
                    supplier = " ; ; ; ; ";
                }else{
                    supplier=softwareElements.get(i).getSupplier().getPhone() + ";" +
                            softwareElements.get(i).getSupplier().getAddress() + ";" +
                            softwareElements.get(i).getSupplier().getCif_dni() + ";" +
                            softwareElements.get(i).getSupplier().getEmail() + ";" +
                            softwareElements.get(i).getSupplier().getBussinesName();
                }
                String client;
                if(softwareElements.get(i).getClientRented() == null){
                    client=" ; ; ; ; ; ; ; ";
                }


                else{
                    client=softwareElements.get(i).getClientRented().getPhone() + ";" +
                            softwareElements.get(i).getClientRented().getAddress() + ";" +
                            softwareElements.get(i).getClientRented().getCif_dni() + ";" +
                            softwareElements.get(i).getClientRented().getEmail() + ";" +
                            softwareElements.get(i).getClientRented().getBussinesName() + ";" +
                            softwareElements.get(i).getClientRented().getFirstName() + ";" +
                            softwareElements.get(i).getClientRented().getLastName() + ";" +
                            softwareElements.get(i).getClientRented().getIban();
                }

                printWriter.println(
                        softwareElements.get(i).getId() + ";" +
                                softwareElements.get(i).getName() + ";" +
                                softwareElements.get(i).getStock() + ";" +
                                softwareElements.get(i).getBuyDate() + ";" +
                                supplier + ";" +
                                softwareElements.get(i).getLocation() + ";" +
                                softwareElements.get(i).getCategory().getReferenceCat() + ";" +
                                softwareElements.get(i).getCategory().getNameCat() + ";" +
                                softwareElements.get(i).getNotes() + ";" +
                                softwareElements.get(i).getLicense() + ";" +
                                maitenance + ";" +
                                softwareElements.get(i).getValidity() + ";" +
                                client
                );
            }
        }
        catch (IOException e){
            System.out.println("Failed to save data! Error: " + e.getMessage());
        }
        finally {
            if(printWriter!=null)
                printWriter.close();
        }
    }
}
