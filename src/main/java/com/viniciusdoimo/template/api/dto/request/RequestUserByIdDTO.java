package com.viniciusdoimo.template.api.dto.request;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Getter
@Data
public class RequestUserByIdDTO {

    @NotNull()
    private Long id;
}
