package com.viniciusdoimo.template.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "model_table")
public class ModelTabela implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;
	@Column(name = "message", nullable = false)
	private String message;

	public ModelTabela(BigInteger id) {
		this.id = id;
	}

	public ModelTabela(String message) {
		this.message = message;
	}
}
