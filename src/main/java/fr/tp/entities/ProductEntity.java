package fr.tp.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Product")
public class ProductEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Stock")
    private Integer stock;

    @Column(name = "IsBestSale")
    private Boolean isBestSale;

    @Column(name = "IsBestOffer")
    private Boolean isBestOffer;

    @ManyToMany(mappedBy = "products")
    private Set<CommandLineEntity> commandLines;

    @ManyToMany
    @JoinTable(
            name = "ProductCategoryLink",
            joinColumns = @JoinColumn(name = "IdProduct"),
            inverseJoinColumns = @JoinColumn(name = "IdCategory")
    )
    private Set<CategoryEntity> categories;

    @OneToMany(mappedBy = "product")
    private Set<ImageEntity> images;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<CommandLineEntity> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines(Set<CommandLineEntity> commandLines) {
        this.commandLines = commandLines;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }

    public Set<ImageEntity> getImages() {
        return images;
    }

    public void setImages(Set<ImageEntity> images) {
        this.images = images;
    }
}