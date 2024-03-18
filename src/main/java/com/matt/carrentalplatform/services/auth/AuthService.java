package com.matt.carrentalplatform.services.auth;

import com.matt.carrentalplatform.dto.SignupRequest;
import com.matt.carrentalplatform.dto.UserDTO;

public interface AuthService {

  UserDTO createCustumer(SignupRequest signupRequest);
  boolean usedEmail(String email);
}
