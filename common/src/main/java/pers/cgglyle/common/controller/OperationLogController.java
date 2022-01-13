package pers.cgglyle.common.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.cgglyle.common.model.query.OperationLogQuery;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.common.service.OperationLogService;

/**
 * 日志控制器
 *
 * @author cgglyle
 * @date 2021-12-14 11:31
 */
@Tag(name = "日志控制器")
@RestController
@RequestMapping("/log")
public class OperationLogController {

    private final OperationLogService operationLogService;

    public OperationLogController(OperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    @GetMapping("getLog")
    @Operation(summary = "获取log日志")
    public PageResult getLogPage(OperationLogQuery logQuery) {
        return operationLogService.get(logQuery);
    }
}
