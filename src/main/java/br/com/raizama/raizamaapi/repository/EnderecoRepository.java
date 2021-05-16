package br.com.raizama.raizamaapi.repository;

import br.com.raizama.raizamaapi.modelo.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco findById(long id);
    Endereco findBylogradouro(String logradouro);
}
