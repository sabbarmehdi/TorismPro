package com.tourism.app.clientManagment.repository;

import com.tourism.app.clientManagment.model.ERole;
import com.tourism.app.clientManagment.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByName(ERole name);
    void deleteByName(ERole name);
}
