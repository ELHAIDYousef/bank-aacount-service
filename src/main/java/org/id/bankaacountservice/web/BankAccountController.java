package org.id.bankaacountservice.web;

import org.id.bankaacountservice.dto.AccountResponse;
import org.id.bankaacountservice.dto.CreateAccountRequest;
import org.id.bankaacountservice.dto.UpdateAccountRequest;
import org.id.bankaacountservice.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    // GET /accounts
    @GetMapping
    public List<AccountResponse> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }

    // GET /accounts/{id}
    @GetMapping("/{id}")
    public AccountResponse getAccountById(@PathVariable String id) {
        return bankAccountService.getAccountById(id);
    }

    // POST /accounts  -> 201 Created + Location header
    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody @Validated CreateAccountRequest request) {
        AccountResponse created = bankAccountService.createBankAccount(request);
        URI location = URI.create("/accounts/" + created.id());
        return ResponseEntity.created(location).body(created);
    }

    // PUT /accounts/{id}
    @PutMapping("/{id}")
    public AccountResponse updateResponseEntityAccount(@PathVariable String id,
                                         @RequestBody @Validated UpdateAccountRequest request) {
        return bankAccountService.updateBankAccount(id, request);
    }

    // DELETE /accounts/{id}  -> 204 No Content
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable String id) {
        bankAccountService.deleteBankAccountById(id);
    }
}