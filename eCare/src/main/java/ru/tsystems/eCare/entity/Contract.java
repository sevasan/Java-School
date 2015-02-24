package ru.tsystems.eCare.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by sevasan on 2/17/2015.
 */
@Entity
@Table(name = "contracts")
@NamedQuery(name = "Contract.findAll", query = "SELECT c FROM Contract c")
public class Contract implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contracts")
    private long contractID;

    @Column(name = "phoneNumber_contracts")
    private String phonenumber;

    @Column(name = "isBlockedByClient_contracts")
    private boolean isBlockedByClient;

    @Column(name = "isBlockedByOperator_contracts")
    private boolean isBlockedByOperator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client_contracts")
    private User client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_contracts")
    private Plan plan;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="contract_options",
            joinColumns=@JoinColumn(name="id_contract"),
            inverseJoinColumns=@JoinColumn(name="id_option"))
    private Set<Option> selectedOptions;

    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }

    public Plan getPlan() {
        return plan;
    }
    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Set<Option> getSelectedOptions() {
        return selectedOptions;
    }
    public void setSelectedOptions(Set<Option> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    private long getContractID() {
        return contractID;
    }
    public void setContractID(long contractID) {
        this.contractID = contractID;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public boolean isBlockedByClient() {
        return isBlockedByClient;
    }
    public void setBlockedByClient(boolean isBlockedByClient) {
        this.isBlockedByClient = isBlockedByClient;
    }

    public boolean isBlockedByOperator() {
        return isBlockedByOperator;
    }
    public void setBlockedByOperator(boolean isBlockedByOperator) {
        this.isBlockedByOperator = isBlockedByOperator;
    }
}
