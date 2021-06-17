package br.com.raizama.raizamaapi.repository;

import br.com.raizama.raizamaapi.modelo.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
    Estabelecimento findById(long id);

    List<Estabelecimento> findByNomeFantasia(String nomeFantasia);

    List<Estabelecimento> findByCidade(String cidade);

    List<Estabelecimento> findByPraticas(List<String> praticas);

    @Query(
            value = "SELECT * FROM Estabelecimento e " +
            "WHERE e.nomeFantasia = :term" +
            "OR e.tipo = :term" +
            "AND e.cidade = :cidade" +
            "AND e.praticas = :praticas",
            nativeQuery = true)
    List<Estabelecimento> searchAll(String term, String cidade, List<String> praticas);
}
