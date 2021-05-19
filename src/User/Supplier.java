package User;

/**
 * The Supplier class represent the object of the main program to
 * store the suppliers.
 * @author jorge.sacristan
 * @version 1.0
 */
public class Supplier extends Person{

    protected String bussinesName;

    /**
     * Constructor with parameters
     * @param phone
     * @param address
     * @param cif_dni
     * @param email
     * @param bussinesName
     */
    public Supplier(String phone, String address, String cif_dni, String email,String bussinesName) {
        super(phone, address, cif_dni, email);
        this.bussinesName=bussinesName;
    }

    /**
     * Returns the bussines name
     * @return bussinesName
     */
    public String getBussinesName() {
        return bussinesName;
    }

    /**
     * Establishes the bussines name
     * @param bussinesName
     */
    public void setBussinesName(String bussinesName) {
        this.bussinesName = bussinesName;
    }
    /**
     * Returns an string with all param.
     * @return
     */
    @Override
    public String toString() {
        return "Supplier{" +
                "phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", cif_dni='" + cif_dni + '\'' +
                ", email='" + email + '\'' +
                ", blocked=" + blocked +
                ", notes='" + notes + '\'' +
                ", bussinesName='" + bussinesName + '\'' +
                '}';
    }
}
