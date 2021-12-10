package pers.cgglyle.service.acconut.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.response.ApiException;
import pers.cgglyle.response.PageResult;
import pers.cgglyle.service.acconut.model.dto.RoleAddDto;
import pers.cgglyle.service.acconut.model.dto.RoleUpdateDto;
import pers.cgglyle.service.acconut.model.query.RoleQuery;
import pers.cgglyle.service.acconut.service.RoleService;

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

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @ApiOperation("获取分页")
    @GetMapping("getPage")
    public PageResult getPage(RoleQuery roleQuery) {
        return roleService.getPage(roleQuery);
    }

    @PostMapping("addRole")
    @ApiOperation("添加角色")
    public boolean addRole(@RequestBody RoleAddDto roleAddDto) {
        boolean b = roleService.addRole(roleAddDto);
        if (!b) {
            throw new ApiException("角色添加失败");
        }
        return true;
    }

    /**
     * 删除角色
     * <p>
     * TODO 删除角色会同时删除所有拥有这个角色的用户的这个角色（笑）。
     *
     * @param id 角色id
     * @return true
     */
    @DeleteMapping("deleteRole")
    @ApiOperation("删除角色")
    public boolean deleteRole(Integer id) {
        boolean delete = roleService.delete(id);
        if (!delete) {
            throw new ApiException("角色删除失败");
        }
        return true;
    }

    @PutMapping("updateRole")
    @ApiOperation("更新角色")
    public boolean updateRole(@RequestBody RoleUpdateDto roleUpdateDto) {
        boolean b = roleService.updateRole(roleUpdateDto);
        if (!b) {
            throw new ApiException("更新角色失败");
        }
        return true;
    }

    /**
     * 批量删除角色
     * <p>
     * TODO 删除角色会同时删除所有拥有这个角色的用户的这个角色（笑）。
     *
     * @param idList 角色id列表
     * @return true
     */
    @DeleteMapping("batchDeleteRole")
    @ApiOperation("批量删除角色")
    public boolean batchDeleteRole(List<Integer> idList) {
        boolean b = roleService.batchDelete(idList);
        if (!b) {
            throw new ApiException("批量删除失败");
        }
        return true;
    }

}
