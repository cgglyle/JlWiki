package pers.cgglyle.log.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.log.mapper.OperationLogMapper;
import pers.cgglyle.log.model.entity.OperationLogEntity;
import pers.cgglyle.log.model.query.OperationLogQuery;
import pers.cgglyle.log.model.vo.OperationLogVo;
import pers.cgglyle.log.service.OperationLogService;
import pers.cgglyle.response.PageResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 操作日志表(OperationLog)表服务实现类
 *
 * @author cgglyle
 * @since 2021-12-14 10:59:28
 */
@Service("operationLogService")
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLogEntity> implements OperationLogService {

    @Override
    public PageResult getPage(OperationLogQuery operationLogQuery) {
        QueryWrapper<OperationLogEntity> queryWrapper = new QueryWrapper<>();
        if (operationLogQuery.getOperationModule() != null) {
            queryWrapper.like("operation_module", operationLogQuery.getOperationModule());
        }
        if (operationLogQuery.getCreateTime() != null) {
            queryWrapper.like("create_time", operationLogQuery.getCreateTime());
        }
        if (operationLogQuery.getUserName() != null) {
            queryWrapper.like("user_name", operationLogQuery.getUserName());
        }
        if (operationLogQuery.getRequestAddress() != null) {
            queryWrapper.like("request_address", operationLogQuery.getRequestAddress());
        }
        Page<OperationLogEntity> page = new Page<>(operationLogQuery.getPageNum(), operationLogQuery.getPageSize());
        Page<OperationLogEntity> data = baseMapper.selectPage(page, queryWrapper);
        List<OperationLogVo> collect = data.getRecords().stream().map(log -> {
            OperationLogVo operationLogVo = new OperationLogVo();
            BeanUtils.copyProperties(log, operationLogVo);
            operationLogVo.setRequestParameter(JSON.parseObject(log.getRequestParameter()));
            operationLogVo.setReturnResult(JSON.parseObject(log.getReturnResult()));
            return operationLogVo;
        }).collect(Collectors.toList());
        return new PageResult(operationLogQuery.getPageNum(), operationLogQuery.getPageSize(), data.getTotal(), data.getPages(), collect);
    }
}
