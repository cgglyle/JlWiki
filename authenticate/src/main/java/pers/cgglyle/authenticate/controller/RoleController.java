package pers.cgglyle.authenticate.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.common.annotaion.OperationLog;
import pers.cgglyle.common.base.controller.BaseController;
import pers.cgglyle.authenticate.model.dto.RoleAddDto;
import pers.cgglyle.authenticate.model.dto.RoleDeleteDto;
import pers.cgglyle.authenticate.model.dto.RolePermissionRelationAddDto;
import pers.cgglyle.authenticate.model.dto.RoleUpdateDto;
import pers.cgglyle.authenticate.model.query.RoleQuery;
import pers.cgglyle.authenticate.service.AccountService;

/**
 * 角色控制器
 *
 * @author cgglyle
 * @date 2021-12-08 13:11
 */
@Api(tags = "角色控制")
@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<AccountService, RoleQuery, RoleAddDto, RoleUpdateDto, RoleDeleteDto> {

    @ApiOperation("添加角色权限")
    @OperationLog(operationModule = "RolePermission", operationMethod = "POST")
    @PostMapping("addRolePermission")
    public boolean addRolePermission(@RequestBody RolePermissionRelationAddDto rolePermissionRelationDto) {
        return baseRelationService.add(rolePermissionRelationDto);
    }

}
