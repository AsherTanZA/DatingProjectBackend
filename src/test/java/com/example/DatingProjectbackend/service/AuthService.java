package com.example.DatingProjectbackend.service;

import com.example.DatingProjectbackend.dto.LoginDto;
import com.example.DatingProjectbackend.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);

}
