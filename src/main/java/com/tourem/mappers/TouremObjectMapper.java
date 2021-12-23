package com.tourem.mappers;

import com.tourem.dao.entities.TouremEntity;
import com.tourem.dto.TouremDto;

import java.io.Serializable;

public interface TouremObjectMapper<E extends TouremEntity, D extends TouremDto> extends Serializable {
    /**
     * Maps a DTO to an entity
     * @param source mapping source
     * @return the entity corresponding to the dto
     */
    E mapToEntity(D source);

    /**
     * Maps an Entity to a DTO
     * @param source mapping source
     * @return the dto corresponding to the entity
     */
    D mapToDto(E source);
}
