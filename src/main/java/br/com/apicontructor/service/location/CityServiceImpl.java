package br.com.apicontructor.service.location;

import br.com.apicontructor.infrastructure.entity.location.StateEntity;
import br.com.apicontructor.infrastructure.repository.location.CityRepository;
import br.com.apicontructor.infrastructure.repository.location.StateRepository;
import br.com.apicontructor.service.location.mapper.CityMapper;
import br.com.apicontructor.service.model.CityDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityDTO> findAllCityByStateId(long stateId) {
        return CityMapper.INSTANCE.mapToListDTO(cityRepository.findByStateId(stateId));
    }
}
