package com.tourem.dao.repositories;

import com.tourem.dao.entities.TouremEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface TouremRepository<E extends TouremEntity> extends JpaRepository<E, UUID>, JpaSpecificationExecutor<E> {
}
