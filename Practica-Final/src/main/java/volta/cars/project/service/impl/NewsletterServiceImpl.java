package volta.cars.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import volta.cars.project.model.NewsletterModel;
import volta.cars.project.repository.NewsletterRepository;
import volta.cars.project.service.NewsletterService;

@Service
public class NewsletterServiceImpl implements NewsletterService{
    @Autowired 
    private NewsletterRepository repository; 

    @Override 
    public Iterable<NewsletterModel> retrieveAll()
    {
        return repository.findAll();
    }

    @Override
    public void createNewsletterMember(NewsletterModel newMember) {

        String userEmail = newMember.getEmail();

        repository.createNewsletterMember(userEmail);

    }
    
}
