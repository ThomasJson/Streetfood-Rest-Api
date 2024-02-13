package fr.tp.dto;

import fr.tp.entities.ImageEntity;
import fr.tp.entities.ProductEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductDto {
    private UUID id;
    private String title;
    private String content;
    private List<ImageDto> images;
    private BigDecimal price;
    private Integer stock;
    private Boolean isBestSale;
    private Boolean isBestOffer;

    // TODO : A checker pour les images
    public ProductDto(ProductEntity product, List<ImageEntity> imageEntities) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.content = product.getContent();
        this.images = imageEntities != null ? imageEntities.stream()
                .map(ImageDto::new) // Convertir les entités d'image en DTOs d'image
                .collect(Collectors.toList()) : new ArrayList<>();
    }

    // Surcharge du constructeur qui accepte seulement un ProductEntity
    public ProductDto(ProductEntity product) {
        this(product, product.getImages() != null ? new ArrayList<>(product.getImages()) : null);
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getBestSale() {
        return isBestSale;
    }

    public void setBestSale(Boolean bestSale) {
        isBestSale = bestSale;
    }

    public Boolean getBestOffer() {
        return isBestOffer;
    }

    public void setBestOffer(Boolean bestOffer) {
        isBestOffer = bestOffer;
    }

    public static ProductDto fromEntity(ProductEntity entity) {
        return new ProductDto(entity);
    }

    public static List<ProductDto> fromEntities(List<ProductEntity> entities) {
        return entities.stream()
                .map(ProductDto::fromEntity)
                .collect(Collectors.toList());
    }
}
