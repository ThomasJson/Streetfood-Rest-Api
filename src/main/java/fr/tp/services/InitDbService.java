/*

package fr.tp.services;

import fr.tp.entities.AccountEntity;
import fr.tp.entities.AppUserEntity;
import fr.tp.entities.CategoryEntity;
import fr.tp.entities.RoleEntity;
import fr.tp.repositories.AccountRepository;
import fr.tp.repositories.AppUserRepository;
import fr.tp.repositories.CategoryRepository;
import fr.tp.repositories.RoleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InitDbService {

    @Inject
    RoleRepository roleRepository;

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    AppUserRepository appUserRepository;

    @Inject
    AccountRepository accountRepository;

    @Transactional
    public void init() {

        if (roleRepository.listAll().isEmpty()) {

            CategoryEntity cate1 = categoryRepository.createCategory("Chicken");
            CategoryEntity cate2 = categoryRepository.createCategory("Desserts");
            CategoryEntity cate3 = categoryRepository.createCategory("IceCreams");
            CategoryEntity cate4 = categoryRepository.createCategory("Noodles");
            CategoryEntity cate5 = categoryRepository.createCategory("Pork");
            CategoryEntity cate6 = categoryRepository.createCategory("SeaFood");
            CategoryEntity cate7 = categoryRepository.createCategory("Smoothies");
            CategoryEntity cate8 = categoryRepository.createCategory("Snacks");
            CategoryEntity cate9 = categoryRepository.createCategory("Veggie");

            RoleEntity admin = roleRepository.createRole("Admin", 4);
            RoleEntity user = roleRepository.createRole("User", 1);

            AppUserEntity thomas = appUserRepository.createNewAppUser("Thomas");
            AppUserEntity quentin = appUserRepository.createNewAppUser("Quentin");

            AccountEntity adminAcc = accountRepository.createNewAccount(
                    "admin@gmail.com",
                    "Azerty1",
                    "Tom",
                    thomas,
                    admin
            );

            AccountEntity userAcc = accountRepository.createNewAccount(
                    "user@gmail.com",
                    "Azerty2",
                    "Toups",
                    quentin,
                    user
            );

        }
    }
}

*/