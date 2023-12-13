package fr.tp.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Account")
public class AccountEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Mail")
    private String mail;

    @Column(name = "Pseudo")
    private String pseudo;

    @Column(name = "Password")
    private String password;

    @Column(name = "ConnectedAt")
    private LocalDate connectedAt;

    @Column(name = "AuthenticatedAt")
    private LocalDate authenticatedAt;

    @ManyToOne
    @JoinColumn(name = "IdAppUser")
    private AppUserEntity appUser;

    @ManyToOne
    @JoinColumn(name = "IdRole")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "IdBillingAddress")
    private BillingAddressEntity billingAddress;

    @OneToMany(mappedBy = "account")
    private Set<CommandEntity> commands;

    @ManyToMany
    @JoinTable(
            name = "AccountDeliveryAddressLink",
            joinColumns = @JoinColumn(name = "IdAccount"),
            inverseJoinColumns = @JoinColumn(name = "IdDeliveryAddress")
    )
    private Set<DeliveryAddressEntity> deliveryAddresses;

    @ManyToMany
    @JoinTable(
            name = "AccountPaymentMeanLink",
            joinColumns = @JoinColumn(name = "IdAccount"),
            inverseJoinColumns = @JoinColumn(name = "IdPaymentMean")
    )
    private Set<PaymentMeanEntity> paymentMeans;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getConnectedAt() {
        return connectedAt;
    }

    public void setConnectedAt(LocalDate connectedAt) {
        this.connectedAt = connectedAt;
    }

    public LocalDate getAuthenticatedAt() {
        return authenticatedAt;
    }

    public void setAuthenticatedAt(LocalDate authenticatedAt) {
        this.authenticatedAt = authenticatedAt;
    }

    public AppUserEntity getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUserEntity appUser) {
        this.appUser = appUser;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public BillingAddressEntity getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddressEntity billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Set<DeliveryAddressEntity> getDeliveryAddresses() {
        return deliveryAddresses;
    }

    public void setDeliveryAddresses(Set<DeliveryAddressEntity> deliveryAddresses) {
        this.deliveryAddresses = deliveryAddresses;
    }

    public Set<PaymentMeanEntity> getPaymentMeans() {
        return paymentMeans;
    }

    public void setPaymentMeans(Set<PaymentMeanEntity> paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

    public Set<CommandEntity> getCommands() {
        return commands;
    }

    public void setCommands(Set<CommandEntity> commands) {
        this.commands = commands;
    }

}