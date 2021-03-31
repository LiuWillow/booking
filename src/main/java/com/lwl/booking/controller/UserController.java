package com.lwl.booking.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.lwl.booking.pojo.req.LoginReq;
import com.lwl.booking.pojo.req.RegisterReq;
import com.lwl.booking.service.UserService;
import com.lwl.booking.util.LoginUserInfoUtils;
import com.lwl.booking.pojo.dto.UserInfoDTO;
import com.lwl.booking.pojo.vo.UserInfoVO;
import com.lwl.common.context.BaseResponse;
import com.lwl.common.util.BeanConvertUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public BaseResponse<UserInfoVO> login(@RequestBody @Validated LoginReq loginReq, HttpServletRequest request) {
        UserInfoVO userInfoVO = userService.login(loginReq);
        HttpSession session = request.getSession();
        UserInfoDTO convert = BeanConvertUtils.convert(userInfoVO, UserInfoDTO.class);
        session.setAttribute("userInfo", JSONUtils.toJSONString(convert));
        return BaseResponse.success(userInfoVO);
    }

    @PostMapping("/register")
    public BaseResponse<UserInfoVO> register(@RequestBody @Validated RegisterReq registerReq) {
        UserInfoVO userInfoVO = userService.register(registerReq);
        return BaseResponse.success(userInfoVO);
    }

    @GetMapping("/info")
    public BaseResponse<UserInfoVO> getLoginUserInfo() {
        UserInfoDTO currentUser = LoginUserInfoUtils.getCurrentUser();
        return BaseResponse.success(BeanConvertUtils.convert(currentUser, UserInfoVO.class));
    }
}