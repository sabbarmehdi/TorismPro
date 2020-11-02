package com.tourism.app.clientManagment.services;

import com.tourism.app.clientManagment.model.ERole;
import com.tourism.app.clientManagment.model.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(ERole name);
}
