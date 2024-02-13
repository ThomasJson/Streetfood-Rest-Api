package fr.tp.services;

import fr.tp.dto.AccountDto;
import fr.tp.entities.AccountEntity;
import fr.tp.repositories.AccountRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AccountService {

    @Inject
    AccountRepository accountRepository;

    public List<AccountDto> getAllAccounts() {
        return AccountDto.fromEntities(accountRepository.getAll());
    }

    public AccountDto getAccountById(UUID id) {
        AccountEntity accountEntity = accountRepository.getById(id);
        if (accountEntity != null) {
            return AccountDto.fromEntity(accountEntity);
        }
        return null;
    }
}