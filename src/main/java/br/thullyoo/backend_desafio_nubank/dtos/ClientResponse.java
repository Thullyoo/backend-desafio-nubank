package br.thullyoo.backend_desafio_nubank.dtos;

import java.util.List;

public record ClientResponse(String name, String email, String document, List<ContactResponse> contacts) {
}
