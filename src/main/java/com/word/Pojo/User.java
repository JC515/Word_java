package com.word.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String password;
    private Timestamp created;
    private Timestamp updated;
    private int age;
    private String username;
    private String email;
    private Integer gender;
}
