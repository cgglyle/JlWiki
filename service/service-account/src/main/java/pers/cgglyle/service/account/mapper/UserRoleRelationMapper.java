package pers.cgglyle.service.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.cgglyle.service.account.model.entity.UserRoleRelationEntity;

/**
 * 用户角色映射接口
 *
 * @author cgglyle
 * @date 2021-12-08 16:03
 */
@Mapper
public interface UserRoleRelationMapper extends BaseMapper<UserRoleRelationEntity> {
}
