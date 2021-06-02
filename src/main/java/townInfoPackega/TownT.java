package townInfoPackega;

public class TownT {

    private String area;
    private String street;
    private String town;


    public TownT(String area,String street, String town) {
        this.area = area;
        this.street = street;
        this.town = town;
    }

    public String getArea() {
        return area;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

}
