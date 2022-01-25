package pers.cgglyle.common.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import pers.cgglyle.common.annotaion.QueryModel;
import pers.cgglyle.common.base.model.BaseEntity;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.intf.IBaseGetService;
import pers.cgglyle.common.constant.enums.QueryModelEnum;
import pers.cgglyle.common.utils.StringUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author cgglyle
 * @date 2022-01-25 14:56
 */
public abstract class BaseGetServcieImpl<M extends BaseMapper<T>, T extends BaseEntity> implements IBaseGetService<T> {
    @Autowired
    private ServiceImpl<M, T> service;

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    @Override
    public List<T> listByIds(Collection<? extends Serializable> idList) {
        return this.service.listByIds(idList);
    }

    /**
     * 查询（根据 columnMap 条件）
     *
     * @param columnMap 表字段 map 对象
     */
    @Override
    public List<T> listByMap(Map<String, Object> columnMap) {
        return this.service.listByMap(columnMap);
    }

    /**
     * 根据查询条件，查询分页信息
     * <p>支持根据查询条件动态查询
     * <p>需要在继承了{@code BaseQuery}的请求类中的成员上标注上
     * {@link QueryModel#value()}，并控制{@code value}的值。
     *
     * @param query 查询模型
     * @return 分页模型
     * @throws Exception 非法访问异常
     * @see QueryModel
     */
    @Override
    public Page<T> get(BaseQuery query) throws Exception {
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
        return this.service.page(page, wrapper);
    }

    /**
     * 根据 Wrapper，查询一条记录 <br/>
     * <p>结果集，如果是多个会抛出异常，随机取一条加上限制条件 wrapper.last("LIMIT 1")</p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public T getOne(Wrapper<T> queryWrapper) {
        return this.service.getOne(queryWrapper);
    }

    /**
     * 根据 Wrapper，查询一条记录
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     * @param throwEx      有多个 result 是否抛出异常
     */
    @Override
    public T getOne(Wrapper<T> queryWrapper, boolean throwEx) {
        return this.service.getOne(queryWrapper, throwEx);
    }

    /**
     * 根据 Wrapper，查询一条记录
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public Map<String, Object> getMap(Wrapper<T> queryWrapper) {
        return this.service.getMap(queryWrapper);
    }

    /**
     * 根据 Wrapper，查询一条记录
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     * @param mapper       转换函数
     */
    @Override
    public <V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
        return this.service.getObj(queryWrapper, mapper);
    }

    /**
     * 获取对应 entity 的 BaseMapper
     *
     * @return BaseMapper
     */
    @Override
    public BaseMapper<T> getBaseMapper() {
        return this.service.getBaseMapper();
    }

    /**
     * 获取 entity 的 class
     *
     * @return {@link Class<T>}
     */
    @Override
    public Class<T> getEntityClass() {
        return this.service.getEntityClass();
    }

    /**
     * 查询总记录数
     *
     * @see Wrappers#emptyWrapper()
     */
    @Override
    public long count() {
        return this.service.count();
    }

    /**
     * 根据 Wrapper 条件，查询总记录数
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public long count(Wrapper<T> queryWrapper) {
        return this.service.count(queryWrapper);
    }

    /**
     * 查询列表
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public List<T> list(Wrapper<T> queryWrapper) {
        return this.service.list(queryWrapper);
    }

    /**
     * 查询所有
     *
     * @see Wrappers#emptyWrapper()
     */
    @Override
    public List<T> list() {
        return this.service.list();
    }

    /**
     * 翻页查询
     *
     * @param page         翻页对象
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public <E extends IPage<T>> E page(E page, Wrapper<T> queryWrapper) {
        return this.service.page(page, queryWrapper);
    }

    /**
     * 无条件翻页查询
     *
     * @param page 翻页对象
     * @see Wrappers#emptyWrapper()
     */
    @Override
    public <E extends IPage<T>> E page(E page) {
        return this.service.page(page);
    }

    /**
     * 查询列表
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper) {
        return this.service.listMaps(queryWrapper);
    }

    /**
     * 查询所有列表
     *
     * @see Wrappers#emptyWrapper()
     */
    @Override
    public List<Map<String, Object>> listMaps() {
        return this.service.listMaps();
    }

    /**
     * 查询全部记录
     */
    @Override
    public List<Object> listObjs() {
        return this.service.listObjs();
    }

    /**
     * 查询全部记录
     *
     * @param mapper 转换函数
     */
    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return this.service.listObjs(mapper);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public List<Object> listObjs(Wrapper<T> queryWrapper) {
        return this.service.listObjs(queryWrapper);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     * @param mapper       转换函数
     */
    @Override
    public <V> List<V> listObjs(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
        return this.service.listObjs(queryWrapper, mapper);
    }

    /**
     * 翻页查询
     *
     * @param page         翻页对象
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<T> queryWrapper) {
        return this.service.pageMaps(page, queryWrapper);
    }

    /**
     * 无条件翻页查询
     *
     * @param page 翻页对象
     * @see Wrappers#emptyWrapper()
     */
    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
        return this.service.pageMaps(page);
    }
}
