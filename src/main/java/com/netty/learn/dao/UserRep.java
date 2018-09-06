package com.netty.learn.dao;

import com.netty.learn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Long> {
}
