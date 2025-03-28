package com.samsung.dieat.bookmark_category.command.domain.repository;

import com.samsung.dieat.bookmark_category.command.application.entity.bookMarkCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookMarkCategoryRepository extends JpaRepository<bookMarkCategoryEntity, Long> {
}
