package br.thullyoo.backend_desafio_nubank.mapper;

import br.thullyoo.backend_desafio_nubank.dtos.ClientRequest;
import br.thullyoo.backend_desafio_nubank.dtos.ClientResponse;
import br.thullyoo.backend_desafio_nubank.dtos.ContactResponse;
import br.thullyoo.backend_desafio_nubank.model.Client;
import br.thullyoo.backend_desafio_nubank.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper {

    public static Client clientRequestToClient(ClientRequest clientRequest){

        Client client = new Client();

        if (clientRequest.email().isBlank() || clientRequest.email().isEmpty()){
            throw new RuntimeException("Email cannot be empty or blank");
        }

        if (clientRequest.name().isBlank() || clientRequest.name().isEmpty()){
            throw new RuntimeException("Name cannot be empty or blank");
        }

        if (clientRequest.document() .isBlank() || clientRequest.document().isEmpty()){
            throw new RuntimeException("Document cannot be empty or blank");
        }

        client.setEmail(clientRequest.email());
        client.setName(clientRequest.name());
        client.setDocument(clientRequest.document());

        return client;

    }

    public static ClientResponse clientToClientResponse(Client client){

        List<ContactResponse> contacts = new ArrayList<>();

        for (Contact contact : client.getContacts()){
            contacts.add(ContactMapper.contactToContactResponse(contact));
        }

        return new ClientResponse(client.getName(), client.getEmail(), client.getDocument(), contacts);

    }

}
