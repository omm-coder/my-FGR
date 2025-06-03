package org.omm.repository.impl;

import org.omm.model.User;
import org.omm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepoIMPL implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<User> findByUserName(String userName) {
        String sql = "select * from users where user_name = ?";

         jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userName);

        return Optional.empty();
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
