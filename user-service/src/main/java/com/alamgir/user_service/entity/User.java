package com.alamgir.user_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email can't be empty")
    @NotNull(message = "Email Can't be Null")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Name can't be empty")
    @NotNull(message = "Name can't be null ")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Password can't be empty")
    @NotNull(message = "Password can't be null ")
    @Column(nullable = false)
    private String password;

    public Long getId() {return id;}
    public void setId(Long id) {   this.id = id;    }
    public String getEmail() {   return email;  }
    public void setEmail(String email) { this.email = email;  }
    public String getName() {   return name;  }
    public void setName(String name) {  this.name = name;  }
    public String getPassword() { return password;   }
    public void setPassword(String password) {    this.password = password;  }

}
