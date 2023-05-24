package com.roozen.alcss.controller;

import com.roozen.alcss.entity.User;
import com.roozen.alcss.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author <a href="http://roozen.top">Roozen</a>
 * @since 2023-05-20
 * @version 1.0
 */
@Tag(name = "user")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService IUserService;

    @Operation(summary = "查询所有用户")
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(IUserService.list());
    }
}
