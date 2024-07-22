package volta.cars.project.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import volta.cars.project.model.NewsletterModel;

public interface NewsletterRepository extends CrudRepository<NewsletterModel, String> {

    //Como hacer un Post 
    @Modifying
    @Query("INSERT INTO NEWSLETTER_MEMBERS (E_MAIL) VALUES (:email)")
    public void createNewsletterMember(String email);
}
