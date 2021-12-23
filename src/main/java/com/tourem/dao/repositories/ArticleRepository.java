package com.tourem.dao.repositories;

import com.tourem.dao.entities.ArticleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends TouremRepository<ArticleEntity> {
}
