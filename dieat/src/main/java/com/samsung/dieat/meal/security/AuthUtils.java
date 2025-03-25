package com.samsung.dieat.meal.security;//package com.samsung.dieat.meal.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//public class AuthUtils {
//
//    public static Integer getUserCode() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails details) {
//            return details.getUserCode();
//        }
//        return null;
//    }
//}