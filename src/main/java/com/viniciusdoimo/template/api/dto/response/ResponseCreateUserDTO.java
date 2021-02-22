package com.viniciusdoimo.template.api.dto.response;

import com.viniciusdoimo.template.api.model.User;
import com.viniciusdoimo.template.api.utils.DateUtils;
import lombok.Data;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Data
public class ResponseCreateUserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String cpf;
    private String creationDate;

    public ResponseCreateUserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.creationDate = DateUtils.formatDateToString(DateUtils.FORMAT_DATE_AND_TIME, user.getCreationDate());
    }
}
