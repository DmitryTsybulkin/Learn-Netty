package com.netty.learn.service;

import com.netty.learn.dao.RoleRep;
import com.netty.learn.dao.UserRep;
import com.netty.learn.dto.UserDto;
import com.netty.learn.dto.UserDtoBuilder;
import com.netty.learn.entity.Role;
import com.netty.learn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String getUserById(final String id) {
        return jsonMapper.toJson(toDto(userRep.findById(Long.valueOf(id)).orElseThrow(NullPointerException::new)));
    }

    private UserDto toDto(final User user) {
        return new UserDtoBuilder()
                .withId(user.getId())
                .withCarNumber(user.getCarNumber())
                .withAmount(user.getAmount())
                .withAllTimeParking(user.getAllTimeParking())
                .withDebt(user.getDebt())
                .withRoles(user.getRoles().stream().map(Role::getRole).collect(Collectors.toList())).build();
    }

}
