package com.samsung.dieat.bookmark_category.command.application.service;

import com.samsung.dieat.bookmark_category.command.application.dto.bookMarkCategoryDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface bookMarkCategoryService extends UserDetailsService {
    void registCategory(bookMarkCategoryDTO bookMarkCateogry);

}
