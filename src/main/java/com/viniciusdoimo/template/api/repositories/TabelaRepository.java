package com.viniciusdoimo.template.api.repositories;

import com.viniciusdoimo.template.api.model.Tabela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;


@Transactional(readOnly = true)
public interface TabelaRepository extends JpaRepository<Tabela, Long> {
	
	@Transactional(readOnly = true)
	Tabela findById(BigInteger id);

}
