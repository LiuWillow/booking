package com.lwl.booking.controller;


import com.lwl.common.context.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("list-all")
    public BaseResponse<?> listAll() {
        //TODO 获取所有分类
        return BaseResponse.success();
    }
}
