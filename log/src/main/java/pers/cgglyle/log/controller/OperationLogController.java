package pers.cgglyle.log.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.log.model.query.OperationLogQuery;
import pers.cgglyle.log.service.OperationLogService;

/**
 * 日志控制器
 *
 * @author cgglyle
 * @date 2021-12-14 11:31
 */
@Api(tags = "日志控制器")
@RestController
@RequestMapping("/log")
public class OperationLogController {

    private final OperationLogService operationLogService;

    public OperationLogController(OperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    @GetMapping("getLog")
    @ApiOperation("获取log日志")
    public PageResult getLogPage(OperationLogQuery operationLogQuery) {
        return operationLogService.getPage(operationLogQuery);
    }
}
