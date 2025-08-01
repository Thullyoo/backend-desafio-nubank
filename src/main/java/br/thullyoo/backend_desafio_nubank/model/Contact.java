package br.thullyoo.backend_desafio_nubank.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "TB_CONTACTS")
@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String contact_value;

    @ManyToOne
    private Client client;

}
