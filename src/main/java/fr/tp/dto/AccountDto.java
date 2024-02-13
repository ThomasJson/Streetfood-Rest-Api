package fr.tp.dto;

import fr.tp.entities.AccountEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AccountDto {
    private UUID id;
    private String pseudo;

    public AccountDto(UUID id, String pseudo){
        this.id = id;
        this.pseudo = pseudo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public static AccountDto fromEntity(AccountEntity entity) {
        return new AccountDto(entity.getId(), entity.getPseudo());
    }

    public static List<AccountDto> fromEntities(List<AccountEntity> entities) {
        return entities.stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }
}
