package volta.cars.project.service;

import volta.cars.project.model.ReservationModel;

public interface ReservationService {
    Iterable<ReservationModel> retrieveAll();
    void createReservation(ReservationModel newMember);
}