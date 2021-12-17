package pers.cgglyle.service.acconut.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.cgglyle.service.acconut.mapper.LoginLogMapper;
import pers.cgglyle.service.acconut.model.entity.LoginLogEntity;
import pers.cgglyle.service.acconut.model.vo.UserInfo;
import pers.cgglyle.service.acconut.service.LoginLogService;

/**
 * @author cgglyle
 * @date 2021-12-17 10:18
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLogEntity> implements LoginLogService {
    @Override
    public boolean LoginLogSave(UserInfo userInfo) {
        if (userInfo == null){
            return false;
        }

        return false;
    }
}
