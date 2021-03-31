package com.lwl.booking.service;

import com.lwl.booking.entity.UserPO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lwl.booking.pojo.req.LoginReq;
import com.lwl.booking.pojo.req.RegisterReq;
import com.lwl.booking.pojo.vo.UserInfoVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
public interface UserService extends IService<UserPO> {

    /**
     * 注册
     * @param registerReq
     */
    UserInfoVO register(RegisterReq registerReq);

    /**
     * 登录
     * @param loginReq
     * @return
     */
    UserInfoVO login(LoginReq loginReq);
}
