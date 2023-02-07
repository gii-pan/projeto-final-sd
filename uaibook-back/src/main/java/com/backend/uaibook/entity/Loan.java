package com.backend.uaibook.entity;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "loan")
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

//    @NotNull(message = "Usuário vazio")
//    @Column(name = "user_id")
//    private Long userId;

//    @NotNull(message = "Funcionário vazio")
//    @Column(name = "employee_id")
//    private Long employeeId;

//    @NotNull(message = "Livro vazio")
//    @Column(name = "book_id")
//    private Long bookId;

    @Column(name = "loan_date")
    private LocalDate loanDate;

    @Column(name = "devolution_date")
    private LocalDate devolutionDate;

    @Column(name = "open")
    private Boolean isOpen;

    @NotNull(message = "Usuário vazio")
    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    @NotNull(message = "Funcionário vazio")
    @ManyToOne()
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @NotNull(message = "Livro vazio")
    @ManyToOne()
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
}
