package com.yoona.sharding.sphere.jdbc.demo.service;

import com.yoona.sharding.sphere.jdbc.common.base.BaseResponse;
import com.yoona.sharding.sphere.jdbc.demo.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yoona.sharding.sphere.jdbc.demo.domain.vo.UserVo;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author yoonada
 * @since 2022-11-03 11:26:53
 */
public interface UserService extends IService<User> {

    /**
     * 插入
     * @param vo
     * @return
     */
    BaseResponse insert(UserVo vo);
}
