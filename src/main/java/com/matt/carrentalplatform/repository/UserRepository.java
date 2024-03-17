package com.matt.carrentalplatform.repository;

import com.matt.carrentalplatform.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

}
