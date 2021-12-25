package com.tourem.dao.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "user_operation", schema = "tourem")
public class UserOperationEntity implements TouremEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private String id;

    @Column(name = "operation_name")
    private String operationName;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRoleEntity userRole;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
