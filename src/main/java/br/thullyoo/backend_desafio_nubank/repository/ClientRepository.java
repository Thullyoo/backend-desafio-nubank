package br.thullyoo.backend_desafio_nubank.repository;

import br.thullyoo.backend_desafio_nubank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
