package br.com.apicontructor.controller.location;

import br.com.apicontructor.service.location.StateService;
import br.com.apicontructor.service.model.StateDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "Location")
@RestController
@RequestMapping("/api/state")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public List<StateDTO> findStates(){
      return stateService.findAllStates();
    }
}