package com.backend.uaibook.repository;

import com.backend.uaibook.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Loan getLoanById(Long id);

    List<Loan> getLoanByIsOpenIsTrue();
}
