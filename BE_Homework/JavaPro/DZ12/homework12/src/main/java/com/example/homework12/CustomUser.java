package com.example.homework12;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor
public class CustomUser {
    @Id
    @GeneratedValue
    private Long id;

    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String email;
    private String phone;
    private String address;

    private String photo;

    public CustomUser(String login, String password, UserRole role,
                      String email, String phone, String address, String photo) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.photo = photo;
    }
}
