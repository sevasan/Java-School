package ru.tsystems.eCare.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sevasan on 2/17/2015.
 */
@Entity
@Table(name = "options")
@NamedQueries({
        @NamedQuery(name = "Option.findAll", query = "SELECT o FROM Option o")
})
public class Option implements Serializable, Comparable<Option> {
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="incompatible_options",
            joinColumns=@JoinColumn(name="id_src_option"),
            inverseJoinColumns=@JoinColumn(name="id_incompatible_option"))
    private Set<Option> incompatibleOptions = new HashSet<Option>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="required_options",
            joinColumns=@JoinColumn(name="id_src_option"),
            inverseJoinColumns=@JoinColumn(name="id_required_option"))
    private Set<Option> requiredOptions = new HashSet<Option>();

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
    public void addRequiredOption(Option option) {
        this.requiredOptions.add(option);
    }
    public void deleteRequiredOption(Option option) {
        this.requiredOptions.remove(option);
    }

    public Set<Option> getIncompatibleOptions() {
        return incompatibleOptions;
    }
    public void setIncompatibleOptions(Set<Option> incompatibleOptions) {
        this.incompatibleOptions = incompatibleOptions;
    }
    public void addIncompatibleOption(Option option) {
        this.incompatibleOptions.add(option);
    }
    public void deleteIncompatibleOption(Option option) {
        this.incompatibleOptions.remove(option);
    }

    @Override
    public String toString() {
        return "Option{" +
                "title='" + optionTitle + '\'' +
                ", price=" + optionPrice +
                ", activationPrice=" + optionActivationPrice +
                '}';
    }

    @Override
    public boolean equals(Object option) {
        if (this == option) return true;
        if (option == null || getClass() != option.getClass()) return false;

        Option op = (Option) option;

        if (optionActivationPrice != op.optionActivationPrice) return false;
        if (optionPrice != op.optionPrice) return false;
        if (!optionTitle.equals(op.optionTitle)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = optionTitle.hashCode();
        result = 31 * result + optionPrice;
        result = 31 * result + optionActivationPrice;
        return result;
    }

    @Override
    public int compareTo(Option option) {
        return this.toString().compareTo(option.toString());
    }
}
