package pers.cgglyle.authenticate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.cgglyle.authenticate.model.entity.UserEntity;

/**
 * 用户Mapper映射接口
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
