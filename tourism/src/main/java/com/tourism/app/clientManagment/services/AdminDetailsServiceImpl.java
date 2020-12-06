package com.tourism.app.clientManagment.services;

import com.tourism.app.clientManagment.repository.AdminRepo;
import com.tourism.app.clientManagment.repository.TouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AdminRepo adminRepo;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return  UserDetailsImpl.buildAdmin(adminRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Admin Not Found with Email: " + username)));
    }
}
