package fr.tp.repositories;

import fr.tp.entities.ImageEntity;
import fr.tp.entities.ProductEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ImageRepository implements PanacheRepository<ImageEntity> {

    public List<ImageEntity> getAll() {
        return listAll();
    }
    public ImageEntity getById(UUID id) {
        return find("id", id).firstResult();
    }

    public List<ImageEntity> findByProductIds(List<UUID> productIds) {
        return list("product.id IN ?1", productIds);
    }

    @Transactional
    public ImageEntity createImage(String src, String alt) {
        ImageEntity item = new ImageEntity();
        item.setSrc(src);
        item.setAlt(alt);
        persist(item);
        return item;
    }



}