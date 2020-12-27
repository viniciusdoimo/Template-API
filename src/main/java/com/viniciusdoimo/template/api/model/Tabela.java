package com.viniciusdoimo.template.api.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

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
@Table(name = "model_table")
public class Tabela implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;
	@Column(name = "message", nullable = false)
	private String message;

	public Tabela(BigInteger id) {
		this.id = id;
	}

	public Tabela(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tabela tabela = (Tabela) o;
		return Objects.equals(id, tabela.id) && Objects.equals(message, tabela.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, message);
	}

	@Override
	public String toString() {
		return "Tabela { " +
				"id=" + id +
				", message='" + message + '\'' + " } ";
	}
}
