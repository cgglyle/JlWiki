package pers.cgglyle.service.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.cgglyle.service.account.model.entity.GroupEntity;

/**
 * 用户组映射接口
 *
 * @author cgglyle
 * @date 2021-12-10 09:57
 */
@Mapper
public interface GroupMapper extends BaseMapper<GroupEntity> {
}
