package townInfoPackega;

public class Person {

    private String name;
    private String defoltcity;

    public Person(String name, String defoltcity) {
        this.name = name;
        this.defoltcity = defoltcity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefoltcity() {
        return defoltcity;
    }

    public void setDefoltcity(String defoltcity) {
        this.defoltcity = defoltcity;
    }
}
