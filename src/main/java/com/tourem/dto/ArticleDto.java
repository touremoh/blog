package com.tourem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ArticleDto implements TouremDto {
    private String id;
    private String title;
    private String payload;
    private AuthorDto author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
