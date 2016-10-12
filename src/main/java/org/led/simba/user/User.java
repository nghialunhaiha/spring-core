package org.led.simba.user;
import org.led.simba.common.BaseDomain;

import  static  org.led.simba.user.UserConstants.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = USER_TABLE)
public class User extends BaseDomain{

    @Column(name = USER_NAME)
    private String username;

    @Column(name = USER_ADDRESS)
    private String address;

    @Column(name = USER_EMAIL)
    private String email;

    public User() {
    }

    public User(long id, String username, String address, String email) {
        this.id = 0;
        this.username = username;
        this.address = address;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", address=" + address + ", email=" + email + "]";
    }

}
