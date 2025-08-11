package br.thullyoo.backend_desafio_nubank.mapper;

import br.thullyoo.backend_desafio_nubank.dtos.ContactResponse;
import br.thullyoo.backend_desafio_nubank.model.Contact;

public class ContactMapper {

    public static ContactResponse contactToContactResponse(Contact contact){
        return new ContactResponse(contact.getType(), contact.getContact_value());
    }

}
