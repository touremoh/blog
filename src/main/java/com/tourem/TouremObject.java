package com.tourem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Objects.nonNull;

public interface TouremObject extends Serializable {
    /**
     * Gets the ID of an entity
     * @return the ID of the entity
     */
    UUID getId();

    /**
     * Gets the date and time when the object was persisted in the db
     * @return object creation time
     */
    LocalDateTime getCreatedAt();

    /**
     * Sets the date and time when the object before persisted in the db
     */
    void setCreatedAt(LocalDateTime localDateTime);

    /**
     * Gets the date and time when the object was updated in the db
     * @return object update time
     */
    LocalDateTime getUpdatedAt();

    /**
     * Sets the date and time when the object was updated in the db
     */
    void setUpdatedAt(LocalDateTime localDateTime);

    /**
     * Gets the date and time when the object was deleted in the db
     * @return object deletion time
     */
    LocalDateTime getDeletedAt();

    /**
     * Tells if an object has its ID set or not
     * @return true or false
     */
    default boolean hasId() {
        return nonNull(this.getId());
    }
}
