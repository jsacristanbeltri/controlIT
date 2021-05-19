package User;

/**
 * The User class represent the father of
 * every user element object like client or users.
 * @author jorge.sacristan
 * @version 1.0
 */

abstract public class Person {
    protected String phone;
    protected String address;
    protected String cif_dni;
    protected String email;
    protected Boolean blocked;
    protected String notes;

    /**
     * Constructor with parameters
     * @param phone
     * @param address
     * @param cif_dni
     * @param email
     */
    public Person(String phone, String address, String cif_dni, String email) {
        this.phone = phone;
        this.address = address;
        this.cif_dni = cif_dni;
        this.email = email;
        //blocked=false;
        notes="";
    }

    /**
     * Returns the phone number
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Establishes the phone number
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns the address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     *Establishes the address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *Returns the cif/dni
     * @return cif_dni
     */
    public String getCif_dni() {
        return cif_dni;
    }

    /**
     *Establishes the cif/dni
     * @param cif_dni
     */
    public void setCif_dni(String cif_dni) {
        this.cif_dni = cif_dni;
    }

    /**
     *Returns the email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establishes the email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *Returns the block status
     * @return blocked
     */
    public Boolean getBlocked() {
        return blocked;
    }

    /**
     *Establishes the block status
     * @param blocked
     */
    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    /**
     *Returns the notes
     * @return notes
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






}
