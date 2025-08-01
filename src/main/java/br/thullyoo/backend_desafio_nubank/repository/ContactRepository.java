package br.thullyoo.backend_desafio_nubank.repository;

import br.thullyoo.backend_desafio_nubank.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
