package volta.cars.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import volta.cars.project.model.UserModel;
import volta.cars.project.repository.UserRepository;
import volta.cars.project.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired 
    private UserRepository repository; 

    @Override 
    public Iterable<UserModel> retrieveAll()
    {
        return repository.findAll();
    }

    @Override
    public void createUserMember(UserModel newMember) {

        String userName = newMember.getUserName();
        String surname = newMember.getSurname();
        String email = newMember.getEmail();
        String password = newMember.getPassword();
        String dob = newMember.getDob();

        repository.addMember(userName, surname, email, password, dob);
    }

    @Override
    public Iterable<UserModel> getUserByEmail(String mail) {
        return repository.getUserByEmail(mail);
    }


    
}