package service;

import model.*;

import java.util.Calendar;
import java.util.Date;

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
                    if(p != null && p.getUserName() == user.getUserName())
                        return ((Company) u).getSubscription().getMaxNumberToBorrow();
            }

        return 0;
    }

    public void printFirstCompanyWithExpiredSubscription(Bookster db){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 0);
        Date date = calendar.getTime();
        String companyName = "";

        for(User u : db.getUsers())
            if (u instanceof Company && ((Company) u).getSubscription().getExpirationDate().before(date)){
                date = ((Company)u).getSubscription().getExpirationDate();
                companyName = ((Company)u).getCompanyName();
            }

        System.out.println(companyName + " " + date);
    }
}
