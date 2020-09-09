package br.politec.laudos.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.politec.laudos.api.model.Pessoa;
import br.politec.laudos.api.repository.PessoaRepository;

public class PessoaService {
  @Autowired
  private PessoaRepository pessoaRepository;

  public List<Pessoa> findAll() {
    var it = pessoaRepository.findAll();

    var pessoas = new ArrayList<Pessoa>();
    it.forEach(pessoas::add);

    return pessoas;
  }
}
