package com.lwl.booking.controller;


import com.lwl.booking.pojo.req.AddSingleFlowReq;
import com.lwl.booking.pojo.req.CountByTimeReq;
import com.lwl.booking.pojo.vo.FlowVO;
import com.lwl.booking.service.FlowingService;
import com.lwl.booking.util.LoginUserInfoUtils;
import com.lwl.common.context.BaseResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

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
    @Resource
    private FlowingService flowingService;

    @PostMapping("/single")
    public BaseResponse<Void> addSingleFlow(@RequestBody @Validated AddSingleFlowReq flowReq) {
        //记录一笔支出
        Long loginUserId = LoginUserInfoUtils.getUserId();
        flowReq.setUserId(loginUserId);
        flowingService.addSingleFlow(flowReq);
        return BaseResponse.success();
    }

    @GetMapping("/count-by-time")
    public BaseResponse<BigDecimal> countByTime(CountByTimeReq countByTimeReq) {
        countByTimeReq.setUserId(LoginUserInfoUtils.getUserId());
        BigDecimal amount = flowingService.countByTime(countByTimeReq);
        return BaseResponse.success(amount);
    }

    @GetMapping("/list-all")
    public BaseResponse<List<FlowVO>> listAll() {
        //获取所有的支出，让前端缓存到本地
        List<FlowVO> list = flowingService.listAll(LoginUserInfoUtils.getUserId());
        return BaseResponse.success(list);
    }
}
