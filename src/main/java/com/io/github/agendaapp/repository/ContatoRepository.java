package com.io.github.agendaapp.repository;

import com.io.github.agendaapp.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato,Long> {

    public Optional<Contato>findByNomeLike(String nome);
    public Optional<Contato>findByEmailLike(String email);
}
