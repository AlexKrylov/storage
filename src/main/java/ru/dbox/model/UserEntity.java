package ru.dbox.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "ACCOUNTS", schema = "ACCOUNT_MANAGER")
public class UserEntity implements Serializable, Comparable<UserEntity> {
    @Id
    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    private ArrayList<RoleEntity> roleEntitySet;

    public UserEntity() {
    }

    public UserEntity(String login, long userId) {
        this.login = login;
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany
    @JoinTable(name = "USER_AUTH", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "USR_ID"))
    public ArrayList<RoleEntity> getRoles() {
        return roleEntitySet;
    }

    public void setRoles(ArrayList<RoleEntity> roleEntitySet) {
        this.roleEntitySet = roleEntitySet;
    }

    @Override
    public int compareTo(UserEntity o) {
        return Long.compare(o.userId, this.userId);
    }
}
