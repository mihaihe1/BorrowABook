package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Subscription {
    private String subscriptionType;
    private int maxNumberToBorrow;
    private Date expirationDate;

    public Subscription(String subscriptionType){
        this.subscriptionType = subscriptionType;
        switch (subscriptionType){
            case "bronze":
                this.maxNumberToBorrow = 1;
                break;

            case "silver":
                this.maxNumberToBorrow = 3;
                break;

            case "gold":
                this.maxNumberToBorrow = 5;
                break;
        }

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 30);
        Date currentDatePlusMonth = c.getTime();

        this.expirationDate = currentDatePlusMonth;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public int getMaxNumberToBorrow() {
        return maxNumberToBorrow;
    }

    public void setMaxNumberToBorrow(int maxNumberToBorrow) {
        this.maxNumberToBorrow = maxNumberToBorrow;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
