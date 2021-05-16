package br.com.raizama.raizamaapi.repository;

import br.com.raizama.raizamaapi.modelo.Endereco;
import br.com.raizama.raizamaapi.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findById(long id);
    Usuario findByNome(String nome);
}
