package com.yoona.sharding.sphere.jdbc.demo.mapper;

import com.yoona.sharding.sphere.jdbc.demo.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author yoonada
 * @since 2022-11-03 11:26:53
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
