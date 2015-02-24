package ru.tsystems.eCare.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sevasan on 2/16/2015.
 */
@Entity
@Table(name = "roles")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles", unique = true, nullable = false)
    private long roleID;

    @Column(name = "name_roles")
    private String roleName;


    public long getRoleID() {
        return this.roleID;
    }
    public void setRoleID(long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return this.roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
