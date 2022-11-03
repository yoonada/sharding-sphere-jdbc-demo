package com.yoona.sharding.sphere.jdbc.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.yoona.sharding.sphere.jdbc.common.base.BaseResponse;
import com.yoona.sharding.sphere.jdbc.common.response.SystemResponse;
import com.yoona.sharding.sphere.jdbc.demo.domain.entity.User;
import com.yoona.sharding.sphere.jdbc.demo.domain.vo.UserVo;
import com.yoona.sharding.sphere.jdbc.demo.mapper.UserMapper;
import com.yoona.sharding.sphere.jdbc.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author yoonada
 * @since 2022-11-03 11:26:53
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public BaseResponse insert(UserVo vo) {
        User user = BeanUtil.copyProperties(vo, User.class);
        boolean save = save(user);
        if (save){
            return SystemResponse.success("插入成功");
        }
        return SystemResponse.fail("插入失败");
    }
}
