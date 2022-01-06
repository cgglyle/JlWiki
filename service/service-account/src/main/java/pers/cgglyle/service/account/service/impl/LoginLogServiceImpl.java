package pers.cgglyle.service.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.cgglyle.service.account.mapper.LoginLogMapper;
import pers.cgglyle.service.account.model.entity.LoginLogEntity;
import pers.cgglyle.service.account.service.LoginLogService;

/**
 * @author cgglyle
 * @date 2021-12-17 10:18
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLogEntity> implements LoginLogService {
}
