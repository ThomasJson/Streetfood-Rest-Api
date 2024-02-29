package fr.tp.repositories;

import fr.tp.entities.ProductEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductEntity> {

    public List<ProductEntity> getAll() {
        return listAll();
    }
    public ProductEntity getById(UUID id) {
        return find("id", id).firstResult();
    }

    @Transactional
    public List<ProductEntity> getProductsByCategoryId(UUID categoryId) {
        return find("SELECT p FROM ProductEntity p JOIN p.categories c WHERE c.id = :categoryId",
                Parameters.with("categoryId", categoryId)).list();
    }

}