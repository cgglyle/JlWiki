package pers.cgglyle.authenticate.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.authenticate.model.dto.*;
import pers.cgglyle.authenticate.model.query.UserQuery;
import pers.cgglyle.authenticate.service.intf.AccountService;
import pers.cgglyle.common.annotaion.OperationLog;
import pers.cgglyle.common.base.controller.BaseController;
import pers.cgglyle.common.response.ApiException;

/**
 * 用户控制器
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Tag(name = "用户控制")
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
    @Operation(summary = "给用户添加角色")
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
     * @param dto 用户 UserRoleVo 的 id
     * @return true
     */
    @OperationLog(operationMethod = "DELETE", operationModule = "UserRole")
    @DeleteMapping("deleteUserRole/{id}")
    @Operation(summary = "删除用户角色")
    @Parameter(name = "id", description = "用户 UserRoleVo 的 id")
    public boolean deleteUserRole(@RequestBody UserRoleRelationDeleteDto dto) {
        boolean delete = baseRelationService.delete(dto);
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
    @Operation(summary = "给用户添加用户组")
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
    @Operation(summary = "修改密码")
    public boolean updateUserPassword(String id, String oldPassword, String newPassword) {
        return baseRelationService.updateUserPassword(id, oldPassword, newPassword);
    }
}
