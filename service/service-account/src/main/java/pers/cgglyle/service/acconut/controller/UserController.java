package pers.cgglyle.service.acconut.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.common.annotaion.RedisCache;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.log.annotaion.OperationLog;
import pers.cgglyle.service.acconut.model.dto.*;
import pers.cgglyle.service.acconut.model.query.UserQuery;
import pers.cgglyle.service.acconut.service.AccountService;

import java.io.Serializable;
import java.util.List;

/**
 * 用户控制器
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Api(tags = "用户控制")
@CrossOrigin
@RequestMapping("/user")
@RestController
public class UserController {
    private final AccountService accountService;

    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("getPage")
    @ApiOperation("获取用户分页信息")
    @RedisCache()
    public PageResult getPage(UserQuery userQuery) {
        return accountService.get(userQuery);
    }

    @OperationLog(operationModule = "User", operationMethod = "POST")
    @PostMapping("addUser")
    @ApiOperation("添加用户")
    public boolean addUser(@RequestBody UserAddDto userAddDto) {
        boolean b = accountService.add(userAddDto);
        if (!b) {
            throw new ApiException("用户添加失败");
        }
        return true;
    }

    /**
     * 删除用户
     * <p>
     * 删除用户也会删除该用户的所有角色
     * <p>
     * 以及用户组内的用户
     *
     * @param id 用户id
     * @return ture
     */
    @OperationLog(operationMethod = "DELETE", operationModule = "User")
    @DeleteMapping("deleteUser/{id}")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "用户id")
    public boolean deleteUser(@PathVariable Serializable id) {
        boolean delete = accountService.delete(new UserDeleteDto(id));
        if (!delete) {
            throw new ApiException("用户删除失败");
        }
        return true;
    }

    @OperationLog(operationModule = "User", operationMethod = "PUT")
    @PutMapping("updateUser")
    @ApiOperation("更新用户")
    public boolean updateUser(@RequestBody UserUpdateDto userUpdateDto) {
        boolean b = accountService.update(userUpdateDto);
        if (!b) {
            throw new ApiException("更新用户失败");
        }
        return true;
    }

    @OperationLog(operationMethod = "DELETE", operationModule = "User")
    @DeleteMapping("batchDeleteUser")
    @ApiOperation("批量删除用户")
    public boolean batchDeleteUser(@RequestBody List<Serializable> idList) {
        boolean b = accountService.batchDelete(new UserDeleteDto(idList));
        if (!b) {
            throw new ApiException("批量删除失败");
        }
        return true;
    }

    @OperationLog(operationModule = "UserRole", operationMethod = "POST")
    @PostMapping("addUserRole")
    @ApiOperation("给用户添加角色")
    public boolean addUserRole(@RequestBody UserRoleRelationAddDto userRoleRelationAddDto) {
        boolean b = accountService.add(userRoleRelationAddDto);
        if (!b) {
            throw new ApiException("添加角色失败");
        }
        return true;
    }

    /**
     * 删除用户的角色API
     *
     * @param id 用户 UserRoleVo 的 id
     * @return true
     */
    @OperationLog(operationMethod = "DELETE", operationModule = "UserRole")
    @DeleteMapping("deleteUserRole/{id}")
    @ApiOperation("删除用户角色")
    @ApiImplicitParam(name = "id", value = "用户 UserRoleVo 的 id")
    public boolean deleteUserRole(@PathVariable Serializable id) {
        boolean delete = accountService.delete(new UserRoleRelationDeleteDto(id));
        if (!delete) {
            throw new ApiException("角色删除失败");
        }
        return true;
    }

    @OperationLog(operationModule = "UserGroup", operationMethod = "POST")
    @PostMapping("addUserGroup")
    @ApiOperation("给用户添加用户组")
    public boolean addUserGroup(@RequestBody UserGroupRelationAddDto userGroupRelationAddDto) {
        boolean b = accountService.add(userGroupRelationAddDto);
        if (!b) {
            throw new ApiException("用户组添加失败");
        }
        return true;
    }

//    /**
//     * 删除用户的用户组
//     *
//     * @param id 用户 UserRoleVo 的 id
//     * @return true
//     */
//    @OperationLog(operationMethod = "DELETE", operationModule = "UserGroup")
//    @DeleteMapping("deleteUserGroup/{id}")
//    @ApiOperation("删除用户用户组")
//    @ApiImplicitParam(name = "id", value = "用户 UserGroupVo 的 id")
//    public boolean deleteUserGroup(@PathVariable Integer id) {
//        boolean delete = accountService.delete(id);
//        if (!delete) {
//            throw new ApiException("用户组用户删除失败");
//        }
//        return true;
//    }

    @OperationLog(operationMethod = "UPDATE", operationModule = "User")
    @PutMapping("updateUserPassword")
    @ApiOperation("修改密码")
    public boolean updateUserPassword(String id, String oldPassword, String newPassword) {
        return accountService.updateUserPassword(id, oldPassword, newPassword);
    }
}
