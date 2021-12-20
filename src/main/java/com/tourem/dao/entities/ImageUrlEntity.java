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
@Table(name = "image_url")
public class ImageUrlEntity implements TouremEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "url")
    private String url;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
