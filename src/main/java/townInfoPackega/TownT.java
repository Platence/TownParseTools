package townInfoPackega;

public class TownT {

    private String area;
    private String district;
    private String street;
    private String town;


    public TownT(String area, String district, String street, String town) {
        this.area = area;
        this.district = district;
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
