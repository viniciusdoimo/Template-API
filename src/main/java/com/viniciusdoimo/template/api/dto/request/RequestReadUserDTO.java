package com.viniciusdoimo.template.api.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Data
public class RequestReadUserDTO {

    @NotNull()
    private Long id;
}
