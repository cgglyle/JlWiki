package pers.cgglyle.service.acconut.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.log.annotaion.OperationLog;
import pers.cgglyle.service.acconut.model.dto.PermissionAddDto;
import pers.cgglyle.service.acconut.model.query.PermissionQuery;
import pers.cgglyle.service.acconut.service.AccountService;

/**
 * @author cgglyle
 * @date 2021-12-29 14:36
 */
@Api(tags = "权限控制")
@CrossOrigin
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private AccountService accountService;

    @OperationLog(operationMethod = "POST", operationModule = "Permission")
    @ApiOperation("添加权限")
    @PostMapping("add")
    public boolean addPermission(@RequestBody PermissionAddDto permissionAddDto) {
        return accountService.add(permissionAddDto);
    }

    @ApiOperation("查询分页")
    @GetMapping("get")
    public PageResult get(PermissionQuery permissionQuery) {
        return accountService.get(permissionQuery);
    }
}
