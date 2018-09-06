package com.netty.learn.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

public final class UserBuilder {
    private Long id;
    private String carNumber;
    private BigDecimal amount;
    private BigDecimal debt;
    private Timestamp allTimeParking;
    private Set<Role> roles;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder withCarNumber(String carNumber) {
        this.carNumber = carNumber;
        return this;
    }

    public UserBuilder withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public UserBuilder withDebt(BigDecimal debt) {
        this.debt = debt;
        return this;
    }

    public UserBuilder withAllTimeParking(Timestamp allTimeParking) {
        this.allTimeParking = allTimeParking;
        return this;
    }

    public UserBuilder withRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.setCarNumber(carNumber);
        user.setAmount(amount);
        user.setDebt(debt);
        user.setAllTimeParking(allTimeParking);
        user.setRoles(roles);
        return user;
    }
}
