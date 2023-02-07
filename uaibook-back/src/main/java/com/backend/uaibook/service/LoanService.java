package com.backend.uaibook.service;

import com.backend.uaibook.entity.Loan;
import com.backend.uaibook.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan createLoan(Loan loan) {
        loan.setIsOpen(true);
        loan.setLoanDate(LocalDate.now());

        if(loan.getDevolutionDate() == null || loan.getDevolutionDate().compareTo(LocalDate.now().plusMonths(1)) > 0)
            loan.setDevolutionDate(LocalDate.now().plusWeeks(2));

        Loan saved = loanRepository.save(loan);
        return loanRepository.getLoanById(saved.getId());
    }

    public List<Loan> getLoan(Boolean open) {
        if(open)
            return loanRepository.getLoanByIsOpenIsTrue();

        return loanRepository.findAll();
    }

    public Loan closeLoan(Long loanId) {
        Loan loan = loanRepository.getLoanById(loanId);

        if(loan == null)
            throw new NullPointerException("Empréstimo não encontrado");

        loan.setIsOpen(false);

        return loanRepository.save(loan);
    }

    public void deleteLoan(Long loanId) {
        Loan loan = loanRepository.getLoanById(loanId);

        if(loan == null)
            throw new NullPointerException("Empréstimo não encontrado");

        loanRepository.delete(loan);
    }
}
