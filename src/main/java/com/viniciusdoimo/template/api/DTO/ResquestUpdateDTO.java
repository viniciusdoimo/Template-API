package com.viniciusdoimo.template.api.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResquestUpdateDTO {
    private BigInteger id;
    private String message;
}
