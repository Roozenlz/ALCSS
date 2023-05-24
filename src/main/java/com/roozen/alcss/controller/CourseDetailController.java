package com.roozen.alcss.controller;

import com.roozen.alcss.service.ICourseDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * <p>
 * 课程详情表 前端控制器
 * </p>
 *
 * @author <a href="https://roozen.top">Roozen</a>
 * @since 2023-05-24
 * @version 1.0
 */
@Tag(name = "courseDetail")
@RestController
@RequestMapping("/courseDetail")
@RequiredArgsConstructor
public class CourseDetailController {
    private final ICourseDetailService ICourseDetailService;

}
