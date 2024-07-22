package volta.cars.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import volta.cars.project.model.ReservationModel;
import volta.cars.project.service.ReservationService;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {
    @Autowired
    private ReservationService service;

    @GetMapping("/reservations")
    public ResponseEntity<Iterable<ReservationModel>> retrieveAll() {
        return ResponseEntity.ok().body(service.retrieveAll());
    };

    @PostMapping("/reservations")
    public ResponseEntity<String> createReservation(
            @RequestBody ReservationModel model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<String>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        } else {
            service.createReservation(model);
            return new ResponseEntity<String>("{\"result\" : \"OK\"}", HttpStatus.OK);
        }
    }
}