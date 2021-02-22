package com.viniciusdoimo.template.api.repositories;

import com.viniciusdoimo.template.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
