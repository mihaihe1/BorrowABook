package service;

import model.*;
import repository.CompanyRepository;
import repository.PersonRepository;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Optional;

public class UserService {

    private PersonRepository personRepository;
    private CompanyRepository companyRepository;

    public UserService(){
        this.personRepository = new PersonRepository();
        this.companyRepository = new CompanyRepository();
    }

    public void addPerson(Person person){
        personRepository.addPerson(person);
    }

    public void addCompany(Company company){
        companyRepository.addCompany(company);
    }

    public void addPersonToCompany(String username, int id){
        personRepository.addPersonToCompany(username, id);
    }

    public void printUsersDetails(){
        personRepository.printUsersDetails();
    }

    public void removePerson(String username){
        personRepository.removePerson(username);
    }

    public void removeCompany(String username){
        companyRepository.removeCompany(username);
    }

    public Optional<Company> getCompanyById(int id){
        return companyRepository.getCompanyById(id);
    }

    public void updateCompanyLocation(int id, String location){ companyRepository.updateCompanyLocation(id, location); }

}
