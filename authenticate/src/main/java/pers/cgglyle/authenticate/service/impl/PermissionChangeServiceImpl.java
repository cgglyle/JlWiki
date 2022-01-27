package pers.cgglyle.authenticate.service.impl;

import org.springframework.stereotype.Service;
import pers.cgglyle.authenticate.mapper.PermissionMapper;
import pers.cgglyle.authenticate.model.entity.PermissionEntity;
import pers.cgglyle.authenticate.service.intf.PermissionChangeService;
import pers.cgglyle.common.base.service.impl.BaseChangeServiceImpl;

/**
 * @author cgglyle
 * @date 2022-01-26 19:42
 */
@Service
public class PermissionChangeServiceImpl extends BaseChangeServiceImpl<PermissionMapper, PermissionEntity> implements PermissionChangeService {
}
