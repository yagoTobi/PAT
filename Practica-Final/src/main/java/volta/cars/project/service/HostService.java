package volta.cars.project.service;

import volta.cars.project.model.HostModel;

public interface HostService {
    Iterable<HostModel> retrieveAll();

    void addHost(HostModel newHost);
    Iterable<HostModel> getHostById(Long userId);

}
