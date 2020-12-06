package com.tourism.app.clientManagment.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.tourism.app.clientManagment.model.*;
import com.tourism.app.clientManagment.payload.request.LoginRequest;
import com.tourism.app.clientManagment.payload.request.SignupRequest;
import com.tourism.app.clientManagment.payload.response.JwtResponse;
import com.tourism.app.clientManagment.payload.response.MessageResponse;
import com.tourism.app.clientManagment.repository.*;
import com.tourism.app.clientManagment.security.authProviders.AdminAuthenticationProvider;
import com.tourism.app.clientManagment.security.authProviders.GuideAuthenticationProvider;
import com.tourism.app.clientManagment.security.authProviders.TouristAuthenticationProvider;
import com.tourism.app.clientManagment.security.jwt.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import com.tourism.app.clientManagment.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    TouristAuthenticationProvider touristAuthenticationProvider;
    @Autowired
    GuideAuthenticationProvider guideAuthenticationProvider;
    @Autowired
    AdminAuthenticationProvider adminAuthenticationProvider;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    TourGuideRepo guideRepo;

    @Autowired
    TouristRepo touristRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authenticate(loginRequest, touristAuthenticationProvider);
    }

    @PostMapping("/guide/signin")
    public ResponseEntity<?> authenticateGuide(@Valid @RequestBody LoginRequest loginRequest){
        return authenticate(loginRequest, guideAuthenticationProvider);
    }

    @PostMapping("/admin/signin")
    public ResponseEntity<?> authenticateAdmin(@Valid @RequestBody LoginRequest loginRequest) {
        return authenticate(loginRequest, adminAuthenticationProvider);
    }

    public ResponseEntity<?> authenticate(@Valid @RequestBody LoginRequest loginRequest, DaoAuthenticationProvider daoAuthenticationProvider) {

        /*System.out.println(":::::::::::::::::::::::::::::::::::: SIGNIN");
        System.out.println(":::::::::::::::::::email : " + loginRequest.getUsername());
        System.out.println(":::::::::::::::::::password : " + loginRequest.getPassword());*/
        logger.info(":::::::::::::::::::email : " + loginRequest.getUsername());
        logger.info("::::::::::::::::password : " + loginRequest.getPassword());
        try {
            logger.warn("AuthController:" + loginRequest.getUsername());
            Authentication authentication = daoAuthenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());
            logger.warn("AuthController:" + userDetails.getUserType());
            return ResponseEntity
                    .ok(new JwtResponse(jwt,
                            userDetails.getId(),
                            userDetails.getUsername(),
                            userDetails.getUserType(),
                            roles));
        }catch (AuthenticationException exception){
            return ResponseEntity.badRequest()
                                .body(new MessageResponse("user ad illa gis kra"));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        /*System.out.println("username : " + signUpRequest.getUsername());
        System.out.println("lastname : " + signUpRequest.getLastName());
        System.out.println("firstname : " + signUpRequest.getFirstName());
        System.out.println("email : " + signUpRequest.getEmail());
        System.out.println("password : " + signUpRequest.getPassword());*/

        if (touristRepo.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: email is already taken!"));
        }


        // Create new user's account
        Tourist tourist = new Tourist();
            tourist.setUsername(signUpRequest.getUsername());
            tourist.setFirstName(signUpRequest.getFirstName());
            tourist.setLastName(signUpRequest.getLastName());
            tourist.setPassword(encoder.encode(signUpRequest.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepo.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);

        System.out.println("role : " + userRole);

        /*System.out.println("username : " + signUpRequest.getUsername());
        System.out.println("lastname : " + signUpRequest.getLastName());
        System.out.println("firstname : " + signUpRequest.getFirstName());
        System.out.println("email : " + signUpRequest.getEmail());
        System.out.println("password : " + signUpRequest.getPassword());
        System.out.println("role : " + userRole);*/

        tourist.setRoles(roles);
        touristRepo.save(tourist);


        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/guide/signup")
    public ResponseEntity<?> registerTourGuide(@Valid @RequestBody SignupRequest signUpRequest) {

        /*System.out.println("username : " + signUpRequest.getUsername());
        System.out.println("lastname : " + signUpRequest.getLastName());
        System.out.println("firstname : " + signUpRequest.getFirstName());
        System.out.println("email : " + signUpRequest.getEmail());
        System.out.println("password : " + signUpRequest.getPassword());
        System.out.println("username : " + signUpRequest.getCin());
        System.out.println("lastname : " + signUpRequest.getLicense());
        System.out.println("firstname : " + signUpRequest.getCar().getModel());
        System.out.println("email : " + signUpRequest.getCar().getOwner());
        System.out.println("password : " + signUpRequest.getCar().getSeatsNum());*/

        if (guideRepo.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: email is already taken!"));
        }


        // Create new Tour Guide's account
        TourGuide guide = new TourGuide();
        guide.setLastName(signUpRequest.getLastName());
        guide.setFirstName(signUpRequest.getFirstName());
        guide.setUsername(signUpRequest.getUsername());
        guide.setPassword(encoder.encode(signUpRequest.getPassword()));
        guide.setCin(signUpRequest.getCin());
        guide.setLicense(signUpRequest.getLicense());
        Car newCar = new Car();
        newCar.setModel(signUpRequest.getCar().getModel());
        newCar.setOwner(signUpRequest.getCar().getOwner());
        newCar.setSeatsNum(signUpRequest.getCar().getSeatsNum());
        newCar.setRegistrationNum(signUpRequest.getCar().getRegistrationNum());
        guide.setCar(newCar);

        Set<Role> guidRoles = new HashSet<>();

        Role userRole = roleRepo.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        guidRoles.add(userRole);

        Role guideRole = roleRepo.findByName(ERole.ROLE_TOURGUIDE)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        guidRoles.add(guideRole);

        guide.setRoles(guidRoles);
        guideRepo.save(guide);

        return ResponseEntity.ok(new MessageResponse("Tour Guide registered successfully!"));
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignupRequest signUpRequest) {
        if (adminRepo.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: email is already taken!"));
        }


        // Create new user's account
        Admin admin = new Admin();
            admin.setLastName(signUpRequest.getLastName());
            admin.setFirstName(signUpRequest.getFirstName());
            admin.setUsername(signUpRequest.getUsername());
            admin.setPassword(encoder.encode(signUpRequest.getPassword()));

        Set<Role> adminRoles = new HashSet<>();

        //Set Admin Roles
        Role adminRole = roleRepo.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        adminRoles.add(adminRole);

        Role usrRole = roleRepo.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        adminRoles.add(usrRole);

        Role guideRole = roleRepo.findByName(ERole.ROLE_TOURGUIDE)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        adminRoles.add(guideRole);

        admin.setRoles(adminRoles);

        adminRepo.save(admin);

        return ResponseEntity.ok(new MessageResponse("Admin registered successfully!"));
    }
}
