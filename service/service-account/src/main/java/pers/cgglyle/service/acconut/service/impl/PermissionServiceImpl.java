package pers.cgglyle.service.acconut.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.annotaion.RedisCache;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.service.acconut.mapper.PermissionMapper;
import pers.cgglyle.service.acconut.model.dto.PermissionDto;
import pers.cgglyle.service.acconut.model.dto.PermissionGetListDto;
import pers.cgglyle.service.acconut.model.entity.PermissionEntity;
import pers.cgglyle.service.acconut.model.query.PermissionQuery;
import pers.cgglyle.service.acconut.model.vo.PermissionVo;
import pers.cgglyle.service.acconut.service.PermissionService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cgglyle
 * @date 2021-12-29 14:33
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<PermissionMapper, PermissionEntity> implements PermissionService {

    @Override
    public boolean add(PermissionDto permissionDto) {
        PermissionEntity permissionEntity = new PermissionEntity();
        BeanUtils.copyProperties(permissionDto,permissionEntity);
        return super.add(permissionEntity);
    }

    @RedisCache
    @Override
    public PageResult getPage(BaseQuery baseQuery) {
        PermissionQuery permissionQuery = (PermissionQuery) baseQuery;
        Page<PermissionEntity> page = new Page<>(permissionQuery.getPageNum(), permissionQuery.getPageSize());
        Page<PermissionEntity> data = lambdaQuery().like(StringUtils.isNotEmpty(permissionQuery.getPermissionName()),PermissionEntity::getPermissionName, permissionQuery.getPermissionName())
                .like(StringUtils.isNotEmpty(permissionQuery.getPermissionUrl()),PermissionEntity::getPermissionUrl, permissionQuery.getPermissionUrl())
                .orderByDesc(PermissionEntity::getPermissionName)
                .page(page);
        List<PermissionVo> collect = data.getRecords().stream().map(permissionEntity -> {
            PermissionVo permissionVo = new PermissionVo();
            BeanUtils.copyProperties(permissionEntity, permissionVo);
            return permissionVo;
        }).collect(Collectors.toList());
        return new PageResult(permissionQuery.getPageNum(),permissionQuery.getPageSize(),data.getTotal(),data.getPages(),collect);
    }

    @RedisCache
    @Override
    public List<PermissionGetListDto> getPermissionList(String resourceUrl) {
        List<PermissionEntity> data = lambdaQuery().eq(PermissionEntity::getPermissionUrl, resourceUrl)
                .list();
        return data.stream().map(permissionEntity -> {
            PermissionGetListDto permissionGetListDto = new PermissionGetListDto();
            BeanUtils.copyProperties(permissionEntity, permissionGetListDto);
            return permissionGetListDto;
        }).collect(Collectors.toList());
    }

}
