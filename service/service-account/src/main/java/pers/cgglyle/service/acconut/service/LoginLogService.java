package pers.cgglyle.service.acconut.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.cgglyle.service.acconut.model.entity.LoginLogEntity;
import pers.cgglyle.service.acconut.model.vo.UserInfo;

/**
 * @author cgglyle
 * @date 2021-12-17 10:16
 */
public interface LoginLogService extends IService<LoginLogEntity> {
    boolean LoginLogSave(UserInfo userInfo);
}
