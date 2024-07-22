package volta.cars.project.service;

import volta.cars.project.model.NewsletterModel;

public interface NewsletterService {
    Iterable<NewsletterModel> retrieveAll();
    void createNewsletterMember(NewsletterModel newMember);
}
