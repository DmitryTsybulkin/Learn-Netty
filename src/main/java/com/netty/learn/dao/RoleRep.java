package com.netty.learn.dao;

import com.netty.learn.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRep extends JpaRepository<Role, String> {
}
