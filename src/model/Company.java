package model;

public class Company {
    private int id;
    private String name;
    private String location;
    private boolean isAffiliated;
    private User[] employees;

    public Company(int i, String n, String l, boolean iA, User[] e){
        this.id = i;
        this.name = n;
        this.location = l;
        this.isAffiliated = iA;
        this.employees = e;
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
