package pers.cgglyle.service.acconut.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.cgglyle.response.PageResult;
import pers.cgglyle.service.acconut.model.query.RoleQuery;
import pers.cgglyle.service.acconut.service.RoleService;

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
    public PageResult getPage(RoleQuery roleQuery){
        return roleService.getPage(roleQuery);
    }
}
