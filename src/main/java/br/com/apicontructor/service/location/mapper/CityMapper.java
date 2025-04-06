package br.com.apicontructor.service.location.mapper;

import br.com.apicontructor.infrastructure.entity.location.CityEntity;
import br.com.apicontructor.service.model.CityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
    
    CityDTO mapToDTO(CityEntity city);

    List<CityDTO> mapToListDTO(List<CityEntity> stateList);
}