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
    private String title_Th;
    private String content_Th;
    private ImageDto image;
    private BigDecimal price;
    private Integer stock;
    private Boolean isNew;
    private Boolean isBestSale;
    private Boolean isBestOffer;

    public ProductDto(ProductEntity product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.content = product.getContent();
        this.title_Th = product.getTitle_Th();
        this.content_Th = product.getContent_Th();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.isNew = product.getNew();
        this.isBestSale = product.getBestSale();
        this.isBestOffer = product.getBestOffer();
        this.image = product.getImage() != null ? new ImageDto(product.getImage()) : null;
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

    public String getTitle_Th() {
        return title_Th;
    }

    public void setTitle_Th(String title_Th) {
        this.title_Th = title_Th;
    }

    public String getContent_Th() {
        return content_Th;
    }

    public void setContent_Th(String content_Th) {
        this.content_Th = content_Th;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
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

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
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
