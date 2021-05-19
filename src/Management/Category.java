package Management;

/*
The Category class represent the object of the main program to
store the categories like monitors, computers...
 */

public class Category {
    protected int referenceCat;
    protected String nameCat;

    public Category(int referenceCat, String nameCat) {
        this.referenceCat = referenceCat;
        this.nameCat = nameCat;
    }

    public int getReferenceCat() {
        return referenceCat;
    }

    public void setReferenceCat(int referenceCat) {
        this.referenceCat = referenceCat;
    }

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    @Override
    public String toString() {
        return "Category{" +
                "referenceCat='" + referenceCat + '\'' +
                ", nameCat='" + nameCat + '\'' +
                '}';
    }
}
