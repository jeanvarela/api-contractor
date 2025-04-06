package br.com.apicontructor.service.location;

import br.com.apicontructor.service.model.CityDTO;

import java.util.List;

public interface CityService {

    List<CityDTO> findAllCityByStateId(long stateId);
}
