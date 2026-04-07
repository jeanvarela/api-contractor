package br.com.apicontructor.service.model.company;

import br.com.apicontructor.service.model.AddressDTO;
import br.com.apicontructor.service.model.CityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyDTO {
    private long id;
    private String name;
    private String identifier;
    private AddressDTO address;
    private String email;
    private String socialReason;
    private CityDTO city;
}
