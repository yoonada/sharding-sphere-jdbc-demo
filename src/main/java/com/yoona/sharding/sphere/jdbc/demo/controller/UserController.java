package com.yoona.sharding.sphere.jdbc.demo.controller;


import com.yoona.sharding.sphere.jdbc.common.base.BaseResponse;
import com.yoona.sharding.sphere.jdbc.common.response.SystemResponse;
import com.yoona.sharding.sphere.jdbc.demo.domain.vo.UserVo;
import com.yoona.sharding.sphere.jdbc.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author yoonada
 * @since 2022-11-03 11:26:53
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/insert")
    public BaseResponse insert(@RequestBody UserVo vo){
        return userService.insert(vo);
    }

    @GetMapping("/queryList")
    public BaseResponse queryList(){
        return SystemResponse.success(userService.list());
    }


}
