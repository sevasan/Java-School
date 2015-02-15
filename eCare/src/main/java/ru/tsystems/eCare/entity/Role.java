package ru.tsystems.eCare.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sevasan on 2/16/2015.
 */
@Entity
@Table(name = "roles", catalog = "eCare")
public class Role {
    private Integer roleID;
    private String roleName;
    private Set<UserEntity> userEntities = new HashSet<UserEntity>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles", unique = true, nullable = false)
    public Integer getRoleID() {
        return this.roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    @Column(name = "name_roles")
    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    public Set<UserEntity> getUserEntities() {
        return this.userEntities;
    }

    public void setUserEntities(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
