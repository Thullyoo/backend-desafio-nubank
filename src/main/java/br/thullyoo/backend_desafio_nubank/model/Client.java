package br.thullyoo.backend_desafio_nubank.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "TB_CLIENTS")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String document;

    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "client")
    private List<Contact> contacts;
}
