package volta.cars.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HostDTO {
    Long userId;
    Long hostId;
    float hourlyRate;
    int rating;
    int numberHosted;
    String identification;
}
