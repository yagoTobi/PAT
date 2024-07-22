package volta.cars.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import volta.cars.project.model.HostModel;
import volta.cars.project.repository.HostRepository;
import volta.cars.project.service.HostService;

@Service
public class HostServiceImpl implements HostService{
    @Autowired 
    private HostRepository repository; 

    @Override 
    public Iterable<HostModel> retrieveAll()
    {
        return repository.findAll();
    }

    @Override
    public void addHost(HostModel newHost) {
        Long userId = newHost.getUserId();
        float hourlyRate = newHost.getHourlyRate();
        Long numberHosted = newHost.getNumberHosted();
        String identification = newHost.getIdentification();

        repository.addHost(userId, hourlyRate, numberHosted, identification);
        
    }

    @Override
    public Iterable<HostModel> getHostById(Long userId) {
        return repository.getHostById(userId);
    }
}