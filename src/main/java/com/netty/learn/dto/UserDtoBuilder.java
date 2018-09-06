package com.netty.learn.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public final class UserDtoBuilder {
    public Long id;
    public String carNumber;
    public BigDecimal amount;
    public BigDecimal debt;
    public Timestamp allTimeParking;
    public List<String> roles;

    public UserDtoBuilder() {
    }

    public static UserDtoBuilder anUserDto() {
        return new UserDtoBuilder();
    }

    public UserDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UserDtoBuilder withCarNumber(String carNumber) {
        this.carNumber = carNumber;
        return this;
    }

    public UserDtoBuilder withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public UserDtoBuilder withDebt(BigDecimal debt) {
        this.debt = debt;
        return this;
    }

    public UserDtoBuilder withAllTimeParking(Timestamp allTimeParking) {
        this.allTimeParking = allTimeParking;
        return this;
    }

    public UserDtoBuilder withRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public UserDto build() {
        return new UserDto(id, carNumber, amount, debt, allTimeParking, roles);
    }
}
