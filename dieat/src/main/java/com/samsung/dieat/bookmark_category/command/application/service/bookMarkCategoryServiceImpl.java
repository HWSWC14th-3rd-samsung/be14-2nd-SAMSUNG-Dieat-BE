package com.samsung.dieat.bookmark_category.command.application.service;

import com.samsung.dieat.bookmark_category.command.application.dto.bookMarkCategoryDTO;
import com.samsung.dieat.bookmark_category.command.application.entity.bookMarkCategoryEntity;
import com.samsung.dieat.bookmark_category.command.domain.repository.bookMarkCategoryRepository;
import com.samsung.dieat.member.command.domain.aggregate.entity.UserEntity;
import com.samsung.dieat.member.command.domain.repository.UserRepository;
import com.samsung.dieat.security.CustomUserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class bookMarkCategoryServiceImpl implements bookMarkCategoryService {

    UserRepository userRepository;
    ModelMapper modelMapper;
    bookMarkCategoryRepository bookMarkCategoryRepository;

    @Autowired
    public bookMarkCategoryServiceImpl(UserRepository userRepository, ModelMapper modelMapper, bookMarkCategoryRepository bookMarkCategoryRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bookMarkCategoryRepository = bookMarkCategoryRepository;
    }


    @Override
    public void registCategory(bookMarkCategoryDTO bookMarkCateogry) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity user = userRepository.findByUserId(username);
        bookMarkCateogry.setUserCode(user.getUserCode());
        bookMarkCategoryEntity registCategory = modelMapper.map(bookMarkCateogry, bookMarkCategoryEntity.class);

        bookMarkCategoryRepository.save(registCategory);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity loginUser = userRepository.findByUserId(username);

        if(loginUser == null) {
            throw new UsernameNotFoundException(username + "아이디가 존재하지 않습니다.");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if("ADMIN".equals(loginUser.getUserRole())) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new CustomUserDetails(
                loginUser.getUserId(),
                loginUser.getUserPwd(),
                loginUser.getUserCode(),
                loginUser.getUserRole(),
                grantedAuthorities
        );
    }
}
