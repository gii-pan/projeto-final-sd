package com.backend.uaibook.entity;


import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Person {

    private String name;

    private String cpf;

    private String email;

    private String telephone;
}