package org.omm.repository;

import org.omm.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUserName(String userName);
    boolean existsByEmail(String email);

}
