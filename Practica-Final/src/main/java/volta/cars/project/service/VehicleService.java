package volta.cars.project.service;

import volta.cars.project.model.VehicleModel;

public interface VehicleService {
    Iterable<VehicleModel> retrieveAll();
    void createVehicleMember(VehicleModel newMember);
}
