package com.viniciusdoimo.template.api.repositories;

import com.viniciusdoimo.template.api.model.Table;
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
public interface TabelaRepository extends JpaRepository<Table, Long> {
	
	@Transactional(readOnly = true)
    Table findById(BigInteger id);

    @Modifying(flushAutomatically = true)
    @Query("UPDATE Table t SET t.message = :message WHERE t.id = :id ")
    public int update(@Param("id") BigInteger id, @Param("message") String message);
}
