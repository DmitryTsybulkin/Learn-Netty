package com.netty.learn.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String carNumber;
    @Column
    private BigDecimal amount;
    @Column
    private BigDecimal debt;
    @Column
    private Timestamp allTimeParking;
    @Column
    @ManyToMany
    @JoinTable(name = "roles", joinColumns = @JoinColumn(name = "user"), inverseJoinColumns = @JoinColumn(name = "role"))
    private Set<Role> roles;

    public User(String carNumber, BigDecimal amount, BigDecimal debt, Timestamp allTimeParking, Set<Role> roles) {
        this.carNumber = carNumber;
        this.amount = amount;
        this.debt = debt;
        this.allTimeParking = allTimeParking;
        this.roles = roles;
    }

}
