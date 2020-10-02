package com.tourism.app.clientManagment.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.tourism.app.clientManagment.model.*;
import com.tourism.app.clientManagment.payload.request.LoginRequest;
import com.tourism.app.clientManagment.payload.request.SignupRequest;
import com.tourism.app.clientManagment.payload.response.JwtResponse;
import com.tourism.app.clientManagment.payload.response.MessageResponse;
import com.tourism.app.clientManagment.repository.*;
import com.tourism.app.clientManagment.security.jwt.JwtUtils;
import com.tourism.app.clientManagment.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    TourGuideRepo guideRepo;

    @Autowired
    TouristRepo touristRepo;

    @Autowired
    RoleRepo roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (clientRepo.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (clientRepo.existsByMail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Tourist tourist = new Tourist(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword())) {
        };

            Set<Role> roles = new HashSet<>();

            Optional<Role> optionalRole = Optional.ofNullable(roleRepository.findByName(ERole.ROLE_USER));
            Role userRole = optionalRole.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);


        tourist.setRoles(roles);
        clientRepo.save(tourist);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/tour-guide/signup")
    public ResponseEntity<?> registerTourGuide(@Valid @RequestBody SignupRequest signUpRequest) {
        if (guideRepo.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (guideRepo.existsByMail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new Tour Guide's account
        TourGuide guide = new TourGuide();
            guide.setLastName(signUpRequest.getLastName());
            guide.setFirstName(signUpRequest.getFirstName());
            guide.setUsername(signUpRequest.getUsername());
            guide.setMail(signUpRequest.getEmail());
            guide.setPassword(encoder.encode(SignupRequest.getPassword()));
            guide.setCin(signUpRequest.getCin());
            guide.setLicense(signUpRequest.getLicense());
            guide.setCar(signUpRequest.getCar());

        Set<Role> guidRoles = new HashSet<>();

        Optional<Role> optionalRole = Optional.ofNullable(roleRepository.findByName(ERole.ROLE_USER));
        Role userRole = optionalRole.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        guidRoles.add(userRole);

        Optional<Role> optionalGuideRole = Optional.ofNullable(roleRepository.findByName(ERole.ROLE_TOURGUIDE));
        Role modRole = optionalGuideRole.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        guidRoles.add(modRole);

        guide.setRoles(guidRoles);
        clientRepo.save(guide);

        return ResponseEntity.ok(new MessageResponse("Tour Guide registered successfully!"));
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignupRequest signUpRequest) {
        if (adminRepo.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (adminRepo.existsByMail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Admin admin = new Admin();
            admin.setLastName(signUpRequest.getLastName());
            admin.setFirstName(signUpRequest.getFirstName());
            admin.setUsername(signUpRequest.getUsername());
            admin.setMail(signUpRequest.getEmail());
            admin.setPassword(encoder.encode(SignupRequest.getPassword()));

        Set<Role> adminRoles = new HashSet<>();


        Optional<Role> optionalAdmin = Optional.ofNullable(roleRepository.findByName(ERole.ROLE_ADMIN));
        Role adminRole = optionalAdmin.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        adminRoles.add(adminRole);


        Optional<Role> optionalGuideRole = Optional.ofNullable(roleRepository.findByName(ERole.ROLE_TOURGUIDE));
        Role guideRole = optionalGuideRole.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        adminRoles.add(guideRole);

        Optional<Role> optionalRole = Optional.ofNullable(roleRepository.findByName(ERole.ROLE_USER));
        Role userRole = optionalRole.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        adminRoles.add(userRole);


        admin.setRoles(adminRoles);
        clientRepo.save(admin);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
