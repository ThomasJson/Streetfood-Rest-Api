package fr.tp.repositories;

import fr.tp.entities.AccountEntity;
import fr.tp.entities.AppUserEntity;
import fr.tp.entities.RoleEntity;
import fr.tp.utils.RestUtils;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AccountRepository implements PanacheRepository<AccountEntity> {

    public List<AccountEntity> getAll() {
        return listAll();
    }
    public AccountEntity getById(UUID id) {
        return find("id", id).firstResult();
    }

    public AccountEntity createNewAccount(String mail, String password, String pseudo, AppUserEntity appUser, RoleEntity role) {

        AccountEntity newAccount = new AccountEntity();

        String pswHashed = RestUtils.encodePassword(password);

        newAccount.setMail(mail);
        newAccount.setPassword(pswHashed);
        newAccount.setPseudo(pseudo);
        newAccount.setAppUser(appUser);
        newAccount.setRole(role);

        persist(newAccount);
        return newAccount;
    }

}