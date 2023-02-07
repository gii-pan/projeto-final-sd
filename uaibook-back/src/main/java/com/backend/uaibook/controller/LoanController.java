package com.backend.uaibook.controller;

import com.backend.uaibook.entity.Loan;
import com.backend.uaibook.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/loan")
    public Loan createLoan(@RequestBody @Valid Loan loan) {
        return loanService.createLoan(loan);
    }

    @GetMapping("/loan")
    public List<Loan> getLoan(@RequestParam(required = false, defaultValue = "false") Boolean open) {
        return loanService.getLoan(open);
    }

    @PutMapping("/loan/{id}")
    public Loan closeLoan(@PathVariable(name = "id") Long id) {
        return loanService.closeLoan(id);
    }

    @DeleteMapping("/loan/{id}")
    public void deleteLoan(@PathVariable(name = "id") Long id) {
        loanService.deleteLoan(id);
    }
}
