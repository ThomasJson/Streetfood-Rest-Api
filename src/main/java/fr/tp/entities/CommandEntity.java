package fr.tp.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Command")
public class CommandEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "CommandDate")
    private LocalDate commandDate;

    @Column(name = "Status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "IdPaymentMean")
    private PaymentMeanEntity paymentMean;

    @ManyToOne
    @JoinColumn(name = "IdAccount")
    private AccountEntity account;

    @ManyToOne
    @JoinColumn(name = "IdDeliveryAddress")
    private DeliveryAddressEntity deliveryAddress;

    @OneToMany(mappedBy = "command")
    private Set<CommandLineEntity> commandLines;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getCommandDate() {
        return commandDate;
    }

    public void setCommandDate(LocalDate commandDate) {
        this.commandDate = commandDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PaymentMeanEntity getPaymentMean() {
        return paymentMean;
    }

    public void setPaymentMean(PaymentMeanEntity paymentMean) {
        this.paymentMean = paymentMean;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public DeliveryAddressEntity getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressEntity deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}