package com.onlineplay.watcher.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registered_users")
public class RegisteredUsers  implements Serializable{

    @Id
    @JoinColumn(name = "id_registered_user", referencedColumnName = "id_user", insertable = false, nullable = false)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Users user;

    public RegisteredUsers() {
        super();
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
        hash = 53 * hash + Objects.hashCode(this.user);
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
        final RegisteredUsers other = (RegisteredUsers) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegisteredUsers{" + "user=" + user + '}';
    }
    
    
}