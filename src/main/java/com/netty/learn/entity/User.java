package com.netty.learn.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String login;
    @Column
    private String password;
    @ManyToMany
    @JoinTable(name = "USER-ROLES", joinColumns = @JoinColumn(name = "USER-ID"), inverseJoinColumns = @JoinColumn(name = "ROLE"))
    private Set<Role> role;

    public User(String login, String password, Set<Role> role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
