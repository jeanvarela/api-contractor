package br.com.apicontructor.controller.location.model.resquest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressRequest {
    private Long id;

    @NotBlank
    private String street;
    private long number;
    private String complement;

    @NotBlank
    private String neighborhood;

    @NotNull
    private long cityId;
}
