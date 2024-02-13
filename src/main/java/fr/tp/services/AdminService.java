package fr.tp.services;

import fr.tp.entities.CategoryEntity;
import fr.tp.entities.ImageEntity;
import fr.tp.entities.ProductEntity;
import fr.tp.models.InsertProductModel;
import fr.tp.repositories.ImageRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class AdminService {

    @Inject
    ImageRepository imageRepository;

    @Inject
    EntityManager em;

    @Transactional
    public ProductEntity insertProduct(InsertProductModel productModel) {

        ProductEntity product = new ProductEntity();
        product.setTitle(productModel.getTitle());
        product.setContent(productModel.getContent());

        Set<CategoryEntity> categories = new HashSet<>();
        CategoryEntity category = em.find(CategoryEntity.class, productModel.getCategoryId());
        if (category == null) {
            throw new IllegalArgumentException("Invalid Category");
        }
        categories.add(category);

        ImageEntity image = imageRepository.createImage(productModel.getSrc(), productModel.getAlt());
        image.setProduct(product);

        product.setCategories(categories);
        product.getImages().add(image);

        em.persist(product);

        return product;
    }
}