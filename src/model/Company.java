package model;

public class Company extends User{
    private String companyName;
    private String location;

    public Company(String userName, String password, String email, String companyName, String location){
        super(userName, password, email);
        this.companyName = companyName;
        this.location = location;
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


    @Override
    public String toString(){
        return super.toString() + " / " + companyName;
    }
}
