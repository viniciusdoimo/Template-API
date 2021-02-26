package com.viniciusdoimo.template.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String cpf;
    private String creationDate;
    private String updateDate;

    public ResponseUserDTO(User user) {
//        this.id = user.getId() != null ? user.getId() : null;
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.creationDate = DateUtils.formatDateToString(DateUtils.FORMAT_DATE_AND_TIME, user.getCreationDate());
        this.updateDate = DateUtils.formatDateToString(DateUtils.FORMAT_DATE_AND_TIME, user.getUpdateDate());
    }
}
