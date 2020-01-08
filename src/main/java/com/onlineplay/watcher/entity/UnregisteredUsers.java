/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.onlineplay.watcher.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Anđelka
 */

@Entity
@Table(name = "unregistered_users")
public class UnregisteredUsers  implements Serializable{

    @Id
    @JoinColumn(name = "id_unregistered_user", referencedColumnName = "id_user", insertable = false, nullable = false)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Users user;

    public UnregisteredUsers() {
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnregisteredUsers other = (UnregisteredUsers) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UnregisteredUsers{" + "user=" + user + '}';
    }

    
}
