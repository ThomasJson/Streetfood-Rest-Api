package fr.tp.services;

import fr.tp.dto.AccountDto;
import fr.tp.dto.AppUserDto;
import fr.tp.entities.AccountEntity;
import fr.tp.entities.AppUserEntity;
import fr.tp.repositories.AccountRepository;
import fr.tp.repositories.AppUserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AppUserService {

    @Inject
    AppUserRepository appUserRepository;

    public List<AppUserDto> getAllAppUsers() {
        return AppUserDto.fromEntities(appUserRepository.getAll());
    }

    public AppUserDto getAppUserById(UUID id) {
        AppUserEntity userEntity = appUserRepository.getById(id);
        if (userEntity != null) {
            return AppUserDto.fromEntity(userEntity);
        }
        return null;
    }
}