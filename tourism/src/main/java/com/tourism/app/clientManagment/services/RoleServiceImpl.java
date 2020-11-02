package com.tourism.app.clientManagment.services;

import com.tourism.app.clientManagment.model.ERole;
import com.tourism.app.clientManagment.model.Role;
import com.tourism.app.clientManagment.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepo roleRepository;

    @Override
    public Optional<Role> findByName(ERole name) {
        return Optional.of(roleRepository.findByName(name));
    }
}
