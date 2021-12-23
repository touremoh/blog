package com.tourem.dao.entities;

import com.tourem.TouremObject;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public interface TouremEntity extends TouremObject {
    @PrePersist
    default void prePersist() {
        this.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    default void preUpdate() {
        this.setUpdatedAt(LocalDateTime.now());
    }
}
