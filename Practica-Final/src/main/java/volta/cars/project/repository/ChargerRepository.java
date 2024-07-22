package volta.cars.project.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import volta.cars.project.model.ChargerModel;

public interface ChargerRepository extends CrudRepository<ChargerModel, Long> {

    @Modifying
    @Query("SELECT * FROM CHARGERS WHERE CHARGERS.LONGITUDE= :longitude")
    public Iterable<ChargerModel> retrieveChargersByLongitude(float longitude);
    
    @Query("SELECT * FROM CHARGERS WHERE CHARGERS.LONGITUDE= :longitude")
    public Iterable<ChargerModel> retrieveChargersByLatitude(float latitude);
    
    @Query("SELECT * FROM CHARGERS WHERE CHARGERS.CHARGER_ID= :chargerId")
    public Iterable<ChargerModel> retrieveCharger(Long chargerId);

    @Query("SELECT * FROM CHARGERS WHERE CHARGERS.CHARGER_ID= :chargerId")
    public ChargerModel retrieveChargerById(Long chargerId);
    
    @Query("INSERT INTO CHARGERS (USER_ID, LATITUDE, LONGITUDE, CHARGER_TYPE) VALUES (:userId,:latitude,:longitude,:chargerType)")
    public void addCharger(Long userId, float latitude, float longitude, String chargerType);
}
