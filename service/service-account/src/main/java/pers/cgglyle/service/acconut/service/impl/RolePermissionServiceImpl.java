package pers.cgglyle.service.acconut.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.model.BaseDto;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.impl.BaseRelationServiceImpl;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.service.acconut.model.dto.PermissionAddDto;
import pers.cgglyle.service.acconut.model.dto.RoleAddDto;
import pers.cgglyle.service.acconut.model.dto.RolePermissionRelationAddDto;
import pers.cgglyle.service.acconut.model.entity.PermissionEntity;
import pers.cgglyle.service.acconut.model.entity.RoleEntity;
import pers.cgglyle.service.acconut.model.entity.RolePermissionRelationEntity;
import pers.cgglyle.service.acconut.model.query.PermissionQuery;
import pers.cgglyle.service.acconut.model.query.RoleQuery;
import pers.cgglyle.service.acconut.model.vo.PermissionVo;
import pers.cgglyle.service.acconut.model.vo.RolePermissionRelationVo;
import pers.cgglyle.service.acconut.model.vo.RoleVo;
import pers.cgglyle.service.acconut.service.PermissionService;
import pers.cgglyle.service.acconut.service.RolePermissionRelationService;
import pers.cgglyle.service.acconut.service.RolePermissionService;
import pers.cgglyle.service.acconut.service.RoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cgglyle
 * @date 2021-12-30 10:50
 */
@Service
public class RolePermissionServiceImpl extends BaseRelationServiceImpl implements RolePermissionService {

    private final RoleService roleService;
    private final RolePermissionRelationService rolePermissionRelationService;
    private final PermissionService permissionService;

    public RolePermissionServiceImpl(RoleService roleService,
                                     RolePermissionRelationService rolePermissionRelationService,
                                     PermissionService permissionService) {
        this.roleService = roleService;
        this.rolePermissionRelationService = rolePermissionRelationService;
        this.permissionService = permissionService;
    }

    /**
     * 根据请求获取分页信息
     * <p>
     * 请求参数必须继承{@link pers.cgglyle.common.base.model.BaseQuery}
     *
     * @param baseQuery 请求模型
     * @return 分页模型
     */
    @Override
    public PageResult get(BaseQuery baseQuery) {
        if (baseQuery instanceof PermissionQuery) {
            Page<PermissionEntity> data = permissionService.get(baseQuery);
            return wrapper(data, baseQuery, PermissionVo.class);
        }
        if (baseQuery instanceof RoleQuery) {
            Page<RoleEntity> data = roleService.get(baseQuery);
            return wrapper(data, baseQuery, RoleVo.class, o -> {
                List<RolePermissionRelationEntity> relationList = rolePermissionRelationService.getListByRoleId(((RoleVo) o).getId());
                List<RolePermissionRelationVo> collect = relationList.stream().map(relation -> {
                    RolePermissionRelationVo rolePermissionRelationVo = new RolePermissionRelationVo();
                    PermissionEntity permission = permissionService.getById(relation.getPermissionId());
                    rolePermissionRelationVo.setPermission(permission.getPermissionName());
                    BeanUtils.copyProperties(relation, rolePermissionRelationVo);
                    return rolePermissionRelationVo;
                }).collect(Collectors.toList());
                ((RoleVo) o).setPermissionList(collect);
            });
        }
        return null;
    }

    @Override
    public boolean add(BaseDto dto) {
        if (dto instanceof RoleAddDto roleAddDto) {
            RoleEntity roleEntity = new RoleEntity();
            BeanUtils.copyProperties(roleAddDto, roleEntity);
            return roleService.add(roleEntity);
        }
        if (dto instanceof PermissionAddDto permissionAddDto) {
            PermissionEntity permissionEntity = new PermissionEntity();
            BeanUtils.copyProperties(permissionAddDto, permissionEntity);
            return permissionService.add(permissionEntity);
        }
        if (dto instanceof RolePermissionRelationAddDto rolePermissionRelationAddDto) {
            RolePermissionRelationEntity rolePermissionRelationEntity = new RolePermissionRelationEntity();
            BeanUtils.copyProperties(rolePermissionRelationAddDto, rolePermissionRelationEntity);
            return rolePermissionRelationService.add(rolePermissionRelationEntity);
        }
        return false;
    }

    @Override
    public List<String> getRoleList(String url) {
        PermissionEntity permissionEntity = permissionService.lambdaQuery()
                .eq(PermissionEntity::getPermissionUrl, url)
                .one();
        if (permissionEntity == null){
            return null;
        }
        List<RolePermissionRelationEntity> relationList = rolePermissionRelationService.lambdaQuery()
                .eq(RolePermissionRelationEntity::getPermissionId, permissionEntity.getId())
                .list();
        List<String> roleString = new ArrayList<>();
        relationList.forEach(relation ->{
            RoleEntity one = roleService.lambdaQuery().eq(RoleEntity::getId, relation.getRoleId()).one();
            roleString.add(one.getRoleName());
        });
        return roleString;
    }
}
