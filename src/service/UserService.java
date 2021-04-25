package service;

import model.*;

import java.time.LocalDate;
import java.util.Calendar;

public class UserService {

    public void addUser(Bookster db, User user){
        db.getUsers().add(user);
    }

    public void addPersonToCompany(Person person, Company company){
        int nextAvailableIndex = getNumberOfEmployees(company);
        company.getEmployees()[nextAvailableIndex] = person;
    }

    public int getNumberOfUsers(Bookster db){
        int nrUsers = 0;
        for(User u : db.getUsers()){
            if(u != null){
                nrUsers++;
            }
        }
        return nrUsers;
    }

    public void printUsersDetails(Bookster db){
        for(User u : db.getUsers()){
            if(u != null)
                System.out.println(u);
        }
    }

    public int getNumberOfEmployees(Company company){
        int numberOfEmployees = 0;
        for(Person p : company.getEmployees())
            if(p != null)
                numberOfEmployees++;

        return numberOfEmployees;
    }

    public int getMaxToBorrow(Bookster db, User user){
        for(User u : db.getUsers())
            if(u instanceof Company){
                Person[] employeeList = ((Company) u).getEmployees();
                for(Person p : employeeList)
                    if(p != null && p.getUserName().equals(user.getUserName()))
                        return ((Company) u).getSubscription().getMaxNumberToBorrow();
            }

        return 0;
    }

    public void printFirstCompanyWithExpiredSubscription(Bookster db){
        LocalDate date = LocalDate.of(2022, 1, 1);
        String companyName = "";

        for(User u : db.getUsers())
            if (u instanceof Company && ((Company) u).getSubscription().getExpirationDate().compareTo(date) < 0){
                date = ((Company)u).getSubscription().getExpirationDate();
                companyName = ((Company)u).getCompanyName();
            }

        System.out.println(companyName + " " + date);
    }

    public void removeUser(Bookster db, String username){
        for(User u : db.getUsers()) {
            if (u != null && u.getUserName().equals(username)) {
                db.getUsers().remove(u);
                break;
            }
        }
    }
}
