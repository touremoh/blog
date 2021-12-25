package com.tourem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AuthorDto implements TouremDto {
    private String id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
