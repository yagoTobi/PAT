package volta.cars.project.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import volta.cars.project.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, String> {

    //Esto sabemos que funciona
    @Modifying
    @Query("INSERT INTO USERS (USER_NAME, SURNAME, E_MAIL, PASSWORD, DOB) VALUES (:userName, :surname, :email,:password, :dob)")
    public void addMember(String userName, String surname, String email, String password, String dob);


    
    @Query("SELECT * FROM USERS WHERE USERS.E_MAIL = :email ")
    public Iterable<UserModel> getUserByEmail(String email);

}
