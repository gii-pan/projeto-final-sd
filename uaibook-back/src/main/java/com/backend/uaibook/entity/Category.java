package com.backend.uaibook.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Category {
    FANTASIA("Fantasia"),
    MANGA("Mangá"),
    ACAO("Ação"),
    AVENTURA("Aventura"),
    ROMANCE("Romance"),
    SCIFI("Sci-fi"),
    INFANTIL("Infantil"),
    ADULTO("Adulto"),
    MISTERIO("Mistério");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

//    @Override
//    public String toString() {
//        return name();
//    }
}
