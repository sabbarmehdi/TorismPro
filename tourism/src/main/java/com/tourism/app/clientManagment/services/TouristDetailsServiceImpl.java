package com.tourism.app.clientManagment.services;

import com.tourism.app.clientManagment.repository.TouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TouristDetailsServiceImpl implements UserDetailsService {
    @Autowired
    TouristRepo touristRepo;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return  UserDetailsImpl.build(touristRepo.findByMail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Tourist Not Found with Email: " + username)));
    }
}
