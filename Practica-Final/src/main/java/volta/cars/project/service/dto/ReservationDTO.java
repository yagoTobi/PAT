package volta.cars.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    Long userId;
    String reservationId;
    String hostId;
    float price;
    String latitude;
    String longitude;
    String reservationDate;
    String reservationHour;
}
