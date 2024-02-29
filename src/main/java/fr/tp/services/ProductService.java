package fr.tp.services;

import fr.tp.dto.ProductDto;
import fr.tp.entities.ProductEntity;
import fr.tp.repositories.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<ProductDto> getAllProducts() {
        return ProductDto.fromEntities(productRepository.getAll());
    }

    public ProductDto getProductById(UUID id) {
        ProductEntity productEntity = productRepository.getById(id);
        if (productEntity != null) {
            return ProductDto.fromEntity(productEntity);
        }
        return null;
    }

    public List<ProductDto> getProductsByCategoryId(UUID categoryId) {
        List<ProductEntity> products = productRepository.getProductsByCategoryId(categoryId);
        if(products != null){
            return ProductDto.fromEntities(products);
        }
        return null;
    }
}