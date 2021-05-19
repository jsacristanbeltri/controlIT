package User;

/**
 * The user class represent the object of the main program to
 * store the Users.
 * @author jorge.sacristan
 * @version 1.0
 */

public class User extends Person {
    protected String loginName;
    protected String password;
    protected String rol;
    protected String firstName;
    protected String lastName;
    protected String dateOfBirth;

    public User(String phone, String address, String cif_dni, String email,
                String loginName, String password, String rol, String firstName,
                String lastName, String dateOfBirth) {
        super(phone, address, cif_dni, email);
        this.loginName = loginName;
        this.password = password;
        this.rol = rol;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }




}
