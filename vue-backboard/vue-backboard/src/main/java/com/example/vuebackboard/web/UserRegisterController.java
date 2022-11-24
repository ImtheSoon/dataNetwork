//package com.example.vuebackboard.web;
//
//import com.example.vuebackboard.entity.UserEntity;
//import com.example.vuebackboard.model.Header;
//import com.example.vuebackboard.model.SearchCondition;
//import com.example.vuebackboard.services.UserService;
//
//import com.example.vuebackboard.util.JwtUtil;
//import com.example.vuebackboard.web.dtos.UserDto;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@RequiredArgsConstructor
//@CrossOrigin
//@RestController
//
//public class UserRegisterController {
//
//    private final JwtUtil jwtUtil;
//    private final UserService userService;
//    private final AuthenticationManager authenticationManager;
//
//    @PostMapping("/login")
//    public UserEntity userCreate(@RequestBody UserDto userDto) {
//        return userService.userCreate(userDto);
//    }
//}
