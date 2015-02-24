package ru.tsystems.eCare.entity;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by sevasan on 2/19/2015.
 */
@Entity
@Table(name = "plans")
@NamedQuery(name = "Plan.findAll", query = "SELECT p FROM Plan p")
public class Plan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plans")
    private long planID;

    @Column(name = "price_plans")
    private int planPrice;

    @Column(name = "title_plans")
    private String planTitle;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="plan_options",
            joinColumns=@JoinColumn(name="plan_id"),
            inverseJoinColumns=@JoinColumn(name="option_id"))
    private Set<Option> planOptions;

    public Set<Option> getPlanOptions() {
        return planOptions;
    }
    public void setPlanOptions(Set<Option> planOptions) {
        this.planOptions = planOptions;
    }

    public long getPlanID() {
        return planID;
    }
    public void setPlanID(long planID) {
        this.planID = planID;
    }

    public int getPlanPrice() {
        return planPrice;
    }
    public void setPlanPrice(int planPrice) {
        this.planPrice = planPrice;
    }

    public String getPlanTitle() {
        return planTitle;
    }
    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }
}
