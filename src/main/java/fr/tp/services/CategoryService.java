package fr.tp.services;

import fr.tp.dto.CategoryDto;
import fr.tp.dto.ImageDto;
import fr.tp.dto.ProductDto;
import fr.tp.entities.CategoryEntity;
import fr.tp.entities.ImageEntity;
import fr.tp.entities.ProductEntity;
import fr.tp.repositories.CategoryRepository;
import fr.tp.repositories.ImageRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class CategoryService {

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    ImageRepository imageRepository;

    @Inject
    EntityManager em;

    public List<CategoryDto> getAllCategories() {
        return CategoryDto.fromEntities(categoryRepository.getAll());
    }

    public CategoryDto getCategoryById(UUID id) {
        CategoryEntity categoryEntity = categoryRepository.getById(id);
        if (categoryEntity != null) {
            return CategoryDto.fromEntity(categoryEntity);
        }
        return null;
    }

    public List<ProductEntity> getProductsByCategoryId(UUID categoryId) {
        TypedQuery<ProductEntity> query = em.createQuery(
                "SELECT p FROM ProductEntity p JOIN p.categories c WHERE c.id = :categoryId", ProductEntity.class);

        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    public List<ProductDto> getProductsByCategory(UUID categoryId, boolean withImages) {
        CategoryEntity category = em.find(CategoryEntity.class, categoryId);
        if (category == null) {
            throw new IllegalArgumentException("Category not found");
        }

        List<ProductEntity> products = getProductsByCategoryId(categoryId);

        // Initialiser la map vide une seule fois
        Map<UUID, List<ImageDto>> imagesByProductId = new HashMap<>();

        if (withImages) {
            List<UUID> productIds = products.stream()
                    .map(ProductEntity::getId)
                    .collect(Collectors.toList());

            List<ImageEntity> images = imageRepository.findByProductIds(productIds);

            // Remplir la map sans la réassigner
            Map<UUID, List<ImageDto>> finalImagesByProductId = images.stream()
                    .filter(image -> image.getProduct() != null)
                    .collect(Collectors.groupingBy(image -> image.getProduct().getId(),
                            Collectors.mapping(ImageDto::fromEntity, Collectors.toList())));

            imagesByProductId.putAll(finalImagesByProductId); // Ajouter tous les éléments à la map initiale
        }

        return products.stream().map(product -> {
            ProductDto dto = new ProductDto(product);

            if (withImages && imagesByProductId.containsKey(product.getId())) {
                dto.setImages(imagesByProductId.get(product.getId()));
            }

            return dto;
        }).collect(Collectors.toList());
    }

}