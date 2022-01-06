package pers.cgglyle.service.account.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.log.annotaion.OperationLog;
import pers.cgglyle.service.account.model.dto.PermissionAddDto;
import pers.cgglyle.service.account.model.query.PermissionQuery;
import pers.cgglyle.service.account.service.AccountService;

/**
 * @author cgglyle
 * @date 2021-12-29 14:36
 */
@Api(tags = "权限控制")
@CrossOrigin
@RestController
@RequestMapping("/permission")
public class PermissionController {

    private final AccountService accountService;

    public PermissionController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 添加一个权限
     *
     * @param permissionAddDto 权限添加请求
     * @return 成功失败
     */
    @OperationLog(operationMethod = "POST", operationModule = "Permission")
    @ApiOperation("添加权限")
    @PostMapping("add")
    public boolean addPermission(@RequestBody PermissionAddDto permissionAddDto) {
        return accountService.add(permissionAddDto);
    }

    /**
     * 查询用权限信息
     *
     * @param permissionQuery 权限查看请求
     * @return 分页列表
     */
    @ApiOperation("查询分页")
    @GetMapping("get")
    public PageResult get(PermissionQuery permissionQuery) {
        return accountService.get(permissionQuery);
    }
}
