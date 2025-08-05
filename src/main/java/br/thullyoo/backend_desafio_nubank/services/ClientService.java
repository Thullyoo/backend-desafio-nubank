package br.thullyoo.backend_desafio_nubank.services;

import br.thullyoo.backend_desafio_nubank.dtos.ClientRequest;
import br.thullyoo.backend_desafio_nubank.dtos.ClientResponse;
import br.thullyoo.backend_desafio_nubank.mapper.ClientMapper;
import br.thullyoo.backend_desafio_nubank.model.Client;
import br.thullyoo.backend_desafio_nubank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientResponse register(ClientRequest clientRequest){

        Client client = ClientMapper.clientRequestToClient(clientRequest);

        clientRepository.save(client);

        return ClientMapper.clientToClientResponse(client);

    }
}
