package com.lwl.booking.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lwl.booking.entity.FlowingPO;
import com.lwl.booking.mapper.FlowingMapper;
import com.lwl.booking.pojo.req.AddSingleFlowReq;
import com.lwl.booking.pojo.req.CountByTimeReq;
import com.lwl.booking.pojo.vo.FlowVO;
import com.lwl.booking.service.FlowingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwl.common.constant.CommonConst;
import com.lwl.common.util.BeanConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
@Service
@Slf4j
public class FlowingServiceImpl extends ServiceImpl<FlowingMapper, FlowingPO> implements FlowingService {
    @Resource
    private FlowingMapper flowingMapper;

    @Override
    public void addSingleFlow(AddSingleFlowReq flowReq) {
        FlowingPO flowingPO = BeanConvertUtils.convert(flowReq, FlowingPO.class);
        flowingMapper.insert(flowingPO);
        log.info("成功记录用户:{}的一笔支出:{}", flowingPO.getUserId(), flowingPO);
    }

    @Override
    public BigDecimal countByTime(CountByTimeReq countByTimeReq) {
        List<FlowingPO> flows = flowingMapper.selectList(new LambdaQueryWrapper<FlowingPO>()
                .select(FlowingPO::getAmount)
                .eq(FlowingPO::getUserId, countByTimeReq.getUserId())
                .eq(FlowingPO::getStatusFlag, CommonConst.POSITIVE)
                .ge(FlowingPO::getFlowTime, countByTimeReq.getBeginTime())
                .le(FlowingPO::getFlowTime, countByTimeReq.getEndTime()));
        if (CollectionUtils.isEmpty(flows)) {
            return BigDecimal.ZERO;
        }
        return flows.stream().map(FlowingPO::getAmount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    @Override
    public List<FlowVO> listAll(Long userId) {
        List<FlowingPO> flows = flowingMapper.selectList(new LambdaQueryWrapper<FlowingPO>()
                .eq(FlowingPO::getUserId, userId)
                .eq(FlowingPO::getStatusFlag, CommonConst.POSITIVE)
                .orderByDesc(FlowingPO::getFlowTime));
        if (CollectionUtils.isEmpty(flows)) {
            return Collections.emptyList();
        }
        return BeanConvertUtils.convertList(flows, FlowVO.class);
    }
}
