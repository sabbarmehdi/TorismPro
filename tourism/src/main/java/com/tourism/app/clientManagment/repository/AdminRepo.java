package com.tourism.app.clientManagment.repository;

import com.tourism.app.clientManagment.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {


    Admin findByMail(String mail);
    Admin findByUsername(String username);

    boolean existsByMail(String Email);
    boolean existsByUsername(String username);

    void deleteByMail(String email);
}
