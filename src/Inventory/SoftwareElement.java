package Inventory;

import Management.Category;
import User.Client;
import User.Supplier;

/**
 * The SoftwareElement class represent the object of the main program to
 * store the software elements like CRM...
 * @author jorge.sacristan
 * @version 1.0
 */

public class SoftwareElement extends ItElement{
    protected String license;
    protected Boolean maintenance;
    protected int validity;
    protected Client clientRented;

    /**
     * Constructor with parameters
     * @param id
     * @param name
     * @param stock
     * @param buyDate
     * @param supplier
     * @param location
     * @param category
     * @param notes
     * @param license
     * @param maintenance
     * @param validity
     * @param clientRented
     */
    public SoftwareElement(int id, String name, int stock, String buyDate,
                           Supplier supplier, String location, Category category,
                           String notes, String license, Boolean maintenance, int validity, Client clientRented) {
        super(id, name, stock, buyDate, supplier, location, category, notes);
        this.license = license;
        this.maintenance = maintenance;
        this.validity = validity;
        this.clientRented = clientRented;
    }

    /**
     * Returns the license
     * @return license
     */
    public String getLicense() {
        return license;
    }

    /**
     * Establishes the license
     * @param license
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * Returns the maintenance
     * @return maintenance
     */
    public Boolean getMaintenance() {
        return maintenance;
    }

    /**
     * Establishes the maintenance
     * @param maintenance
     */
    public void setMaintenance(Boolean maintenance) {
        this.maintenance = maintenance;
    }

    /**
     * Returns the validity
     * @return validity
     */
    public int getValidity() {
        return validity;
    }

    /**
     * Establishes the validity
     * @param validity
     */
    public void setValidity(int validity) {
        this.validity = validity;
    }

    /**
     * Returns the client who rented the software.
     * @return client rented
     */
    public Client getClientRented() {
        return clientRented;
    }

    /**
     * Establishes the client rented
     * @param clientRented
     */
    public void setClientRented(Client clientRented) {
        this.clientRented = clientRented;
    }

    /**
     * Returns an string with all param.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() +
                " license='" + license + '\'' +
                ", maintenance=" + maintenance +
                ", validity=" + validity +
                '}';
    }
}
