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

    User createdUser = userRepository.save(user);

    return new UserDTO(createdUser.getId(), createdUser.getName(), createdUser.getEmail(),
        createdUser.getRole());
  }
}
