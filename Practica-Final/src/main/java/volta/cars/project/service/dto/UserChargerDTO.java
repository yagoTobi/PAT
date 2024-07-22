package volta.cars.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserChargerDTO {
    Long userId;
    Long vehicleId;
    int age; 
    String region; 
    String identification;
    Long chargerId; 
    String chargerName;
    float latitude; 
    float longitude;
    float wattage;
}
