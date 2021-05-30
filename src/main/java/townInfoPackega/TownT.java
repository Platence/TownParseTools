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

    public void setArea(String area) {
        this.area = area;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
