package org.omm.model;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private int user_id;
    private String userName;
    private String userEmail;

    private Set<Role> roles;
}
