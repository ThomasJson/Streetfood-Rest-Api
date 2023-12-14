package fr.tp.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "City")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "PostCode")
    private String postCode;

    @ManyToOne
    @JoinColumn(name = "IdCountry")
    private CountryEntity country;

    @OneToMany(mappedBy = "city")
    private Set<BillingAddressEntity> billingAddresses;

    @OneToMany(mappedBy = "city")
    private Set<DeliveryAddressEntity> deliveryAddresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public Set<BillingAddressEntity> getBillingAddresses() {
        return billingAddresses;
    }

    public void setBillingAddresses(Set<BillingAddressEntity> billingAddresses) {
        this.billingAddresses = billingAddresses;
    }

    public Set<DeliveryAddressEntity> getDeliveryAddresses() {
        return deliveryAddresses;
    }

    public void setDeliveryAddresses(Set<DeliveryAddressEntity> deliveryAddresses) {
        this.deliveryAddresses = deliveryAddresses;
    }
}