package fr.tp.entities;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "PaymentMean")
public class PaymentMeanEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "Type")
    private String type;

    @Column(name = "PaymentData")
    private String paymentData;

    @OneToMany(mappedBy = "paymentMean")
    private Set<CommandEntity> commands;

    @ManyToMany(mappedBy = "paymentMeans")
    private Set<AccountEntity> accounts;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }

    public Set<CommandEntity> getCommands() {
        return commands;
    }

    public void setCommands(Set<CommandEntity> commands) {
        this.commands = commands;
    }

    public Set<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountEntity> accounts) {
        this.accounts = accounts;
    }
}