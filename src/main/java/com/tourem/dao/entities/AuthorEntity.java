package com.tourem.dao.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "author")
public class AuthorEntity implements TouremEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
