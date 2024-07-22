package volta.cars.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    Long userId;
    Long vehicleId;
    boolean isElectric;
    String model;
    String licensePlate;
    float wattage;
}
