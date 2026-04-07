package br.com.apicontructor.service.company;

import br.com.apicontructor.controller.company.mapper.CompanyMapper;
import br.com.apicontructor.infrastructure.entity.company.CompanyEntity;
import br.com.apicontructor.infrastructure.repository.company.CompanyRepository;
import br.com.apicontructor.service.model.company.CompanyDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    @Override
    public void saveCompany(CompanyDTO company) {

        CompanyEntity entity = CompanyMapper.INSTANCE.toEntity(company);
        companyRepository.save(entity);

        System.out.println(entity.getId());
    }
}
