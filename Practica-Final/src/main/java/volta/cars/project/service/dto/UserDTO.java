package volta.cars.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    Long userId;
    String userName;
    String surname;
    String email;
    String password;
    String dob;
}
