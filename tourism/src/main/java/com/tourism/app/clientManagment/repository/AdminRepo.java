package com.tourism.app.clientManagment.repository;

import com.tourism.app.clientManagment.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {


    Optional<Admin> findByMail(String mail);
    Optional<Admin> findByUsername(String username);

    boolean existsByMail(String Email);
    boolean existsByUsername(String username);

    void deleteByMail(String email);
}
