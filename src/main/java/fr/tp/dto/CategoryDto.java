package fr.tp.dto;

import fr.tp.entities.CategoryEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CategoryDto {

    private UUID id;
    private String title;
    public CategoryDto(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public static CategoryDto fromEntity(CategoryEntity entity) {
        return new CategoryDto(entity.getId(), entity.getTitle());
    }

    public static List<CategoryDto> fromEntities(List<CategoryEntity> entities) {
        return entities.stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }
}