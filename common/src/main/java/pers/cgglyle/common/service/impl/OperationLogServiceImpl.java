package pers.cgglyle.common.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.model.entity.OperationLogEntity;
import pers.cgglyle.common.model.query.OperationLogQuery;
import pers.cgglyle.common.model.vo.OperationLogVo;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.common.service.intf.OperationLogService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 操作日志表(OperationLog)表服务实现类
 *
 * @author cgglyle
 * @since 2021-12-14 10:59:28
 */
@Service("operationLogService")
public class OperationLogServiceImpl implements OperationLogService {
    private final static String LOG_COLLECTION = "operation_log";
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public PageResult get(OperationLogQuery query) {
        // 分页条件
        PageRequest pageRequest = PageRequest.of(query.getPageNum() - 1, query.getPageSize());
        // 请求条件
        Query tempQuery = new Query();
        // 查询符合条件的条目数
        long count = mongoTemplate.count(tempQuery, OperationLogEntity.class, LOG_COLLECTION);
        // 分页条件放入请求
        tempQuery.with(pageRequest);
        // 查出日志体
        List<OperationLogEntity> operationLogEntities = mongoTemplate.find(tempQuery, OperationLogEntity.class, LOG_COLLECTION);
        Page<?> page = PageableExecutionUtils.getPage(operationLogEntities, pageRequest, () -> count);
        // 封装显示
        List<OperationLogVo> collect = page.getContent().stream().map(o -> {
            OperationLogVo operationLogVo = new OperationLogVo();
            BeanUtils.copyProperties(o, operationLogVo);
            return operationLogVo;
        }).collect(Collectors.toList());
        return new PageResult(query.getPageNum(), query.getPageSize(), page.getTotalElements(), page.getTotalPages(), collect);
    }

    @Override
    public void add(OperationLogEntity operationLogEntity) {
        mongoTemplate.save(operationLogEntity, LOG_COLLECTION);
    }
}
