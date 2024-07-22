package volta.cars.project.service;
import volta.cars.project.model.UserModel;

public interface UserService {
    
    Iterable<UserModel> retrieveAll();
    void createUserMember(UserModel newMember);
    Iterable<UserModel> getUserByEmail(String mail);
}
