package ru.dbox.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "USER_AUTH", schema = "ACCOUNT_MANAGER")
public class RoleEntity implements Serializable, Comparable<RoleEntity> {
    @Id
    @Column(name = "USER_ID")
    private long user_id;

    @Column(name = "ROLE")
    private String role;

    private ArrayList<UserEntity> userEntitySet;

    public RoleEntity(){}

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToMany(mappedBy = "ROLES")
    public ArrayList<UserEntity> getUsers() {
        return userEntitySet;
    }

    public void setUsers(ArrayList<UserEntity> userEntities) {
        this.userEntitySet = userEntities;
    }

    @Override
    public int compareTo(RoleEntity o) {
        return Long.compare(o.user_id, this.user_id);
    }
}
