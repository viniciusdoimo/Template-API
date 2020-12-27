package com.viniciusdoimo.template.api.Repository;

import com.viniciusdoimo.template.api.model.Tabela;
import com.viniciusdoimo.template.api.repositories.TabelaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class TabelaRepositoryTest {
    private Tabela tabela;

    @Autowired
    TabelaRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAllInBatch();
        Tabela tabela = new Tabela("Persistence setUp");
        this.tabela = repository.save(tabela);
    }

    @Test
    public void testSave() {
        Tabela tabela = new Tabela("Persistence Test Save");
        Tabela persistenceResponse = repository.save(tabela);
        assertNotNull(persistenceResponse);
    }

    @Test
    public void testfindById() {
        Optional<Tabela> searchResponse = repository.findById(this.tabela.getId());
        assertNotNull(searchResponse.get());
        tabela = searchResponse.get();
        assertEquals(tabela.getMessage(), "Persistence setUp");
    }

    @Test
    public void testUpdate() {
        Optional<Tabela> searchResponse = repository.findById(this.tabela.getId());
        Tabela tabela = searchResponse.get();
        tabela.setMessage("Upgrading testing");
        int response = repository.update(tabela.getId(), tabela.getMessage());
        assertEquals(response, 1);
    }

    @Test
    public void testDelete() {
        repository.delete(this.tabela);

        Optional<Tabela> response = repository.findById(this.tabela.getId());
        assertEquals(response, Optional.empty());
    }
}
