package com.lwl.booking.util;

import com.lwl.booking.pojo.dto.UserInfoDTO;
import org.springframework.core.NamedThreadLocal;

import java.util.Optional;

/**
 * @author liuweilong
 * @date 2021/3/30
 * @description
 */
public class LoginUserInfoUtils {
    private LoginUserInfoUtils(){}

    private static NamedThreadLocal<UserInfoDTO> loginUserInfo = new NamedThreadLocal<>("loginUserInfo");

    public static void setCurrentUser(UserInfoDTO user) {
        loginUserInfo.set(user);
    }
    public static UserInfoDTO getCurrentUser() {
        return Optional.ofNullable(loginUserInfo.get()).orElse(null);
    }

    public static void clear() {
        loginUserInfo.remove();
    }
}