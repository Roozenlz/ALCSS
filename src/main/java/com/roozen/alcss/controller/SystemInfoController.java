package com.roozen.alcss.controller;

import com.roozen.alcss.service.ISystemInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * <p>
 * 系统信息表 前端控制器
 * </p>
 *
 * @author <a href="https://roozen.top">Roozen</a>
 * @since 2023-05-24
 * @version 1.0
 */
@Tag(name = "systemInfo")
@RestController
@RequestMapping("/systemInfo")
@RequiredArgsConstructor
public class SystemInfoController {
    private final ISystemInfoService ISystemInfoService;

}
