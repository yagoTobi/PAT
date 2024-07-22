package volta.cars.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import volta.cars.project.model.HostModel;
import volta.cars.project.service.HostService;

@RestController
@RequestMapping("/api/v1")
public class HostController {
    @Autowired
    private HostService service;

    @GetMapping("/hostMembers")
    public ResponseEntity<Iterable<HostModel>> retrieveAll() {
        return ResponseEntity.ok().body(service.retrieveAll());
    };

    @PostMapping("/hostMembers")
    public ResponseEntity<String> createHostMember(
            @RequestBody HostModel model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<String>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        } else {
            service.addHost(model);
            return new ResponseEntity<String>("{\"result\" : \"OK\"}", HttpStatus.OK);
        }
    }

    @GetMapping("/hostMembers/{userId}")
    public Iterable<HostModel> getHost(@PathVariable("userId") Long userId) {
        return service.getHostById(userId);
    }

}