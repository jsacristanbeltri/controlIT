package User;

/**
 * The Client class represent the object of the main program to
 * store the client elements .
 * @author jorge.sacristan
 * @version 1.0
 */
public class Client extends Person{
    protected String bussinesName;
    protected String iban;
    protected String firstName;
    protected String lastName;

    /**
     * Constructor with parameters
     * @param phone
     * @param address
     * @param cif_dni
     * @param email
     * @param bussinesName
     * @param firstName
     * @param lastName
     * @param iban
     */
    public Client(String phone, String address, String cif_dni, String email, String bussinesName, String firstName, String lastName, String iban) {
        super(phone, address, cif_dni, email);
        this.bussinesName = bussinesName;
        this.iban = iban;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     *Return bussines name
     * @return bussinesName
     */
    public String getBussinesName() {
        return bussinesName;
    }

    /**
     *Establishes the bussines name
     * @param bussinesName
     */
    public void setBussinesName(String bussinesName) {
        this.bussinesName = bussinesName;
    }

    /**
     * Return the Iban
     * @return iban
     */
    public String getIban() {
        return iban;
    }

    /**
     *Establishes the iban
     * @param iban
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     *Returns the first name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *Establishes the first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *Returns the last name
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *Establishes the last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns an string with all param.
     * @return
     */
    @Override
    public String toString() {
        return "Client{" +
                "bussinesName='" + bussinesName + '\'' +
                ", iban='" + iban + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", cif_dni='" + cif_dni + '\'' +
                ", email='" + email + '\'' +
                ", blocked=" + blocked +
                ", notes='" + notes + '\'' +
                '}';
    }
}
