package com.netty.learn.service;

import com.netty.learn.dao.RoleRep;
import com.netty.learn.dao.UserRep;
import com.netty.learn.dto.UserDto;
import com.netty.learn.dto.UserDtoBuilder;
import com.netty.learn.entity.Role;
import com.netty.learn.entity.User;
import com.netty.learn.entity.UserBuilder;
import com.netty.learn.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final RoleRep roleRep;
    private final UserRep userRep;
    private final JsonMapper jsonMapper;

    @Autowired
    public UserService(RoleRep roleRep, UserRep userRep, JsonMapper jsonMapper) {
        this.roleRep = roleRep;
        this.userRep = userRep;
        this.jsonMapper = jsonMapper;
    }

    @Transactional
    public Long createUser(final InputStream newUser) {
        return userRep.save(fromDto(jsonMapper.toUser(newUser))).getId();
    }

    @Transactional(readOnly = true)
    public UserDto getUserById(final Long id) {
        UserDto dto = new UserDto();
        User user = userRep.findById(id).orElseThrow(NullPointerException::new);
        dto.id = user.getId();
        dto.carNumber = user.getCarNumber();
        dto.allTimeParking = user.getAllTimeParking();
        dto.roles = user.getRoles().stream().map(Role::getRole).collect(Collectors.toList());
        return dto;
    }

    public UserDto toDto(final User user) {
        return new UserDtoBuilder()
                .withId(user.getId())
                .withCarNumber(user.getCarNumber())
                .withAmount(user.getAmount())
                .withAllTimeParking(user.getAllTimeParking())
                .withDebt(user.getDebt())
                .withRoles(user.getRoles().stream().map(Role::getRole).collect(Collectors.toList())).build();
    }

    public User fromDto(final UserDto dto) {
        return new UserBuilder()
                .withCarNumber(dto.carNumber)
                .withAmount(dto.amount)
                .withAllTimeParking(dto.allTimeParking)
                .withDebt(dto.debt)
                .withRoles(dto.roles.stream().map(s -> roleRep.findById(s).orElseThrow(ResourceNotFound::new))
                        .collect(Collectors.toSet()))
                .build();
    }

}
