package br.com.apicontructor.controller.company.mapper;

import br.com.apicontructor.controller.company.model.request.CompanyRequest;
import br.com.apicontructor.infrastructure.entity.company.CompanyEntity;
import br.com.apicontructor.service.model.company.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDTO toCompanyDTO(CompanyRequest company);

    @Mapping(target = "city.id", source = "company.address.cityId")
    CompanyEntity toEntity(CompanyDTO company);
}
