package com.lwl.booking.filter;

import com.alibaba.fastjson.JSONObject;
import com.lwl.booking.common.ServiceConst;
import com.lwl.booking.pojo.dto.UserInfoDTO;
import com.lwl.booking.util.LoginUserInfoUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author liuweilong
 * @date 2021/3/31
 * @description
 */
@Component
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String json = (String) session.getAttribute(ServiceConst.LOGIN_INFO_KEY);
        if (!StringUtils.isEmpty(json)) {
            LoginUserInfoUtils.setCurrentUser(JSONObject.parseObject(json, UserInfoDTO.class));
        }

        try {
            super.doFilter(request, response, chain);
        } finally {
            LoginUserInfoUtils.clear();
        }
    }
}
