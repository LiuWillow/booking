package com.lwl.booking.controller;


import com.lwl.common.context.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/flowing")
public class FlowingController {
    @PostMapping("/single")
    public BaseResponse<Void> addSingleFlow() {
        //TODO 记录一笔支出
        return BaseResponse.success();
    }

    @GetMapping("/count-by-time")
    public BaseResponse<BigDecimal> countByTime() {
        //TODO 获取一段时间内的总支出
        return BaseResponse.success();
    }

    @GetMapping("/list-all")
    public BaseResponse<?> listAll() {
        //TODO 获取所有的支出，让前端缓存到本地
        return BaseResponse.success();
    }
}
