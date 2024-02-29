package fr.tp.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Product")
public class ProductEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

    @Column(name = "Title_Th", columnDefinition = "NVARCHAR")
    private String title_Th;

    @Column(name = "Content_Th", columnDefinition = "NVARCHAR")
    private String content_Th;

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
    private Set<CategoryEntity> categories = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "IdImage")
    private ImageEntity image;

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

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

}