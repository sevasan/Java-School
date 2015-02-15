package ru.tsystems.eCare.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sevasan on 2/15/2015.
 */

@Entity
@Table(name = "users", catalog = "eCare")
public class UserEntity implements Serializable {
    private Integer userID;
    private String userName;
    private String userLastName;
    private Date userBirthday;
    private String userIDCard;
    private String userAddress;
    private String userEmail;
    private String userPassword;
    private Role userRole;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users", unique = true, nullable = false)
    public Integer getUserID() {
        return this.userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Column(name = "name_users", length = 45)
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "lastname_users", length = 45)
    public String getUserLastName() {
        return this.userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate_users")
    public Date getUserBirthday() {
        return this.userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Column(name = "ID_card_users")
    public String getUserIDCard() {
        return this.userIDCard;
    }

    public void setUserIDCard(String userIDCard) {
        this.userIDCard = userIDCard;
    }

    @Column(name = "address_users")
    public String getUserAddress() {
        return this.userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Column(name = "email_users")
    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "password_users")
    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword() {
        this.userPassword = userPassword;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Role getRole() {
        return this.userRole;
    }

    public void setRole(Role role) {
        this.userRole = userRole;
    }
}
