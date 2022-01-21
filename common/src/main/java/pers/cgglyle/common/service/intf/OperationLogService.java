package pers.cgglyle.common.service.intf;

import pers.cgglyle.common.model.entity.OperationLogEntity;
import pers.cgglyle.common.model.query.OperationLogQuery;
import pers.cgglyle.common.response.PageResult;

/**
 * 操作日志表(OperationLog)表服务接口
 *
 * @author cgglyle
 * @since 2021-12-14 10:59:28
 */
public interface OperationLogService {

    /**
     * 获取日志
     *
     * @return 日志列表
     */
    PageResult get(OperationLogQuery query);

    void add(OperationLogEntity operationLogEntity);
}
