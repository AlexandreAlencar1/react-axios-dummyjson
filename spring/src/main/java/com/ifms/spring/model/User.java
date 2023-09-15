package com.ifms.spring.model;

import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@jakarta.persistence.Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
}
