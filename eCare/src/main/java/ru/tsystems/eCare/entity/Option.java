package ru.tsystems.eCare.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by sevasan on 2/17/2015.
 */
@Entity
@Table(name = "options")
@NamedQuery(name = "Option.findAll", query = "SELECT o FROM Option o")
public class Option implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_options")
    private long optionID;

    @Column(name = "title_options")
    private String optionTitle;

    @Column(name = "price_options")
    private int optionPrice;

    @Column(name = "activation_price_options")
    private int optionActivationPrice;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="incompatible_options",
            joinColumns=@JoinColumn(name="id_src_option"),
            inverseJoinColumns=@JoinColumn(name="id_incompatible_option"))
    private Set<Option> incompatibleOptions;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="required_options",
            joinColumns=@JoinColumn(name="id_src_option"),
            inverseJoinColumns=@JoinColumn(name="id_required_option"))
    private Set<Option> requiredOptions;

    public long getOptionID() {
        return optionID;
    }
    public void setOptionID(long optionID) {
        this.optionID = optionID;
    }

    public String getOptionTitle() {
        return optionTitle;
    }
    public void setOptionTitle(String optionTitle) {
        this.optionTitle = optionTitle;
    }

    public int getOptionPrice() {
        return optionPrice;
    }
    public void setOptionPrice(int optionPrice) {
        this.optionPrice = optionPrice;
    }

    public int getOptionActivationPrice() {
        return optionActivationPrice;
    }
    public void setOptionActivationPrice(int optionActivationPrice) {
        this.optionActivationPrice = optionActivationPrice;
    }

    public Set<Option> getRequiredOptions() {
        return requiredOptions;
    }
    public void setRequiredOptions(Set<Option> requiredOptions) {
        this.requiredOptions = requiredOptions;
    }

    public Set<Option> getIncompatibleOptions() {
        return incompatibleOptions;
    }
    public void setIncompatibleOptions(Set<Option> incompatibleOptions) {
        this.incompatibleOptions = incompatibleOptions;
    }

}
