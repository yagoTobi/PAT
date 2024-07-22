package volta.cars.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import volta.cars.project.model.VehicleModel;
import volta.cars.project.repository.VehicleRepository;
import volta.cars.project.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired 
    private VehicleRepository repository; 

    @Override 
    public Iterable<VehicleModel> retrieveAll()
    {
        return repository.findAll();
    }

    @Override
    public void createVehicleMember(VehicleModel newVehicle) {

        boolean isElectric = newVehicle.getIsElectric();
        String model = newVehicle.getModel();
        String licensePlate = newVehicle.getLicensePlate();
        float wattage = newVehicle.getWattage();

        repository.createVehicleMember(isElectric, model, licensePlate, wattage);

    }
    
}