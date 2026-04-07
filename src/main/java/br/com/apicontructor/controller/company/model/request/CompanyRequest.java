package br.com.apicontructor.controller.company.model.request;

import br.com.apicontructor.controller.location.model.resquest.AddressRequest;
import br.com.apicontructor.controller.location.model.resquest.CityRequest;
import br.com.apicontructor.service.model.CityDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyRequest {
    private long id;

    @NotBlank
    private String name;

    @NotBlank(message = "federal.tax.payer.not.found")
    private String identifier;

    @NotNull
    @Valid
    private AddressRequest address;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String socialReason;

}
