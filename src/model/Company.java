package model;

public class Company {
    private int id;
    private String name;
    private String location;
    private boolean isAffiliated;
    private User[] employees;

    public Company(int id, String name, String location, boolean isAffiliatedA, User[] employees){
        this.id = id;
        this.name = name;
        this.location = location;
        this.isAffiliated = isAffiliatedA;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public User[] getEmployees() {
        return employees;
    }

    public void setEmployees(User[] employees) {
        this.employees = employees;
    }
}
