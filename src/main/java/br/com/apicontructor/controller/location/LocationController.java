package br.com.apicontructor.controller.location;

import br.com.apicontructor.service.location.LocationService;
import br.com.apicontructor.service.model.StateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
    @RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<StateDTO> findStates(){
      return locationService.findAllStates();
    }
}