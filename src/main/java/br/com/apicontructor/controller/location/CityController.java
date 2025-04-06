package br.com.apicontructor.controller.location;

import br.com.apicontructor.service.location.CityService;
import br.com.apicontructor.service.model.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{stateId}")
    public List<CityDTO> findCity(@PathVariable("stateId") Long stateId){
        return cityService.findAllCityByStateId(stateId);
    }
}
