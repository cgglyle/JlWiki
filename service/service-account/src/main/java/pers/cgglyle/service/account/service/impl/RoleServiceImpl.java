package pers.cgglyle.service.account.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.service.account.mapper.RoleMapper;
import pers.cgglyle.service.account.model.entity.RoleEntity;
import pers.cgglyle.service.account.model.query.RoleQuery;
import pers.cgglyle.service.account.service.RoleService;

/**
 * 角色服务层
 *
 * @author cgglyle
 * @date 2021-12-08 13:08
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Override
    public Page<RoleEntity> get(BaseQuery query) {
        RoleQuery roleQuery = (RoleQuery) query;
        Page<RoleEntity> page = new Page<>(roleQuery.getPageNum(), roleQuery.getPageSize());
        return lambdaQuery().like(StringUtils.isNotEmpty(roleQuery.getRoleName()), RoleEntity::getRoleName, roleQuery.getRoleName())
                .orderByDesc(RoleEntity::getRoleName)
                .page(page);
    }
}
