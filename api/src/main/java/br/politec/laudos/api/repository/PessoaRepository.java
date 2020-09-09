package br.politec.laudos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.politec.laudos.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
