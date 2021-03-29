package service;

import model.*;

public class UserService {

    public void addUser(Bookster db, User user){
        int nextAvailableIndex = getNumberOfUsers(db);
        db.getUsers()[nextAvailableIndex] = user;
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
                    if(p.getUserName() == user.getUserName())
                        return ((Company) u).getSubscription().getMaxNumberToBorrow();
            }

        return 0;
    }

}
