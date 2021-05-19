package Inventory;

import Management.Category;
import User.Client;
import User.Supplier;

/**
The HardwareElement class represent the object of the main program to
store the hardware elements like monitors, keyboards...
 @author JorgeSacristanBeltri
 @version 1.0
 */

public class HardwareElement extends ItElement{
    protected Boolean rented;
    protected Client personRented;
    protected String status;
    protected Boolean warranty;
    protected Boolean used;


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
     * @param rented
     * @param personRented
     * @param status
     * @param warranty
     * @param used
     */
    public HardwareElement(int id, String name, int stock, String buyDate, Supplier supplier, String location, Category category, String notes, Boolean rented, Client personRented, String status, Boolean warranty, Boolean used) {
        super(id, name, stock, buyDate, supplier, location, category, notes);
        this.rented = rented;
        this.personRented = personRented;
        this.status = status;
        this.warranty = warranty;
        this.used = used;
    }


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
     * @param rented
     * @param status
     * @param warranty
     * @param used
     */


    //Constructor with client
    public HardwareElement(int id, String name, int stock, String buyDate, Supplier supplier, String location, Category category, String notes, Boolean rented, String status, Boolean warranty, Boolean used) {
        super(id, name, stock, buyDate, supplier, location, category, notes);
        this.rented = rented;
        this.personRented = null;
        this.status = status;
        this.warranty = warranty;
        this.used = used;
    }

    //Gets and clients methods:

    /**
     * Returns the rented boolean
     * @return rented boolean
     */
    public Boolean getRented() {
        return rented;
    }

    /**
     * Establishes the rented boolean
     * @param rented
     */

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    /**
     * Returns the person who rented the it hardware.
     * @return person rented.
     */

    public Client getPersonRented() {
        return personRented;
    }

    /**
     * Establishes the person who rented
     * @param personRented
     */
    public void setPersonRented(Client personRented) {
        this.personRented = personRented;
    }

    /**
     * Returns the status
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Establishes the status
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the warranty boolean
     * @return warranty
     */
    public Boolean getWarranty() {
        return warranty;
    }

    /**
     * Establishes the warranty of the hardware
     * @param warranty
     */
    public void setWarranty(Boolean warranty) {
        this.warranty = warranty;
    }

    /**
     * Returns the Used state.
     * @return used
     */
    public Boolean getUsed() {
        return used;
    }

    /**
     * Establishes the used state
     * @param used
     */
    public void setUsed(Boolean used) {
        this.used = used;
    }

    /**
     * Returns an string with all param.
     * @return
     */
    @Override
    public String toString() {
        return "HardwareElement{" +
                "status='" + status + '\'' +
                ", warranty=" + warranty +
                ", used=" + used +
                ", rented=" + rented +
                ", personRented=" + personRented +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", buyDate='" + buyDate + '\'' +
                ", supplier=" + supplier +
                ", location='" + location + '\'' +
                ", category=" + category +
                ", notes='" + notes + '\'' +
                '}';
    }
}
