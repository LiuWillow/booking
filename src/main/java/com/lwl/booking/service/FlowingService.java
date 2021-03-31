package com.lwl.booking.service;

import com.lwl.booking.entity.FlowingPO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lwl.booking.pojo.req.AddSingleFlowReq;
import com.lwl.booking.pojo.req.CountByTimeReq;
import com.lwl.booking.pojo.vo.FlowVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
public interface FlowingService extends IService<FlowingPO> {
    /**
     * 记录一笔支出
     * @param flowReq
     */
    void addSingleFlow(AddSingleFlowReq flowReq);

    /**
     * 根据时间范围获取用户的支出
     * @param countByTimeReq
     * @return
     */
    BigDecimal countByTime(CountByTimeReq countByTimeReq);

    /**
     * 获取某个用户所有的flow
     * @param userId
     * @return
     */
    List<FlowVO> listAll(Long userId);
}
