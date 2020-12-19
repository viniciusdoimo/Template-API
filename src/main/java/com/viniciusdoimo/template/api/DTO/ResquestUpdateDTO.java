package com.viniciusdoimo.template.api.DTO;


import lombok.*;

import java.math.BigInteger;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResquestUpdateDTO {
    private BigInteger id;
    private String message;
}
