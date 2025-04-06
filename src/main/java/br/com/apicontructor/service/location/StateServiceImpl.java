package br.com.apicontructor.service.location;

import br.com.apicontructor.infrastructure.repository.location.StateRepository;
import br.com.apicontructor.service.location.mapper.LocationMapper;
import br.com.apicontructor.service.model.StateDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<StateDTO> findAllStates() {
        return LocationMapper.INSTANCE.mapToListDTO(stateRepository.findAll());
    }
}