package fr.tp.repositories;

import fr.tp.entities.AppUserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AppUserRepository implements PanacheRepository<AppUserEntity> {
    public List<AppUserEntity> getAll() {
        return listAll();
    }
    public AppUserEntity getById(UUID id) {
        return find("id", id).firstResult();
    }

    public AppUserEntity createNewAppUser(String firstName) {

        AppUserEntity appUser = new AppUserEntity();
        appUser.setFirstName(firstName);
        persist(appUser);
        return appUser;
    }

}