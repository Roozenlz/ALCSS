package com.roozen.alcss.controller;

import com.roozen.alcss.service.ICourseSchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * <p>
 * 排课信息表 前端控制器
 * </p>
 *
 * @author <a href="http://roozen.top">Roozen</a>
 * @since 2023-05-20
 * @version 1.0
 */
@Tag(name = "courseScheduling")
@RestController
@RequestMapping("/courseScheduling")
@RequiredArgsConstructor
public class CourseSchedulingController {
    private final ICourseSchedulingService ICourseSchedulingService;
}
