package com.tourem.dao.repositories;

import com.tourem.dao.entities.AuthorEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends TouremRepository<AuthorEntity> {
}
