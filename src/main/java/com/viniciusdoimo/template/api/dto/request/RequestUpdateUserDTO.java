package com.viniciusdoimo.template.api.dto.request;


import com.viniciusdoimo.template.api.model.User;
import com.viniciusdoimo.template.api.utils.PasswordUtils;
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
public class RequestUpdateUserDTO {
    @NotNull()
    private Long id;

    @Size(min =3, max=30)
    private String name;

    @Size(min =3, max=30)
    private String surname;

    @Email()
    private String email;

    @Size(min =14, max=14)
    private String cpf;

    @Size(min =8, max=16)
    private String password;

    public User parseUser(User user) {
        return new User(
                this.id,
                this.getName() == null ? user.getName():  this.getName(),
                this.getSurname() == null ? user.getSurname(): this.getSurname() ,
                this.getEmail() == null ? user.getEmail() : this.getEmail(),
                this.getCpf() == null ? user.getCpf() : this.getCpf(),
                PasswordUtils.generateBCrypt(this.getPassword() == null ? user.getPassword() : this.getPassword()),
                user.getCreationDate(),
                new Date()
        );
    }
}
