package com.netty.learn;

import com.netty.learn.dao.UserRep;
import com.netty.learn.dao.RoleRep;
import com.netty.learn.entity.Role;
import com.netty.learn.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@SpringBootApplication
public class NettyLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyLearnApplication.class, args);
    }

    @Bean
    CommandLineRunner initDb(final RoleRep roleRep, final UserRep userRep) {
		return args -> {
			log.info("saved: " + roleRep.save(new Role("USER")));
			Set<Role> roles = new HashSet<Role>(Collections.singleton(roleRep.findById("USER").get()));
			log.info("saved: " + userRep.save(new User("car321",
					BigDecimal.valueOf(500.0),
					BigDecimal.valueOf(30.0),
					Timestamp.valueOf(LocalDateTime.of(0, 1, 1, 5, 30)), roles)));
		};
    }
}
