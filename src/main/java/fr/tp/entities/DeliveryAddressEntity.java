package fr.tp.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DeliveryAddress")
public class DeliveryAddressEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PostalAddress")
    private String postalAddress;

    @ManyToOne
    @JoinColumn(name = "IdCity")
    private CityEntity city;

    @ManyToMany(mappedBy = "deliveryAddresses")
    private Set<AccountEntity> accounts;

    @OneToMany(mappedBy = "deliveryAddress")
    private Set<CommandEntity> commands;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public Set<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountEntity> accounts) {
        this.accounts = accounts;
    }

}