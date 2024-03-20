package com.matt.carrentalplatform.services.auth;

import com.matt.carrentalplatform.dto.SignupRequest;
import com.matt.carrentalplatform.dto.UserDTO;
import com.matt.carrentalplatform.entity.User;
import com.matt.carrentalplatform.enums.UserRole;
import com.matt.carrentalplatform.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  private final UserRepository userRepository;

  public AuthServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDTO createCustumer(SignupRequest signupRequest) {
    User user = new User(signupRequest.getName(), signupRequest.getEmail(),
        signupRequest.getPassword(), UserRole.COSTUMER);

    User createdUser = this.userRepository.save(user);

    return new UserDTO(createdUser.getId(), createdUser.getName(), createdUser.getEmail(),
        createdUser.getRole());
  }

  @Override
  public boolean usedEmail(String email) {
    return this.userRepository.findByEmail(email).isPresent();
  }

  @Override
  public boolean verifiedName(String name) {
    if (name == null || name.length() <= 3) {
      return false;
    }

    return true;
  }

  @Override
  public boolean verifiedEmail(String email) {
    if (email == null || email.length() < 10) {
      return false;
    }

    return true;
  }

  @Override
  public boolean verifiedPassword(String password) {
    if (password == null || password.length() <= 4 || password.length() > 15) {
      return false;
    }

    if (!(containsDigit(password) && containsUpperCase(password))) {
      return false;
    }

    return true;
  }

  public boolean containsDigit(String password) {
    for (char c : password.toCharArray()) {
      if (Character.isDigit(c)) {
        return true;
      }
    }

    return false;
  }

  public boolean containsUpperCase(String password) {
    for (char c : password.toCharArray()) {
      if (Character.isUpperCase(c)) {
        return true;
      }
    }

    return false;
  }

  public boolean verifiedFields(String name, String email, String password) {
    return verifiedName(name) && verifiedEmail(email) && verifiedPassword(password);
  }
}
