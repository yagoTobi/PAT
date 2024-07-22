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

import volta.cars.project.model.VehicleModel;
import volta.cars.project.service.VehicleService;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {
    @Autowired
    private VehicleService service;

    @GetMapping("/vehicles")
    public ResponseEntity<Iterable<VehicleModel>> retrieveAll() {
        return ResponseEntity.ok().body(service.retrieveAll());
    };

    @PostMapping("/vehicles")
    public ResponseEntity<String> createVehicleMember(
            @RequestBody VehicleModel model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<String>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        } else {
            service.createVehicleMember(model);
            return new ResponseEntity<String>("{\"result\" : \"OK\"}", HttpStatus.OK);
        }
    }
}