package com.example.mimile.beans;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer uid;
    @NotNull
    @Column(length=30,unique = true)
    private String account;
    @NotNull
    @Column(length=30)
    private String password;
    @Column(length=30)
    private String name;
    private LocalDateTime birthday;
    @Column(length=11)
    private String mobile;
    @Column(length=100)
    private String email;
    private Integer lasttime;//最后登录时间
    private Integer logincount;//登录次数
    private Integer validstate=1; //用户是否有效,0表示无效，1表示有效

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLasttime() {
        return lasttime;
    }

    public void setLasttime(Integer lasttime) {
        this.lasttime = lasttime;
    }

    public Integer getLogincount() {
        return logincount;
    }

    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    public Integer getValidstate() {
        return validstate;
    }

    public void setValidstate(Integer validstate) {
        this.validstate = validstate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid.equals(user.uid) && account.equals(user.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, account);
    }
}
