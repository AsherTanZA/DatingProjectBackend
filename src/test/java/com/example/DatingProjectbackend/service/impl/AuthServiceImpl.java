package com.example.DatingProjectbackend.service.impl;
import com.example.DatingProjectbackend.entity.Role;
import com.example.DatingProjectbackend.entity.User;
import com.example.DatingProjectbackend.dto.RegisterDto;
import com.example.DatingProjectbackend.exception.APIException;
import com.example.DatingProjectbackend.repository.UserRepository;
import com.example.DatingProjectbackend.repository.RoleRepository;
import com.example.DatingProjectbackend.service.AuthService;
import lombok.AllArgsConstructor;
import  com.example.DatingProjectbackend.dto.LoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;


@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;


    @Override
    public String register(RegisterDto registerDto) {
        // check someone name already existed in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new APIException(HttpStatus.BAD_REQUEST, "Username already exists");
        }

        // check email is already in the database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new APIException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered Successfully.";


    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()

        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User logged-in successfully!.";
    }
}
