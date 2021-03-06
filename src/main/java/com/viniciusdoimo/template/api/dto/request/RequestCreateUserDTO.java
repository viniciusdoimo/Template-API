package com.viniciusdoimo.template.api.dto.request;

import com.viniciusdoimo.template.api.model.User;
import com.viniciusdoimo.template.api.utils.PasswordUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Data
@AllArgsConstructor
public class RequestCreateUserDTO {

    @NotNull()
    @Size(min =3, max=30)
    private String name;

    @NotNull()
    @Size(min =3, max=30)
    private String surname;

    @NotNull()
    @Email()
    private String email;

    @NotNull()
    @Size(min =14, max=14)
    private String cpf;

    @NotNull()
    @Size(min =8, max=16)
    private String password;

    public User parseUser() {
        return new User(getName(), getSurname(), getEmail(), getCpf(), PasswordUtils.generateBCrypt(getPassword()), new Date(), new Date());
    }
}
