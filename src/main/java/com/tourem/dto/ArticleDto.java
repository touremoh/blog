package com.tourem.dto;

import com.google.common.base.Strings;
import com.tourem.dao.entities.AuthorEntity;
import com.tourem.dao.entities.TouremEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
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

    /**
     * Tells if the ID of the entity is sets or not
     * @return true of false
     */
    @Override
    public boolean hasId() {
        return !Strings.isNullOrEmpty(id);
    }
}
