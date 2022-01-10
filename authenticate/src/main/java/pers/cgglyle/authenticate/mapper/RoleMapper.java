package pers.cgglyle.authenticate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.cgglyle.authenticate.model.entity.RoleEntity;

/**
 * 角色映射接口
 *
 * @author cgglyle
 * @date 2021-12-08 13:09
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {
}
