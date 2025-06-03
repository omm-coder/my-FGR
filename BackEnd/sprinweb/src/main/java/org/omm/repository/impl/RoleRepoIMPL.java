package org.omm.repository.impl;

import org.omm.model.Role;
import org.omm.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleRepoIMPL implements RoleRepository {
    @Override
    public Optional<Role> findByName(String name) {

        return Optional.empty();
    }
}
