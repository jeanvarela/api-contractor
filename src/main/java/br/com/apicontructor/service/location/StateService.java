package br.com.apicontructor.service.location;

import br.com.apicontructor.service.model.StateDTO;

import java.util.List;

public interface StateService {

    List<StateDTO> findAllStates();
}
