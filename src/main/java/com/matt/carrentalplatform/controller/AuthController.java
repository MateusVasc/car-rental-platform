package com.matt.carrentalplatform.controller;

import com.matt.carrentalplatform.dto.SignupRequest;
import com.matt.carrentalplatform.dto.UserDTO;
import com.matt.carrentalplatform.services.auth.AuthServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthServiceImpl authService;

  public AuthController(AuthServiceImpl authService) {
    this.authService = authService;
  }

  @PostMapping("/signup")
  public ResponseEntity<Object> signupCustumer(@RequestBody SignupRequest signupRequest) {
    if (this.authService.usedEmail(signupRequest.getEmail())) {
      return new ResponseEntity<>("The provided email is already being used.",
          HttpStatus.NOT_ACCEPTABLE);
    }

    UserDTO createdCustumer = authService.createCustumer(signupRequest);

    if (createdCustumer == null) {
      return new ResponseEntity<>("Unable to register costumer. Please try again later.",
          HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity<>(createdCustumer, HttpStatus.CREATED);
  }
}
