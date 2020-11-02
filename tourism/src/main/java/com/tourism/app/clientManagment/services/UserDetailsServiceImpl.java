package com.tourism.app.clientManagment.services;
import com.tourism.app.clientManagment.model.Client;
import com.tourism.app.clientManagment.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Collections.emptyList;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ClientRepo clientRepo;

    public UserDetailsServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client user = clientRepo.findByMail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getMail(), user.getPassword(), emptyList());
    }

}