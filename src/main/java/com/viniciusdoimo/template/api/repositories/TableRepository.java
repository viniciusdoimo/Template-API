package com.viniciusdoimo.template.api.repositories;

import com.viniciusdoimo.template.api.model.ModelTabela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Transactional(readOnly = false)
public interface TableRepository extends JpaRepository<ModelTabela, Long> {
	
	@Transactional(readOnly = true)
    ModelTabela findById(BigInteger id);

    @Modifying(flushAutomatically = true)
    @Query("UPDATE ModelTabela t SET t.message = :message WHERE t.id = :id ")
    public int update(@Param("id") BigInteger id, @Param("message") String message);
}
