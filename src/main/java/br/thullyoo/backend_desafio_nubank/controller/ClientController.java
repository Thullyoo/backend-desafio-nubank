package br.thullyoo.backend_desafio_nubank.controller;

import br.thullyoo.backend_desafio_nubank.dtos.ClientRequest;
import br.thullyoo.backend_desafio_nubank.dtos.ClientResponse;
import br.thullyoo.backend_desafio_nubank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<ClientResponse> registerClient(@RequestBody ClientRequest clientRequest){
        ClientResponse clientResponse = clientService.register(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
    }

}
