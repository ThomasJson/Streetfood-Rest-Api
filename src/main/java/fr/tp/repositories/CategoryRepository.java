package fr.tp.repositories;

import fr.tp.entities.CategoryEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<CategoryEntity> {

    public List<CategoryEntity> getAll() {
        return listAll();
    }
    public CategoryEntity getById(UUID id) {
        return find("id", id).firstResult();
    }

    @Transactional
    public CategoryEntity createCategory(String title) {
        CategoryEntity category = new CategoryEntity();
        category.setTitle(title);
        persist(category);
        return category;
    }

}