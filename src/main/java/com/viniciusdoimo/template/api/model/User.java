package com.viniciusdoimo.template.api.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends GenericModel {
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", length = 30, nullable = false)
	private String name;

	@Column(name = "surname", length = 30, nullable = false)
	private String surname;

	@Column(name = "email", length = 70, nullable = false)
	private String email;

	@Column(name = "cpf", length = 15, nullable = false)
	private String cpf;

	@Column(name = "password", length = 15, nullable = false)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false)
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", nullable = false)
	private Date updateDate;

	public User(String name, String surname, String email, String cpf, String password, Date creationDate, Date updateDate) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
	}
}
