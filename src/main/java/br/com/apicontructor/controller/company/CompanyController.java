package br.com.apicontructor.controller.company;

import br.com.apicontructor.controller.company.mapper.CompanyMapper;
import br.com.apicontructor.controller.company.model.request.CompanyRequest;
import br.com.apicontructor.service.company.CompanyService;
import br.com.apicontructor.service.model.company.CompanyDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
@AllArgsConstructor
@Tag(name = "Company")
public class CompanyController {

    private CompanyService companyService;

    @PostMapping
    public void create(@RequestBody @Validated CompanyRequest company){
        companyService.saveCompany(CompanyMapper.INSTANCE.toCompanyDTO(company));
    }

}
