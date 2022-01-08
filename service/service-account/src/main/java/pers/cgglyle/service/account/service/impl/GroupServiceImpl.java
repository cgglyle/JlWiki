package pers.cgglyle.service.account.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.service.account.mapper.GroupMapper;
import pers.cgglyle.service.account.model.dto.GroupAddDto;
import pers.cgglyle.service.account.model.dto.GroupUpdateDto;
import pers.cgglyle.service.account.model.entity.GroupEntity;
import pers.cgglyle.service.account.service.GroupService;

/**
 * 用户组服务成实现
 *
 * @author cgglyle
 * @date 2021-12-10 09:59
 */
@Service
public class GroupServiceImpl extends BaseServiceImpl<GroupMapper, GroupEntity> implements GroupService {

}
