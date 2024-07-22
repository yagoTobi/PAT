package volta.cars.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import volta.cars.project.model.ChargerModel;
import volta.cars.project.service.ChargerService;

@RestController
@RequestMapping("/api/v1")
public class ChargerController {

    @Autowired
    private ChargerService service;

    @GetMapping("/chargers")
    public ResponseEntity<Iterable<ChargerModel>> retrieveAll() {
        return ResponseEntity.ok().body(service.retrieveAll());
    };

    @PostMapping("/chargers")
    public ResponseEntity<String> createCharger(
            @RequestBody ChargerModel model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<String>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        } else {
            service.createCharger(model);
            return new ResponseEntity<String>("{\"result\" : \"OK\"}", HttpStatus.OK);
        }
    }

    @GetMapping("/chargersLon")
    public ResponseEntity<Iterable<ChargerModel>> retrieveChargerLon(@RequestParam(required = false) float longitude) {

        Iterable<ChargerModel> response = service.retrieveChargerLong(longitude);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/chargersLat")
    public ResponseEntity<Iterable<ChargerModel>> retrieveChargerLat(@RequestParam(required = false) float latitude) {

        Iterable<ChargerModel> response = service.retrieveChargerLat(latitude);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/charger/{id}/")
    public ResponseEntity<ChargerModel> retrieveCharger(@PathVariable Long id) {
        ChargerModel response = service.getChargerByChargerId(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/chargers/{id}/")
    public ResponseEntity<ChargerModel> updateCharger(@PathVariable Long id, @RequestBody ChargerModel charger) {
        ChargerModel newCharger = service.updateCharger(id, charger);
        if (newCharger == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newCharger);
    }

    @DeleteMapping("/chargers/{id}")
    public ResponseEntity<ChargerModel> deleteCharger(@PathVariable Long id) {
        service.deleteCharger(id);
        return ResponseEntity.noContent().build();
    }
}
