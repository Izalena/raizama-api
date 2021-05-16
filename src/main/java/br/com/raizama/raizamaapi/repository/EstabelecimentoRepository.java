package br.com.raizama.raizamaapi.repository;

import br.com.raizama.raizamaapi.modelo.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
    Estabelecimento findById(long id);
    Estabelecimento findByNomeFantasia(String nomeFantasia);
}
