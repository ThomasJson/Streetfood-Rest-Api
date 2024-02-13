package fr.tp.repositories;

import fr.tp.entities.ProductEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
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

}