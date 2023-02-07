package com.backend.uaibook.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "books")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Nome vazio")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "ISBN vazio")
    @Column(name = "isbn")
    private String isbn;

    @NotEmpty(message = "Autores vazio")
    @Column(name = "authors")
    private String authors;

    @NotNull(message = "Ano vazio")
    @Column(name = "year")
    private Integer year;

    @Column(name = "categories")
    @ElementCollection(targetClass = Category.class)
    @Enumerated(EnumType.STRING)
    private List<Category> categories;

    @Min(0)
    @Column(name = "amount")
    private Integer amount;

    @NotEmpty(message = "Editora vazia")
    @Column(name = "publisher")
    private String publisher;

//    public List<String> getCategories() {
//        return categories.stream().map(Category::name).toList();
//    }

//    public void setCategories(List<String> categories) {
//        List<Category> categoryList = new ArrayList<>();
//        categories.forEach(categoryString -> {
//            Category category = Category.getCategory(categoryString);
//            if(category != null) categoryList.add(category);
//        });
//
//        this.categories = categoryList;
//    }
}
