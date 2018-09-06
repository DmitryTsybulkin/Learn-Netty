package com.netty.learn.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netty.learn.entity.Role;
import com.netty.learn.entity.User;
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

    public List<Role> toRole(final InputStream stream) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(stream, new TypeReference<List<Role>>(){});
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return null;
    }

    public List<User> toUser(final InputStream stream) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(stream, new TypeReference<List<User>>(){});
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return null;
    }

}
