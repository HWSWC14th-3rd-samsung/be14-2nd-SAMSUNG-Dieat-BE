package com.samsung.dieat.bookmark_category.command.application.controller;

import com.samsung.dieat.bookmark_category.command.application.dto.bookMarkCategoryDTO;
import com.samsung.dieat.bookmark_category.command.application.service.bookMarkCategoryService;
import com.samsung.dieat.bookmark_category.command.domain.aggregate.vo.ResponseRegistCategoryVO;
import com.samsung.dieat.bookmark_category.command.domain.aggregate.vo.requestRegistCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookmark/category")
public class BookmarkCategoryController {

    private ModelMapper modelMapper;
    private bookMarkCategoryService bookMarkCategoryService;

    @Autowired
    public BookmarkCategoryController(ModelMapper modelMapper, bookMarkCategoryService bookMarkCategoryService) {
        this.modelMapper = modelMapper;
        this.bookMarkCategoryService = bookMarkCategoryService;
    }

    @PostMapping("/regist")
    public ResponseEntity<ResponseRegistCategoryVO> registCategory(@RequestBody requestRegistCategory newCategory) {
        bookMarkCategoryDTO bookMarkCategory =modelMapper.map(newCategory, bookMarkCategoryDTO.class);

        bookMarkCategoryService.registCategory(bookMarkCategory);
        ResponseRegistCategoryVO successRegistCategory = modelMapper.map(bookMarkCategory, ResponseRegistCategoryVO.class);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(successRegistCategory);

    }
}
