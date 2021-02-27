package com.viniciusdoimo.template.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserByIdDTO {

    @NotNull()
    private Long id;
}
