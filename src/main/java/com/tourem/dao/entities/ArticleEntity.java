package com.tourem.dao.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.sql.Clob;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "article", schema = "tourem")
public class ArticleEntity implements TouremEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private String id;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "payload")
    private Clob payload;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
