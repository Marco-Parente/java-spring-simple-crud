package br.politec.laudos.api.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.politec.laudos.api.model.Pessoa;
import br.politec.laudos.api.model.PessoaDTO;
import br.politec.laudos.api.repository.PessoaRepository;

@RestController
public class PessoaController {
  @Autowired
  private PessoaRepository pessoaRepository;

  @GetMapping("/pessoas")
  public Collection<Pessoa> pessoas() {
    return pessoaRepository.findAll();
  }

  @PostMapping("/pessoas")
  public Pessoa novaPessoa(@RequestBody PessoaDTO pessoaDTO) {
    Pessoa pessoa = new Pessoa("");
    pessoa.setNome(pessoaDTO.getNome());
    pessoa.setEmail(pessoaDTO.getEmail());

    return pessoaRepository.save(pessoa);
  }

  @PatchMapping("/pessoas/{id}")
  public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable long id, @RequestBody PessoaDTO pessoaDTO) {
    if (pessoaDTO == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Optional<Pessoa> pessoa = pessoaRepository.findById(id);
    if (pessoa.isPresent()) {
      if (!pessoaDTO.getNome().isEmpty()) {
        pessoa.get().setNome(pessoaDTO.getNome());
      }

      if (!pessoaDTO.getEmail().isEmpty()) {
        pessoa.get().setEmail(pessoaDTO.getEmail());
      }
      pessoaRepository.save(pessoa.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/pessoas/{id}")
  public ResponseEntity<Pessoa> delete(@PathVariable long id) {
    Optional<Pessoa> pessoa = pessoaRepository.findById(id);
    if (pessoa.isPresent()) {
      pessoaRepository.delete(pessoa.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
