package com.tourem.dto;

import com.google.common.base.Strings;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserOperationDto implements TouremDto {
    private String id;
    private String url;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    /**
     * Tells if the ID of the entity is sets or not
     *
     * @return true of false
     */
    @Override
    public boolean hasId() {
        return !Strings.isNullOrEmpty(id);
    }
}
