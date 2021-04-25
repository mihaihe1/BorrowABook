package service;

import model.Bookster;
import model.PickUpPoint;

public class PickUpPointService {
    public void addPickUpPoint(Bookster db, PickUpPoint pickUpPoint){
        db.getPickUpPoints().add(pickUpPoint);
    }

    public int getNumberOfPickUpPoints(Bookster db){
        int nrP = 0;
        for(PickUpPoint p : db.getPickUpPoints()){
            if(p != null){
                nrP++;
            }
        }
        return nrP;
    }

    public void printPickUpPoints(Bookster db){
        for(PickUpPoint p : db.getPickUpPoints()){
            if(p != null)
                System.out.println(p);
        }
    }

    public void updatePickUpPointAddress(PickUpPoint pickUpPoint, String address){
        pickUpPoint.setAddress(address);
    }
}
