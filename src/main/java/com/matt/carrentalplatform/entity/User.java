package com.matt.carrentalplatform.entity;

import com.matt.carrentalplatform.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "user_id")
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Email
  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private UserRole role;

  public User(String name, String email, String password, UserRole role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
  }
}
