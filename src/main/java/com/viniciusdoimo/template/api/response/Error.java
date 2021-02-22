package com.viniciusdoimo.template.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Data
@AllArgsConstructor
public class Error {
    private String title;
    private String message;
}
