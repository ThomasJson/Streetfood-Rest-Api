package fr.tp.entities;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Role")
public class RoleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Weight")
    private Integer weight;

    @OneToMany(mappedBy = "role")
    private Set<AccountEntity> accounts;

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Set<AccountEntity> getAppUsers() {
        return accounts;
    }

    public void setAppUsers(Set<AccountEntity> accounts) {
        this.accounts = accounts;
    }
}