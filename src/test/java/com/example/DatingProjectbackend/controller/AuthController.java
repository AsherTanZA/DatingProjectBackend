package com.example.DatingProjectbackend.controller;


import com.example.DatingProjectbackend.dto.LoginDto;
import com.example.DatingProjectbackend.dto.RegisterDto;
import com.example.DatingProjectbackend.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private AuthService authService;

  // Build Register Rest API
  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
      String response = authService.register(registerDto);
      return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String response = authService.login(loginDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
