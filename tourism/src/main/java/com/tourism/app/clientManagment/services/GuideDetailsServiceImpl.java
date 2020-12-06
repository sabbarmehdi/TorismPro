package com.tourism.app.clientManagment.services;

import com.tourism.app.clientManagment.repository.TourGuideRepo;
import com.tourism.app.clientManagment.repository.TouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GuideDetailsServiceImpl implements UserDetailsService {
    @Autowired
    TourGuideRepo tourGuideRepo;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return  UserDetailsImpl.buildGuide(tourGuideRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Tour Guide Not Found with Email: " + username)));
    }
}
