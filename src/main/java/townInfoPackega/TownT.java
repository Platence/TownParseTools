package townInfoPackega;

public class TownT {

    private String area;
    private String street;
    private String town;
    private String index;

    @Deprecated
    public TownT(String area,String street, String town) {
        this.area = area;
        this.street = street;
        this.town = town;
    }

    public TownT(String area, String street, String town, String index) {
        this.area = area;
        this.street = street;
        this.town = town;
        this.index = index;
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

    public String getIndex() {
        return index;
    }

}
