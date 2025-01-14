package br.com.apicontructor.service.location.mapper;

import br.com.apicontructor.infrastructure.entity.location.StateEntity;
import br.com.apicontructor.service.model.StateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);
    
    StateDTO mapToDTO(StateEntity state);

    List<StateDTO> mapToListDTO(List<StateEntity> stateList);
}