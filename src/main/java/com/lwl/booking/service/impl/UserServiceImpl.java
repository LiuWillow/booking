package com.lwl.booking.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lwl.booking.entity.UserPO;
import com.lwl.booking.mapper.UserMapper;
import com.lwl.booking.pojo.req.LoginReq;
import com.lwl.booking.pojo.req.RegisterReq;
import com.lwl.booking.pojo.vo.UserInfoVO;
import com.lwl.booking.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwl.common.constant.CommonConst;
import com.lwl.common.exception.GlobalException;
import com.lwl.common.util.BeanConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserInfoVO register(RegisterReq registerReq) {
        //这版先只做电话注册
        String mobilePhone = registerReq.getMobilePhone();
        UserPO existUser = this.getUserByMobile(mobilePhone);

        if (Objects.nonNull(existUser)) {
            return BeanConvertUtils.convert(existUser, UserInfoVO.class);
        }
        UserPO userPO = BeanConvertUtils.convert(registerReq, UserPO.class);
        userMapper.insert(userPO);
        log.info("用户:{}成功注册", userPO);
        return BeanConvertUtils.convert(userPO, UserInfoVO.class);
    }

    private UserPO getUserByMobile(String mobilePhone) {
        return userMapper.selectOne(new LambdaQueryWrapper<UserPO>()
                .eq(UserPO::getMobilePhone, mobilePhone)
                .eq(UserPO::getStatusFlag, CommonConst.POSITIVE)
                .last(CommonConst.LIMIT_ONE));
    }

    @Override
    public UserInfoVO login(LoginReq loginReq) {
        UserPO user = getUserByMobile(loginReq.getMobilePhone());
        if (Objects.isNull(user)) {
            throw new GlobalException(500, "没找到对应用户");
        }
        if (!Objects.equals(loginReq.getPasswordSecret(), user.getPasswordSecret())) {
            throw new GlobalException(500, "密码不正确");
        }
        return BeanConvertUtils.convert(user, UserInfoVO.class);
    }
}
