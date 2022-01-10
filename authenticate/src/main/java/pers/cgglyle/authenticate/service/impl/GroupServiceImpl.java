package pers.cgglyle.authenticate.service.impl;

import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.authenticate.mapper.GroupMapper;
import pers.cgglyle.authenticate.model.entity.GroupEntity;
import pers.cgglyle.authenticate.service.GroupService;

/**
 * 用户组服务成实现
 *
 * @author cgglyle
 * @date 2021-12-10 09:59
 */
@Service
public class GroupServiceImpl extends BaseServiceImpl<GroupMapper, GroupEntity> implements GroupService {

}
