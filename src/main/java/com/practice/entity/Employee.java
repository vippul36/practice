package com.practice.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Employee {
    private Long id;
    private String name;
    private String email;
    private String password;
}
