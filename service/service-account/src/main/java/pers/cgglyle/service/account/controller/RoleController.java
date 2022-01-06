package pers.cgglyle.service.account.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.common.annotaion.RedisCache;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.log.annotaion.OperationLog;
import pers.cgglyle.service.account.model.dto.RoleAddDto;
import pers.cgglyle.service.account.model.dto.RoleDeleteDto;
import pers.cgglyle.service.account.model.dto.RolePermissionRelationAddDto;
import pers.cgglyle.service.account.model.dto.RoleUpdateDto;
import pers.cgglyle.service.account.model.query.RoleQuery;
import pers.cgglyle.service.account.service.AccountService;

import java.io.Serializable;
import java.util.List;

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
public class RoleController {

    @Autowired
    private AccountService accountService;

    @ApiOperation("获取分页")
    @GetMapping("getPage")
    @RedisCache
    public PageResult getPage(RoleQuery roleQuery) {
        return accountService.get(roleQuery);
    }

    @OperationLog(operationModule = "Role", operationMethod = "POST")
    @PostMapping("addRole")
    @ApiOperation("添加角色")
    public boolean addRole(@RequestBody RoleAddDto roleAddDto) {
        boolean b = accountService.add(roleAddDto);
        if (!b) {
            throw new ApiException("角色添加失败");
        }
        return true;
    }

    /**
     * 删除角色
     *
     * @param id 角色id
     * @return true
     */
    @OperationLog(operationMethod = "DELETE", operationModule = "Role")
    @DeleteMapping("deleteRole")
    @ApiOperation("删除角色")
    public boolean deleteRole(Serializable id) {
        boolean delete = accountService.delete(new RoleDeleteDto(id));
        if (!delete) {
            throw new ApiException("角色删除失败");
        }
        return true;
    }

    @OperationLog(operationModule = "Role", operationMethod = "PUT")
    @PutMapping("updateRole")
    @ApiOperation("更新角色")
    public boolean updateRole(@RequestBody RoleUpdateDto roleUpdateDto) {
        boolean b = accountService.update(roleUpdateDto);
        if (!b) {
            throw new ApiException("更新角色失败");
        }
        return true;
    }

    /**
     * 批量删除角色
     *
     * @param idList 角色id列表
     * @return true
     */
    @OperationLog(operationMethod = "DELETE", operationModule = "Role")
    @DeleteMapping("batchDeleteRole")
    @ApiOperation("批量删除角色")
    public boolean batchDeleteRole(List<Serializable> idList) {
        boolean b = accountService.batchDelete(new RoleDeleteDto(idList));
        if (!b) {
            throw new ApiException("批量删除失败");
        }
        return true;
    }

    @ApiOperation("添加角色权限")
    @OperationLog(operationModule = "RolePermission", operationMethod = "POST")
    @PostMapping("addRolePermission")
    public boolean addRolePermission(@RequestBody RolePermissionRelationAddDto rolePermissionRelationDto) {
        return accountService.add(rolePermissionRelationDto);
    }

}
