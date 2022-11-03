package com.yoona.sharding.sphere.jdbc.demo.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yoona.sharding.sphere.jdbc.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author yoonada
 * @since 2022-11-03 11:26:53
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value = "User对象", description = "系统用户表")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("电子邮箱")
    private String email;

}
