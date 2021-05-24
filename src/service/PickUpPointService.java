package service;

import model.Bookster;
import model.PickUpPoint;
import repository.PickuppointRepository;

import java.util.Optional;

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

    public void printPickUpPoints(Bookster db){
        for(PickUpPoint p : db.getPickUpPoints()){
            if(p != null)
                System.out.println(p);
        }
    }

    public void updatePickUpPointAddress(int id, String address){
        pickuppointRepository.updatePickUpPointAddress(id, address);
    }

    public Optional<PickUpPoint> getPickupPointById(int id){
        return pickuppointRepository.getPickUpPointById(id);
    }
}
