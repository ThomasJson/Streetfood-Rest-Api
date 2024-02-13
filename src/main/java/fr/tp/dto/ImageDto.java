package fr.tp.dto;

import fr.tp.entities.ImageEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ImageDto {
    private UUID id;
    private String src;
    private String alt;

    public ImageDto(ImageEntity image) {

        this.id = image.getId();
        this.src = image.getSrc();
        this.alt = image.getAlt();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public static ImageDto fromEntity(ImageEntity entity) {
        return new ImageDto(entity);
    }

    public static List<ImageDto> fromEntities(List<ImageEntity> entities) {
        return entities.stream()
                .map(ImageDto::fromEntity)
                .collect(Collectors.toList());
    }

}
