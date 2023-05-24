package com.roozen.alcss.service.impl;

import com.roozen.alcss.entity.UserRole;
import com.roozen.alcss.mapper.UserRoleMapper;
import com.roozen.alcss.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色对应关系表 服务实现类
 * </p>
 *
 * @author <a href="https://roozen.top">Roozen</a>
 * @since 2023-05-24
 * @version 1.0
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
