package service;

import model.Bookster;
import model.PickUpPoint;
import repository.PickuppointRepository;

public class PickUpPointService {

    private PickuppointRepository pickuppointRepository;

    public  PickUpPointService(){
        this.pickuppointRepository = new PickuppointRepository();
    }
    public void addPickUpPoint(PickUpPoint pickUpPoint){
        pickuppointRepository.addPickuppoint(pickUpPoint);
    }

    public void removePickUpPoint(int id){
        pickuppointRepository.removePickUpPoint(id);
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

    public void updatePickUpPointAddress(int id, String address){
        pickuppointRepository.updatePickUpPointAddress(id, address);
    }
}
