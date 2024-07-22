package volta.cars.project.repository;
import java.sql.Date;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import volta.cars.project.model.ReservationModel;

public interface ReservationRepository extends CrudRepository<ReservationModel, String> {

    //Como hacer un Post 
    @Modifying
    @Query("INSERT INTO RESERVATIONS (USER_ID, HOST_ID, PRICE, LATITUDE, LONGITUDE, RESERVATION_DATE,RESERVATION_HOUR) VALUES (:userId, :hostId, :price, :latitude, :longitude, :reservationDate, :reservationHour)")
    public void createReservation(Long userId, Long hostId, float price, float latitude, float longitude, String reservationDate, String reservationHour);
}

