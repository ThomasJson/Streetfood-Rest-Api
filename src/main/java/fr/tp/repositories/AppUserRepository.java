package fr.tp.repositories;

import fr.tp.entities.AppUserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AppUserRepository implements PanacheRepository<AppUserEntity> {
    public List<AppUserEntity> getAllAppUsers() {
        return listAll();
    }
    public AppUserEntity findByFirstName(String firstName) {
        return find("FirstName", firstName).firstResult();
    }
}