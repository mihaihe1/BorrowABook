package model;

public class Company extends User{
    private String companyName;
    private String location;
    private Person[] employees;
    private Subscription subscription;

    public Company(String userName, String password, String email, String companyName, String location, Person[] employees, Subscription subscription){
        super(userName, password, email);
        this.companyName = companyName;
        this.location = location;
        this.employees = employees;
        this.subscription = subscription;
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

    public Person[] getEmployees() {
        return employees;
    }

    public void setEmployees(Person[] employees) {
        this.employees = employees;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString(){
        return super.toString() + " / " + companyName + " / " + subscription.getSubscriptionType();
    }
}
