package com.tourism.app.clientManagment.security.services;
import com.tourism.app.clientManagment.model.Client;
import com.tourism.app.clientManagment.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    ClientRepo clientRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client user = clientRepo.findByUsername(username);

        return UserDetailsImpl.build(user);
    }

}