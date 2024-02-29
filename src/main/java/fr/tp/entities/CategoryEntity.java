package fr.tp.entities;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Category")
public class CategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Title_Th", columnDefinition = "NVARCHAR")
    private String title_Th;

    @ManyToMany(mappedBy = "categories")
    private Set<ProductEntity> products;

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

    public String getTitle_Th() {
        return title_Th;
    }

    public void setTitle_Th(String title_Th) {
        this.title_Th = title_Th;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }
}