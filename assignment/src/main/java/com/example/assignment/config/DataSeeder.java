package com.example.assignment.config;

import com.example.assignment.models.Role;
import com.example.assignment.models.RoleName;
import com.example.assignment.services.UserService;
import com.example.assignment.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initializeData(RoleRepository roleRepository, UserService userService) {
        return args -> {
         
            if (roleRepository.findByName(RoleName.ROLE_ADMIN).isEmpty()) {
                Role adminRole = new Role();
                adminRole.setName(RoleName.ROLE_ADMIN);
                roleRepository.save(adminRole);
            }

            if (roleRepository.findByName(RoleName.ROLE_USER).isEmpty()) {
                Role userRole = new Role();
                userRole.setName(RoleName.ROLE_USER);
                roleRepository.save(userRole);
            }

            if (roleRepository.findByName(RoleName.ROLE_MODERATOR).isEmpty()) {
                Role moderatorRole = new Role();
                moderatorRole.setName(RoleName.ROLE_MODERATOR);
                roleRepository.save(moderatorRole);
            }

            System.out.println("Roles seeded successfully!");

           
            userService.createAdminUser(); 
            userService.createModeratorUser();

            System.out.println("Users created successfully!");
        };
    }
}
