package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Subscription {
    private String subscriptionType;
    private int maxNumberToBorrow;
    private Date expirationDate;

    public Subscription(String subscriptionType, int maxNumberToBorrow){
        this.subscriptionType = subscriptionType;
        this.maxNumberToBorrow = maxNumberToBorrow;

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 30);
        Date currentDatePlusMonth = c.getTime();

        this.expirationDate = currentDatePlusMonth;
    }
}
