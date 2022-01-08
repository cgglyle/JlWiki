package pers.cgglyle.service.account.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.service.account.model.dto.GroupAddDto;
import pers.cgglyle.service.account.model.dto.GroupUpdateDto;
import pers.cgglyle.service.account.model.entity.GroupEntity;
import pers.cgglyle.service.account.model.query.GroupQuery;
import pers.cgglyle.service.account.model.vo.GroupVo;
import pers.cgglyle.service.account.service.GroupService;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户组控制层
 *
 * @author cgglyle
 * @date 2021-12-10 10:01
 */
@Api(tags = "用户组控制")
@CrossOrigin
@RestController
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @ApiOperation("获取分页")
    @GetMapping("getPage")
    public PageResult getPage(GroupQuery groupQuery) {
        return groupService.getPage(groupQuery);
    }

    @GetMapping("get")
    public PageResult get(GroupQuery groupQuery) throws IllegalAccessException {
        Page<GroupEntity> groupEntityPage = groupService.get(groupQuery);

        List<GroupVo> collect = groupEntityPage.getRecords().stream().map(groupEntity -> {
            GroupVo vo = new GroupVo();
            BeanUtils.copyProperties(groupEntity, vo);
            return vo;
        }).collect(Collectors.toList());
        return new PageResult(groupQuery.getPageNum(), groupQuery.getPageSize(), groupEntityPage.getTotal(), groupEntityPage.getPages(), collect);
    }

    @PostMapping("addGroup")
    @ApiOperation("添加用户组")
    public boolean addRole(@RequestBody GroupAddDto groupAddDto) {
        boolean b = groupService.addGroup(groupAddDto);
        if (!b) {
            throw new ApiException("用户组添加失败");
        }
        return true;
    }

    /**
     * 删除用户组
     *
     * @param id 用户组id
     * @return true
     */
    @DeleteMapping("deleteGroup")
    @ApiOperation("删除用户组")
    public boolean deleteRole(Integer id) {
        boolean delete = groupService.delete(id);
        if (!delete) {
            throw new ApiException("角色删除失败");
        }
        return true;
    }

    @PutMapping("updateGroup")
    @ApiOperation("更新用户组")
    public boolean updateGroup(@RequestBody GroupUpdateDto groupUpdateDto) {
        boolean b = groupService.updateGroup(groupUpdateDto);
        if (!b) {
            throw new ApiException("更新用户组失败");
        }
        return true;
    }

    /**
     * 批量删除用户组
     *
     * @param idList 用户组idList
     * @return true
     */
    @DeleteMapping("batchDeleteGroup")
    @ApiOperation("批量删除用户组")
    public boolean batchDeleteGroup(List<Serializable> idList) {
        boolean b = groupService.batchDelete(idList);
        if (!b) {
            throw new ApiException("批量删除失败");
        }
        return true;
    }
}
