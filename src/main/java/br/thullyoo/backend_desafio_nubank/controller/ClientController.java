package br.thullyoo.backend_desafio_nubank.controller;

import br.thullyoo.backend_desafio_nubank.dtos.ClientRequest;
import br.thullyoo.backend_desafio_nubank.dtos.ClientResponse;
import br.thullyoo.backend_desafio_nubank.dtos.ContactResponse;
import br.thullyoo.backend_desafio_nubank.model.Contact;
import br.thullyoo.backend_desafio_nubank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponse> registerClient(@RequestBody ClientRequest clientRequest){
        ClientResponse clientResponse = clientService.register(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> listClients(){
        List<ClientResponse> clientResponse = clientService.list();
        return ResponseEntity.status(HttpStatus.OK).body(clientResponse);
    }

    @GetMapping("${id}/contacts")
    public ResponseEntity<List<ContactResponse>> listContactByClient(@PathVariable("id") Long client_id){
        List<ContactResponse> contactResponses =  clientService.listContact(client_id);
        return ResponseEntity.status(HttpStatus.OK).body(contactResponses);
    }

}
