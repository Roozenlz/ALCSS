package com.roozen.alcss.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roozen.alcss.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author <a href="http://roozen.top">Roozen</a>
 * @since 2023-05-20
 * @version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select name,passwd from user where name = #{username}")
    Optional<User> selectByName(String username);
}
