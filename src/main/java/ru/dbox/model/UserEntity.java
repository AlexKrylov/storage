package ru.dbox.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNTS", schema = "ACCOUNT_MANAGER")
public class UserEntity implements Serializable, Comparable<UserEntity> {
    private String login;
    private long userId;

    public UserEntity() {
    }

    public UserEntity(String login, long userId) {
        this.login = login;
        this.userId = userId;
    }

    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Id
    @Column(name = "USER_ID")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public int compareTo(UserEntity o) {
        return Long.compare(o.userId, this.userId);
    }
}
