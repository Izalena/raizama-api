package br.com.raizama.raizamaapi.repository;

import br.com.raizama.raizamaapi.modelo.Pratica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PraticaRepository extends JpaRepository<Pratica, Long> {

    Pratica findById(long id);
    Pratica findByPratica(String pratica);
}
