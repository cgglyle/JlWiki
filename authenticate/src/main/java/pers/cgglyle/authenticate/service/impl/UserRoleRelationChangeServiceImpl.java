package pers.cgglyle.authenticate.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.cgglyle.authenticate.mapper.UserRoleRelationMapper;
import pers.cgglyle.authenticate.model.entity.UserRoleRelationEntity;
import pers.cgglyle.authenticate.service.intf.UserRoleRelationChangeService;
import pers.cgglyle.authenticate.service.intf.UserRoleRelationGetService;
import pers.cgglyle.common.base.model.BaseEntity;
import pers.cgglyle.common.base.service.impl.BaseChangeServiceImpl;
import pers.cgglyle.common.response.ApiException;

import java.io.Serializable;
import java.util.List;

/**
 * @author cgglyle
 * @date 2022-01-26 19:46
 */
@Service
public class UserRoleRelationChangeServiceImpl extends BaseChangeServiceImpl<UserRoleRelationMapper, UserRoleRelationEntity> implements UserRoleRelationChangeService {

    @Autowired
    private UserRoleRelationGetService userRoleRelationGetService;

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param entity 实体对象
     */
    @Override
    public boolean save(UserRoleRelationEntity entity) {
        List<UserRoleRelationEntity> list = this.userRoleRelationGetService.lambdaQuery().eq(UserRoleRelationEntity::getUserId, entity.getUserId()).list();
        list.forEach(userRoleRelationEntity -> {
            if (userRoleRelationEntity.getRoleId().equals(entity.getRoleId())) {
                throw new ApiException("已存在此角色");
            }
        });
        return super.save(entity);
    }

    /**
     * 删除关系根据角色id
     *
     * @param id 角色id
     * @return 成功失败
     */
    @Override
    public boolean deleteByRoleId(Serializable id) {
        return this.deleteUtil(this.userRoleRelationGetService.lambdaQuery()
                .eq(UserRoleRelationEntity::getRoleId, id));
    }

    /**
     * 删除关系根据用户id
     *
     * @param id 用户id
     * @return 成功失败
     */
    @Override
    public boolean deleteByUserId(Serializable id) {
        return this.deleteUtil(this.userRoleRelationGetService.lambdaQuery()
                .eq(UserRoleRelationEntity::getUserId, id));
    }

    /**
     * 删除工具
     * <p> 根据传入的{@code LambdaQueryChainWrapper}进行删除
     * @param eq
     * @return
     */
    private <T extends BaseEntity> boolean deleteUtil(LambdaQueryChainWrapper<T> wrapper) {
        List<T> userRoleList = wrapper.list();
        userRoleList.forEach(userRoleRelationEntity -> {
            boolean delete = super.remove(userRoleRelationEntity.getId());
            if (!delete) {
                throw new ApiException(userRoleRelationEntity.getId() + "删除失败");
            }
        });
        return true;
    }
}
