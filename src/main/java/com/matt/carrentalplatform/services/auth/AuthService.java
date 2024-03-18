package com.matt.carrentalplatform.services.auth;

import com.matt.carrentalplatform.dto.SignupRequest;
import com.matt.carrentalplatform.dto.UserDTO;

public interface AuthService {

  UserDTO createCustumer(SignupRequest signupRequest);
  boolean usedEmail(String email);
  boolean verifiedName(String name);
  boolean verifiedEmail(String email);
  boolean verifiedPassword(String password);
}
