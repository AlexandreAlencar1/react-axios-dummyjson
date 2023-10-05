package com.example.springboot.models;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // Entity porque é uma entidade no banco
@Table(name = "TB_User") // esse RepresentationModel é do hateoas que é para navegabilidade
@Data
public class UserModel extends RepresentationModel<UserModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//id dessa classe no bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id gerado automaticamente
    private Long idUser;
    private String name;
    @Column(unique = true) // Garante que os e-mails sejam únicos
    private String email;
    private String senha;
}
