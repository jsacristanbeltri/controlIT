package Inventory;
import Management.Category;
import User.*;

/*
The ItElement class represent the father of
every it element object like hardware or software.
 */

/**
 * The ItElement class represent the father of
 * every it element object like hardware or software.
 * @author jorge.sacristan
 * @version 1.0
 */

abstract public class ItElement {
    protected int id;
    protected String name;
    protected int stock;
    protected String buyDate;
    protected Supplier supplier;
    protected String location;
    protected Category category;
    protected String notes;

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
     */
    public ItElement(int id, String name, int stock, String buyDate, Supplier supplier,
                     String location, Category category, String notes) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.buyDate = buyDate;
        this.supplier = supplier;
        this.location = location;
        this.category = category;
        this.notes = notes;
    }

    /**
     * Returns the id of the it element
     * @return id
     */

    public int getId() {
        return id;
    }

    /**
     * Establishes the id of the it element
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return the name of the it element
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Establishes the name of the it element
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the stock
     * @return Stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establishes the stock
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Returns the buy date
     * @return Buy Date
     */

    public String getBuyDate() {
        return buyDate;
    }

    /**
     * Establishes the buy date
     * @param buyDate
     */

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    /**
     *  Returns the Supplier
     * @return Supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     *  Establishes the Supplier
     * @param supplier
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * Returns the Location
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Establishes the location
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns the category of the it element
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Establishes the category
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Returns the notes
     * @return
     */
    public String getNotes() {
        return notes;
    }

    /**
     *Establishes the notes
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Returns an string with all param.
     * @return
     */
    @Override
    public String toString() {
        return "ItElement{" +
                "id='" + id + '\'' +
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
