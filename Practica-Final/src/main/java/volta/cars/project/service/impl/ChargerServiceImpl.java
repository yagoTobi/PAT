package volta.cars.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import volta.cars.project.model.ChargerModel;
import volta.cars.project.repository.ChargerRepository;
import volta.cars.project.service.ChargerService;

@Service
public class ChargerServiceImpl implements ChargerService {

    @Autowired
    private ChargerRepository repository;

    @Override
    public Iterable<ChargerModel> retrieveAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<ChargerModel> retrieveChargerLat(float latitude) {

            return repository.retrieveChargersByLatitude(latitude);
    }

    @Override
    public Iterable<ChargerModel> retrieveChargerLong(float longitude) {

            return repository.retrieveChargersByLongitude(longitude);
    }


    @Override
    public void createCharger(ChargerModel newCharger) {

        Long userId = newCharger.getUserId();
        float latitude = newCharger.getLatitude();
        float longitude = newCharger.getLongitude();
        String chargerType = newCharger.getChargerType();

        repository.addCharger(userId, latitude, longitude, chargerType);
    }

    @Override
    public ChargerModel retrieveCharger(Long id) {
        ChargerModel response = null;
        if (repository.existsById(id)) {
            Iterable<ChargerModel> chargers = repository.retrieveCharger(id);
            for (ChargerModel charger : chargers) {
                response = charger;
            }
            return response;
        }
        return response;
    }


    

    @Override
    public ChargerModel updateCharger(Long id, ChargerModel charger) {
        if (repository.existsById(id)) {
            return repository.save(charger);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCharger(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ChargerModel getChargerByChargerId(Long chargerId) {
        return repository.retrieveChargerById(chargerId);
    }


}

