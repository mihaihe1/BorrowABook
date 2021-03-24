package model;

public class Company extends User{
    private String companyName;
    private String location;
    private boolean isAffiliated;
    private Person[] employees;

    public Company(String userName, String password, String email, String companyName, String location, boolean isAffiliatedA, Person[] employees){
        super(userName, password, email);
        this.companyName = companyName;
        this.location = location;
        this.isAffiliated = isAffiliatedA;
        this.employees = employees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAffiliated() {
        return isAffiliated;
    }

    public void setAffiliated(boolean affiliated) {
        isAffiliated = affiliated;
    }

    public Person[] getEmployees() {
        return employees;
    }

    public void setEmployees(Person[] employees) {
        this.employees = employees;
    }
}
