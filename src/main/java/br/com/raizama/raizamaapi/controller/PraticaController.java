package br.com.raizama.raizamaapi.controller;

import br.com.raizama.raizamaapi.controller.dto.PraticaDto;
import br.com.raizama.raizamaapi.controller.form.AtualizacaoPraticaForm;
import br.com.raizama.raizamaapi.controller.form.PraticaForm;
import br.com.raizama.raizamaapi.modelo.Pratica;
import br.com.raizama.raizamaapi.repository.PraticaRepository;
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
@RequestMapping("/pratica")
public class PraticaController {

    @Autowired
    private PraticaRepository praticaRepository;

    @GetMapping
    public List<PraticaDto> listarPraticas() {
        List<Pratica> praticas = praticaRepository.findAll();
        return PraticaDto.converter(praticas);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PraticaDto> cadastrarPratica(
            @RequestBody @Valid PraticaForm form,
            UriComponentsBuilder uriBuilder) {
        Pratica pratica = form.converter();
        praticaRepository.save(pratica);

        URI uri = uriBuilder.path("/pratica/{id}")
                .buildAndExpand(pratica.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new PraticaDto(pratica));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PraticaDto> atualizar(@PathVariable Long id,
                                                 @RequestBody @Valid AtualizacaoPraticaForm form) {
        Optional<Pratica> optional = praticaRepository.findById(id);
        if (optional.isPresent()) {
            Pratica pratica = form.atualizar(id, praticaRepository);
            return ResponseEntity.ok(new PraticaDto(pratica));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Pratica> optional = praticaRepository.findById(id);
        if (optional.isPresent()) {
            praticaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
