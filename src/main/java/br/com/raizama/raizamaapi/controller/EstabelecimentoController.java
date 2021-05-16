package br.com.raizama.raizamaapi.controller;

import br.com.raizama.raizamaapi.controller.dto.EstabelecimentoDto;
import br.com.raizama.raizamaapi.controller.form.AtualizacaoEstabelecimentoForm;
import br.com.raizama.raizamaapi.controller.form.EstabelecimentoForm;
import br.com.raizama.raizamaapi.modelo.Estabelecimento;
import br.com.raizama.raizamaapi.repository.EstabelecimentoRepository;
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
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @GetMapping
    public List<EstabelecimentoDto> listarEstabelecimentos() {
        List<Estabelecimento> estabelecimentos = estabelecimentoRepository.findAll();
        return EstabelecimentoDto.converter(estabelecimentos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EstabelecimentoDto> cadastrarEstabelecimento(
            @RequestBody @Valid EstabelecimentoForm form,
            UriComponentsBuilder uriBuilder) {
        Estabelecimento estabelecimento = form.converter();
        estabelecimentoRepository.save(estabelecimento);

        URI uri = uriBuilder.path("/estabelecimento/{id}").buildAndExpand(estabelecimento.getId()).toUri();
        return ResponseEntity.created(uri).body(new EstabelecimentoDto(estabelecimento));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EstabelecimentoDto> atualizar(@PathVariable Long id,
                                                 @RequestBody @Valid AtualizacaoEstabelecimentoForm form) {
        Optional<Estabelecimento> optional = estabelecimentoRepository.findById(id);
        if (optional.isPresent()) {
            Estabelecimento estabelecimento = form.atualizar(id, estabelecimentoRepository);
            return ResponseEntity.ok(new EstabelecimentoDto(estabelecimento));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Estabelecimento> optional = estabelecimentoRepository.findById(id);
        if (optional.isPresent()) {
            estabelecimentoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
