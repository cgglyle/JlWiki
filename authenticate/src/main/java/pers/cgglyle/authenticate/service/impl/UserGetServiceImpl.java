package pers.cgglyle.authenticate.service.impl;

import org.springframework.stereotype.Service;
import pers.cgglyle.authenticate.mapper.UserMapper;
import pers.cgglyle.authenticate.model.entity.UserEntity;
import pers.cgglyle.authenticate.service.intf.UserGetService;
import pers.cgglyle.common.base.service.impl.BaseGetServcieImpl;

/**
 * @author cgglyle
 * @date 2022-01-25 15:39
 */
@Service
public class UserGetServiceImpl extends BaseGetServcieImpl<UserMapper, UserEntity> implements UserGetService {
}
