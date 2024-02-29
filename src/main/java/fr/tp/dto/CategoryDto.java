package fr.tp.dto;

import fr.tp.entities.CategoryEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CategoryDto {

    private UUID id;
    private String title;
    private String title_Th;

    public CategoryDto(UUID id, String title, String title_Th) {
        this.id = id;
        this.title = title;
        this.title_Th = title_Th;
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
    public String getTitle_Th() {
        return title_Th;
    }
    public void setTitle_Th(String title_Th) {
        this.title_Th = title_Th;
    }

    public static CategoryDto fromEntity(CategoryEntity entity) {
        return new CategoryDto(entity.getId(), entity.getTitle(), entity.getTitle_Th());
    }

    public static List<CategoryDto> fromEntities(List<CategoryEntity> entities) {
        return entities.stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }
}