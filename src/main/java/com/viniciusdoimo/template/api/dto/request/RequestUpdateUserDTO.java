package com.viniciusdoimo.template.api.dto.request;


import com.viniciusdoimo.template.api.model.User;
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

    public User parseUser(User user) {
        return new User(
                this.id,
                user.getName() == null ? user.getName(): this.name ,
                user.getSurname() == null ? user.getSurname(): this.surname ,
                user.getEmail() == null ? user.getEmail() : this.email,
                user.getCpf() == null ? user.getCpf() : this.cpf,
                user.getPassword() == null ? user.getPassword() : this.password,
                user.getCreationDate(),
                new Date()
        );
    }
}
