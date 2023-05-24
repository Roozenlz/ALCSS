package com.roozen.alcss.service.impl;

import com.roozen.alcss.entity.Role;
import com.roozen.alcss.mapper.RoleMapper;
import com.roozen.alcss.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author <a href="https://roozen.top">Roozen</a>
 * @since 2023-05-24
 * @version 1.0
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
