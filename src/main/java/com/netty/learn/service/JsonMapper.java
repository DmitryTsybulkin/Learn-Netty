package com.netty.learn.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netty.learn.dto.RoleDto;
import com.netty.learn.dto.UserDto;
import com.netty.learn.entity.Role;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class JsonMapper {

    public String toJson(final Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.getLocalizedMessage();
        }
        return null;
    }

    public List<RoleDto> toRole(final InputStream stream) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(stream, new TypeReference<List<RoleDto>>(){});
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return null;
    }

    public UserDto toUser(final InputStream stream) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(stream, new TypeReference<UserDto>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserDto> toUserList(final InputStream stream) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(stream, new TypeReference<List<UserDto>>(){});
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return null;
    }

}
