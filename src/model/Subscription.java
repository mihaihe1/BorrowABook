package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class Subscription {
    private String subscriptionType;
    private int maxNumberToBorrow;
    private LocalDate expirationDate;

    public Subscription(String subscriptionType){
        this.subscriptionType = subscriptionType;
        switch (subscriptionType){
            case "none":
                this.maxNumberToBorrow = 0;
                break;

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

        this.expirationDate = LocalDate.now().plusDays(30);
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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
