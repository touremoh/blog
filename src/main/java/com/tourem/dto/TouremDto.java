package com.tourem.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface TouremDto extends Serializable {
    /**
     * Gets the ID of an entity
     * @return the ID of the entity
     */
    String getId();

    /**
     * Tells if the ID of the entity is sets or not
     * @return true of false
     */
    boolean hasId();

    /**
     * Gets the date and time when the object was persisted in the db
     * @return object creation time
     */
    LocalDateTime getCreatedAt();

    /**
     * Gets the date and time when the object was updated in the db
     * @return object update time
     */
    LocalDateTime getUpdatedAt();

    /**
     * Gets the date and time when the object was deleted in the db
     * @return object deletion time
     */
    LocalDateTime getDeletedAt();
}
