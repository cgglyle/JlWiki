package pers.cgglyle.common.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.cgglyle.common.base.model.BaseEntity;
import pers.cgglyle.common.base.service.intf.IBaseChangeService;
import pers.cgglyle.common.base.service.intf.IBaseGetService;
import pers.cgglyle.common.response.ApiException;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author cgglyle
 * @date 2022-01-25 15:53
 */
public abstract class BaseChangeService<M extends BaseMapper<T>, T extends BaseEntity> implements IBaseChangeService<T> {
    @Resource
    private IService<T> service;
    @Resource
    private IBaseGetService<T> getService;

    /**
     * 根据id更新数据
     *
     * @param entity 实体信息
     * @return true-成功，false-失败
     */
    @Override
    public boolean update(T entity) {
        entity.setUpdateTime(LocalDateTime.now());
        return this.update(entity);
    }

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param entity 实体对象
     */
    @Override
    public boolean save(T entity) {
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setStatus(true);
        entity.setDeleted(true);
        entity.setSystem(false);
        return this.service.save(entity);
    }

    /**
     * 插入（批量）
     *
     * @param entityList 实体对象集合
     */
    @Override
    public boolean saveBatch(Collection<T> entityList) {
        return this.service.saveBatch(entityList);
    }

    /**
     * 插入（批量）
     *
     * @param entityList 实体对象集合
     * @param batchSize  插入批次数量
     */
    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        return this.service.saveBatch(entityList, batchSize);
    }

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     */
    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList) {
        return this.service.saveOrUpdateBatch(entityList);
    }

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     * @param batchSize  每次的数量
     */
    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        return this.service.saveOrUpdateBatch(entityList, batchSize);
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    @Override
    public boolean removeById(Serializable id) {
        return this.service.removeById(id);
    }

    /**
     * 根据 ID 删除
     *
     * @param id      主键(类型必须与实体类型字段保持一致)
     * @param useFill 是否启用填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    public boolean removeById(Serializable id, boolean useFill) {
        return this.service.removeById(id, useFill);
    }

    /**
     * 根据实体(ID)删除
     *
     * @param entity 实体
     * @since 3.4.4
     */
    @Override
    public boolean removeById(T entity) {
        return this.service.removeById(entity);
    }

    /**
     * 根据 columnMap 条件，删除记录
     *
     * @param columnMap 表字段 map 对象
     */
    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return this.service.removeByMap(columnMap);
    }

    @Override
    public boolean remove(Serializable id) {
        // 判断是否为系统预制
        if (getService.getById(id).isSystem()) {
            throw new ApiException("系统预制，不可删除");
        }
        return this.removeById(id);
    }

    /**
     * 根据 entity 条件，删除记录
     *
     * @param queryWrapper 实体包装类 {@link QueryWrapper}
     */
    @Override
    public boolean remove(Wrapper<T> queryWrapper) {
        return this.service.remove(queryWrapper);
    }

    /**
     * 删除（根据ID 批量删除）
     *
     * @param list 主键ID或实体列表
     */
    @Override
    public boolean removeByIds(Collection<?> list) {
        return this.service.removeBatchByIds(list);
    }

    /**
     * 批量删除
     *
     * @param list    主键ID或实体列表
     * @param useFill 是否填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    public boolean removeByIds(Collection<?> list, boolean useFill) {
        return this.service.removeByIds(list, useFill);
    }

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list 主键ID或实体列表(主键ID类型必须与实体类型字段保持一致)
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    public boolean removeBatchByIds(Collection<?> list) {
        return removeBatchByIds(list);
    }

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list    主键ID或实体列表(主键ID类型必须与实体类型字段保持一致)
     * @param useFill 是否启用填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    public boolean removeBatchByIds(Collection<?> list, boolean useFill) {
        return this.service.removeBatchByIds(list, useFill);
    }

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list      主键ID或实体列表
     * @param batchSize 批次大小
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    public boolean removeBatchByIds(Collection<?> list, int batchSize) {
        return this.service.removeBatchByIds(list, batchSize);
    }

    /**
     * 根据id列表删除
     *
     * @param idList id列表
     * @return true-成功，false-失败
     */
    @Override
    public boolean removeBatch(List<Serializable> idList) {
        for (Serializable id : idList) {
            if (getService.getById(id).isSystem()) {
                throw new ApiException(id + "系统预制，不可删除");
            }
        }
        return this.service.removeByIds(idList);
    }

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list      主键ID或实体列表
     * @param batchSize 批次大小
     * @param useFill   是否启用填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    @Override
    public boolean removeBatchByIds(Collection<?> list, int batchSize, boolean useFill) {
        return removeBatchByIds(list, batchSize, useFill);
    }

    /**
     * 根据 ID 选择修改
     *
     * @param entity 实体对象
     */
    @Override
    public boolean updateById(T entity) {
        return this.service.updateById(entity);
    }

    /**
     * 根据 UpdateWrapper 条件，更新记录 需要设置sqlset
     *
     * @param updateWrapper 实体对象封装操作类 {@link UpdateWrapper}
     */
    @Override
    public boolean update(Wrapper<T> updateWrapper) {
        return this.service.update(updateWrapper);
    }

    /**
     * 根据 whereEntity 条件，更新记录
     *
     * @param entity        实体对象
     * @param updateWrapper 实体对象封装操作类 {@link UpdateWrapper}
     */
    @Override
    public boolean update(T entity, Wrapper<T> updateWrapper) {
        return this.service.update(entity, updateWrapper);
    }

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     */
    @Override
    public boolean updateBatchById(Collection<T> entityList) {
        return this.service.updateBatchById(entityList);
    }

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     */
    @Override
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        return this.service.updateBatchById(entityList, batchSize);
    }

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param entity 实体对象
     */
    @Override
    public boolean saveOrUpdate(T entity) {
        return this.service.save(entity);
    }
}
