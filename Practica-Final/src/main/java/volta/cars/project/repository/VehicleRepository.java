package volta.cars.project.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import volta.cars.project.model.VehicleModel;

public interface VehicleRepository extends CrudRepository<VehicleModel, String> {

    //Como hacer un Post 
    @Modifying
    @Query("INSERT INTO VEHICLES (ELECTRIC, MODEL, LICENSE_PLATE, WATTAGE) VALUES (:email)")
    public void createVehicleMember(boolean isElectric, String model, String licensePlate, float wattage);
}
