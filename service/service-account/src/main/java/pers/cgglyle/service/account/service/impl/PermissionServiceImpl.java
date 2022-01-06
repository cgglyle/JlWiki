package pers.cgglyle.service.account.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.service.account.mapper.PermissionMapper;
import pers.cgglyle.service.account.model.entity.PermissionEntity;
import pers.cgglyle.service.account.model.query.PermissionQuery;
import pers.cgglyle.service.account.service.PermissionService;

/**
 * @author cgglyle
 * @date 2021-12-29 14:33
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<PermissionMapper, PermissionEntity> implements PermissionService {

    @Override
    public Page<PermissionEntity> get(BaseQuery query) {
        PermissionQuery permissionQuery = (PermissionQuery) query;
        Page<PermissionEntity> page = new Page<>(permissionQuery.getPageNum(), permissionQuery.getPageSize());
        return lambdaQuery().like(StringUtils.isNotEmpty(permissionQuery.getPermissionName()), PermissionEntity::getPermissionName, permissionQuery.getPermissionName())
                .like(StringUtils.isNotEmpty(permissionQuery.getPermissionUrl()), PermissionEntity::getPermissionUrl, permissionQuery.getPermissionUrl())
                .orderByDesc(PermissionEntity::getPermissionName)
                .page(page);
    }
}
