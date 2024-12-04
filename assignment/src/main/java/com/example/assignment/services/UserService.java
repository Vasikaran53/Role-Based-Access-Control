package com.example.assignment.services;

import com.example.assignment.models.Role;
import com.example.assignment.models.RoleName;
import com.example.assignment.models.User;
import com.example.assignment.repositories.RoleRepository;
import com.example.assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository; 

    @Autowired
    private PasswordEncoder passwordEncoder; 

    public void createAdminUser() {
       
        if (!userRepository.existsByUsername("admin")) {
          
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("adminPassword")); 
            userRepository.save(admin);
            System.out.println("Admin user created successfully!");
        } else {
            System.out.println("Admin user already exists.");
        }
    }

 
    public void createModeratorUser() {
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
            .orElseThrow(() -> new RuntimeException("User role not found"));

        Role moderatorRole = roleRepository.findByName(RoleName.ROLE_MODERATOR)
            .orElseThrow(() -> new RuntimeException("Moderator role not found"));

        User moderatorUser = new User();
        moderatorUser.setUsername("moderator");
        moderatorUser.setPassword(passwordEncoder.encode("moderator123")); 
        moderatorUser.getRoles().add(userRole);
        moderatorUser.getRoles().add(moderatorRole);

        userRepository.save(moderatorUser);

        System.out.println("Moderator user created successfully!");
    }
}
