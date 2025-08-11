package br.thullyoo.backend_desafio_nubank.services;

import br.thullyoo.backend_desafio_nubank.dtos.ClientRequest;
import br.thullyoo.backend_desafio_nubank.dtos.ClientResponse;
import br.thullyoo.backend_desafio_nubank.dtos.ContactResponse;
import br.thullyoo.backend_desafio_nubank.mapper.ClientMapper;
import br.thullyoo.backend_desafio_nubank.mapper.ContactMapper;
import br.thullyoo.backend_desafio_nubank.model.Client;
import br.thullyoo.backend_desafio_nubank.model.Contact;
import br.thullyoo.backend_desafio_nubank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientResponse register(ClientRequest clientRequest){

        Client client = ClientMapper.clientRequestToClient(clientRequest);

        clientRepository.save(client);

        return ClientMapper.clientToClientResponse(client);

    }

    public List<ClientResponse> list(){
        List<Client> clients = clientRepository.findAll();
        List<ClientResponse> clientResponses = new ArrayList<>();

        for(Client client : clients){
            clientResponses.add(ClientMapper.clientToClientResponse(client));
        }

        return clientResponses;
    }

    public List<ContactResponse> listContact(Long client_id){

        Optional<Client> client =  clientRepository.findById(client_id);

        if (client.isEmpty()){
            throw new RuntimeException("Client not exist");
        }

        if (client.get().getContacts().isEmpty()){
            return List.of();
        }

        List<ContactResponse> contacts = new ArrayList<>();

        for (Contact contact : client.get().getContacts()){
            contacts.add(ContactMapper.contactToContactResponse(contact));
        }

        return contacts;
    }
}
