package pers.cgglyle.service.account.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.common.annotaion.OperationLog;
import pers.cgglyle.common.base.controller.BaseController;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.service.account.model.dto.*;
import pers.cgglyle.service.account.model.query.UserQuery;
import pers.cgglyle.service.account.service.AccountService;

import java.io.Serializable;

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
public class UserController extends BaseController<AccountService, UserQuery, UserAddDto, UserUpdateDto, UserDeleteDto> {

    /**
     * 给一个用户添加一个角色
     *
     * @param userRoleRelationAddDto 添加请求
     * @return 成功失败
     */
    @OperationLog(operationModule = "UserRole", operationMethod = "POST")
    @PostMapping("addUserRole")
    @ApiOperation("给用户添加角色")
    public boolean addUserRole(@RequestBody UserRoleRelationAddDto userRoleRelationAddDto) {
        boolean b = baseRelationService.add(userRoleRelationAddDto);
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
        boolean delete = baseRelationService.delete(new UserRoleRelationDeleteDto(id));
        if (!delete) {
            throw new ApiException("角色删除失败");
        }
        return true;
    }

    /**
     * 给一个用户添加一个用户组
     *
     * @param userGroupRelationAddDto 添加请求
     * @return 成功失败
     */
    @OperationLog(operationModule = "UserGroup", operationMethod = "POST")
    @PostMapping("addUserGroup")
    @ApiOperation("给用户添加用户组")
    public boolean addUserGroup(@RequestBody UserGroupRelationAddDto userGroupRelationAddDto) {
        boolean b = baseRelationService.add(userGroupRelationAddDto);
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

    /**
     * 更新一个用户的密码
     *
     * @param id          用户id
     * @param oldPassword 老密码
     * @param newPassword 新密码
     * @return 成功失败
     */
    @OperationLog(operationMethod = "UPDATE", operationModule = "User")
    @PutMapping("updateUserPassword")
    @ApiOperation("修改密码")
    public boolean updateUserPassword(String id, String oldPassword, String newPassword) {
        return baseRelationService.updateUserPassword(id, oldPassword, newPassword);
    }
}
