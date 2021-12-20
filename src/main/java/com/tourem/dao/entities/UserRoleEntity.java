package com.tourem.dao.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "user_role")
public class UserRoleEntity implements TouremEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
