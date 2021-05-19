package User;

/**
 * The Bussines class represent the object of the main program to
 * store the bussines companies.
 * @author jorge.sacristan
 * @version 1.0
 */
public class Bussines extends Person{
    protected String bussinesName;
    protected String iban;

    public Bussines(String phone, String address, String cif_dni, String email, String bussinesName, String iban) {
        super(phone, address, cif_dni, email);
        this.bussinesName = bussinesName;
        this.iban = iban;
    }

    public String getBussinesName() {
        return bussinesName;
    }

    public void setBussinesName(String bussinesName) {
        this.bussinesName = bussinesName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}

