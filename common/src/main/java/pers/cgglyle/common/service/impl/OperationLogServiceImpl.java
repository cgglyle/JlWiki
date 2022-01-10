package pers.cgglyle.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.mapper.OperationLogMapper;
import pers.cgglyle.common.model.entity.OperationLogEntity;
import pers.cgglyle.common.model.query.OperationLogQuery;
import pers.cgglyle.common.model.vo.OperationLogVo;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.common.service.OperationLogService;

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
            String requestParameter = log.getRequestParameter();
            if (jsonType(requestParameter)){
                operationLogVo.setRequestParameter(JSON.parseObject(log.getRequestParameter()));
            }
            operationLogVo.setRequestParameter(requestParameter);
            String returnResult = log.getReturnResult();
            if (jsonType(returnResult)){
                operationLogVo.setReturnResult(JSON.parseObject(log.getReturnResult()));
            }
            operationLogVo.setReturnResult(returnResult);
            return operationLogVo;
        }).collect(Collectors.toList());
        return new PageResult(operationLogQuery.getPageNum(), operationLogQuery.getPageSize(), data.getTotal(), data.getPages(), collect);
    }

    private boolean jsonType(String str){
        return str.startsWith("{") && str.endsWith("}");
    }
}
