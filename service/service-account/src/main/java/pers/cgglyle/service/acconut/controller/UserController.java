package pers.cgglyle.service.acconut.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.response.ApiException;
import pers.cgglyle.response.PageResult;
import pers.cgglyle.service.acconut.model.dto.UserAddDto;
import pers.cgglyle.service.acconut.model.dto.UserUpdateDto;
import pers.cgglyle.service.acconut.model.query.UserQuery;
import pers.cgglyle.service.acconut.service.UserService;

import java.util.List;

/**
 * 用户控制器
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Api(tags = "User控制")
@CrossOrigin
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getPage")
    @ApiOperation("获取分页信息")
    public PageResult getPage(UserQuery userQuery){
        return userService.getPage(userQuery);
    }

    @PostMapping("addUser")
    @ApiOperation("添加用户")
    public boolean addUser(@RequestBody UserAddDto userAddDto){
        boolean b = userService.addUser(userAddDto);
        if(!b){
            throw new ApiException("用户添加失败");
        }
        return true;
    }

    @DeleteMapping("deleteUser")
    @ApiOperation("删除用户")
    public boolean deleteUser(Integer id){
        boolean delete = userService.delete(id);
        if(!delete){
            throw new ApiException("用户删除失败");
        }
        return true;
    }

    @PutMapping("updateUser")
    @ApiOperation("更新用户")
    public boolean updateUser(@RequestBody UserUpdateDto userUpdateDto){
        boolean b = userService.updateUser(userUpdateDto);
        if(!b){
            throw new ApiException("更新用户失败");
        }
        return true;
    }

    @DeleteMapping("batchDeleteUser")
    @ApiOperation("批量删除用户")
    public boolean batchDeleteUser(List<Integer> idList){
        boolean b = userService.batchDelete(idList);
        if(!b){
            throw new ApiException("批量删除失败");
        }
        return true;
    }
}
