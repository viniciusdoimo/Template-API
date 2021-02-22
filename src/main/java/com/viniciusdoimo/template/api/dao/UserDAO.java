package com.viniciusdoimo.template.api.dao;

import com.viniciusdoimo.template.api.model.User;
import com.viniciusdoimo.template.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@Service
public class UserDAO implements GenericDao<User, Long> {

    @Autowired
    UserRepository repository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long Long) throws Exception {
        return repository.findById(Long).orElseThrow(() ->
            new Exception("There is no such 'id' in the bank") );
    }

    @Override
    public List<User> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public User create(User entity) {
        try {
            return repository.save(entity);
        } catch (JpaObjectRetrievalFailureException ex) {
            return null;
        } catch (EntityNotFoundException ex) {
            return null;
        }
    }

    @Override
    public List<User> createAll(Iterable<User> entities) {
        return null;
    }

    @Override
    public void update(User entity) {
        repository.save(entity);

    }

    @Override
    public List<User> updateAll(Iterable<User> entities) {
        return null;
    }

    @Override
    public void delete(User entity) {
        repository.delete(entity);
    }

    @Override
    public List<User> deleteAll(Iterable<User> entities) {
        return null;
    }
}
