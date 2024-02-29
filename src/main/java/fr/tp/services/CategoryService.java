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

}