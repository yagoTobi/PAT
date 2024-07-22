package volta.cars.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import volta.cars.project.model.ReservationModel;
import volta.cars.project.repository.ReservationRepository;
import volta.cars.project.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired 
    private ReservationRepository repository; 

    @Override 
    public Iterable<ReservationModel> retrieveAll()
    {
        return repository.findAll();
    }

    @Override
    public void createReservation(ReservationModel newReservation) {

        Long userId = newReservation.getUserId();
        Long hostId = newReservation.getHostId();
        float price = newReservation.getPrice();
        float latitude = newReservation.getLatitude();
        float longitude = newReservation.getLongitude();
        String reservationDate=newReservation.getReservationDate();
        String reservationHour=newReservation.getReservationHour();

        repository.createReservation(userId, hostId, price, latitude, longitude, reservationDate, reservationHour);

    }
    
}