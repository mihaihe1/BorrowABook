package model;

public class PickUpPoint {
    private String city;
    private String address;
    private boolean openedOnWeekends;

    public PickUpPoint(String city, String address, boolean openedOnWeekends){
        this.city = city;
        this.address = address;
        this.openedOnWeekends = openedOnWeekends;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isOpenedOnWeekends() {
        return openedOnWeekends;
    }

    public void setOpenedOnWeekends(boolean openedOnWeekends) {
        this.openedOnWeekends = openedOnWeekends;
    }
}
