package pers.cgglyle.authenticate.service.impl;

import org.springframework.stereotype.Service;
import pers.cgglyle.authenticate.mapper.PermissionMapper;
import pers.cgglyle.authenticate.model.entity.PermissionEntity;
import pers.cgglyle.authenticate.service.intf.PermissionService;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;

/**
 * @author cgglyle
 * @date 2021-12-29 14:33
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<PermissionMapper, PermissionEntity> implements PermissionService {

}
