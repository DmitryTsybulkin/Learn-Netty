package com.netty.learn.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    public Long id;
    public String carNumber;
    public BigDecimal amount;
    public BigDecimal debt;
    public Timestamp allTimeParking;
    public List<String> roles;
}
