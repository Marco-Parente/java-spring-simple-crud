package br.politec.laudos.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.politec.laudos.api.model.Pessoa;
import br.politec.laudos.api.repository.PessoaRepository;

@Component
public class Initializer implements CommandLineRunner {

  public static final Logger logger = LoggerFactory.getLogger(Initializer.class);

  @Autowired
  private PessoaRepository pessoaRepository;

  @Override
  public void run(String... args) throws Exception {
    logger.info("Inicializando pessoas");
    pessoaRepository.save(new Pessoa("Marco"));
    pessoaRepository.findAll().forEach(e -> logger.debug("{}", e));
  }
}
