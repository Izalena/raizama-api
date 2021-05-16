package br.com.raizama.raizamaapi.controller;

import br.com.raizama.raizamaapi.controller.dto.EnderecoDto;
import br.com.raizama.raizamaapi.controller.form.AtualizacaoEnderecoForm;
import br.com.raizama.raizamaapi.controller.form.EnderecoForm;
import br.com.raizama.raizamaapi.modelo.Endereco;
import br.com.raizama.raizamaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<EnderecoDto> listarEnderecos() {
        List<Endereco> endereco = enderecoRepository.findAll();
        return EnderecoDto.converter(endereco);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EnderecoDto> cadastrarEndereco(
            @RequestBody @Valid EnderecoForm form,
            UriComponentsBuilder uriBuilder) {
        Endereco endereco = form.converter();
        enderecoRepository.save(endereco);

        URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EnderecoDto> atualizar(@PathVariable Long id,
                                                 @RequestBody @Valid AtualizacaoEnderecoForm form) {
        Optional<Endereco> optional = enderecoRepository.findById(id);
        if (optional.isPresent()) {
            Endereco endereco = form.atualizar(id, enderecoRepository);
            return ResponseEntity.ok(new EnderecoDto(endereco));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Endereco> optional = enderecoRepository.findById(id);
        if (optional.isPresent()) {
            enderecoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
