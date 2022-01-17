package pers.cgglyle.common.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.cgglyle.common.annotaion.QueryModel;
import pers.cgglyle.common.base.model.BaseEntity;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.IBaseService;
import pers.cgglyle.common.enums.QueryModelEnum;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.common.utils.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 服务成基础实现
 *
 * @param <M> 映射Mapper
 * @param <T> 实体类
 * @author cgglyle
 * @date 2021/12/6
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements IBaseService<T> {

    @Override
    public Page<T> get(BaseQuery query) throws IllegalAccessException {
        Class<? extends BaseQuery> aClass = query.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object temp = declaredField.get(query);
            String underline = pers.cgglyle.common.utils.StringUtils.underline(declaredField.getName());
            QueryModel annotation = declaredField.getAnnotation(QueryModel.class);
            if (annotation == null) {
                wrapper.like(temp instanceof String ? StringUtils.isNotBlank((String) temp) : temp != null, underline, temp);
                continue;
            }
            if (annotation.value() == QueryModelEnum.EQ) {
                wrapper.eq(temp instanceof String ? StringUtils.isNotBlank((String) temp) : temp != null, underline, temp);
            } else {
                wrapper.like(temp instanceof String ? StringUtils.isNotBlank((String) temp) : temp != null, underline, temp);
            }
        }
        Page<T> page = new Page<>(query.getPageNum(), query.getPageSize());
        return page(page, wrapper);
    }

    @Override
    public boolean add(T entity) {
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setStatus(true);
        entity.setDeleted(true);
        entity.setSystem(false);
        return this.save(entity);
    }

    @Override
    public boolean delete(Serializable id) {
        // 判断是否为系统预制
        if (this.getById(id).isSystem()) {
            throw new ApiException("系统预制，不可删除");
        }
        return this.removeById(id);
    }

    @Override
    public boolean update(T entity) {
        entity.setUpdateTime(LocalDateTime.now());
        return updateById(entity);
    }

    @Override
    public boolean batchDelete(List<Serializable> idList) {
        for (Serializable id : idList) {
            if (this.getById(id).isSystem()) {
                throw new ApiException(id + "系统预制，不可删除");
            }
        }
        return this.removeByIds(idList);
    }
}
