package com.matt.carrentalplatform.dto;

import com.matt.carrentalplatform.enums.UserRole;
import java.util.UUID;

public record UserDTO(UUID id, String name, String email, UserRole role) {

}
