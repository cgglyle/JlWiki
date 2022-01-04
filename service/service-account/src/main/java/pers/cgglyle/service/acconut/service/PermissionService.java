package pers.cgglyle.service.acconut.service;

import pers.cgglyle.common.base.service.IBaseService;
import pers.cgglyle.service.acconut.model.dto.PermissionGetListDto;
import pers.cgglyle.service.acconut.model.entity.PermissionEntity;

import java.util.List;

/**
 * @author cgglyle
 * @date 2021-12-29 14:30
 */
public interface PermissionService extends IBaseService<PermissionEntity> {


    /**
     * 获取权限列表
     *
     * @param resourceUrl
     * @return
     */
    List<PermissionGetListDto> getPermissionList(String resourceUrl);
}
