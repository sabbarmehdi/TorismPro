package com.tourism.app.clientManagment.services;

import com.tourism.app.clientManagment.model.Tourist;
import com.tourism.app.clientManagment.repository.TouristRepo;
import com.tourism.app.tripManagment.exception.TripNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TouristDetailsServiceImpl implements UserDetailsService, TouristService {
    @Autowired
    TouristRepo touristRepo;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return  UserDetailsImpl.buildTourist(touristRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Tourist Not Found with Email: " + username)));
    }

    @Override
    public Tourist getTouristById(Long id) {
        Optional<Tourist> optionalTourist = Optional.ofNullable(touristRepo.findTouristById(id));
        Tourist tourist = optionalTourist.orElseThrow(TripNotFoundException::new);
        return tourist;
    }
}
