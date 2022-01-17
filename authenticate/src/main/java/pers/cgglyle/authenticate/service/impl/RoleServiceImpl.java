package pers.cgglyle.authenticate.service.impl;

import org.springframework.stereotype.Service;
import pers.cgglyle.authenticate.mapper.RoleMapper;
import pers.cgglyle.authenticate.model.entity.RoleEntity;
import pers.cgglyle.authenticate.service.RoleService;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;

/**
 * 角色服务层
 *
 * @author cgglyle
 * @date 2021-12-08 13:08
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, RoleEntity> implements RoleService {

}
