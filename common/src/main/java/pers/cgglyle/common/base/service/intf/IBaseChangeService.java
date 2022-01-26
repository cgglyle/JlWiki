package pers.cgglyle.common.base.service.intf;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author cgglyle
 * @date 2022-01-25 15:17
 */
public interface IBaseChangeService<T>{

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param entity 实体对象
     */
    boolean save(T entity);
    /**
     * 插入（批量）
     *
     * @param entityList 实体对象集合
     */
    @Transactional(rollbackFor = Exception.class)
    boolean saveBatch(Collection<T> entityList);

    /**
     * 插入（批量）
     *
     * @param entityList 实体对象集合
     * @param batchSize  插入批次数量
     */
    boolean saveBatch(Collection<T> entityList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     */
    @Transactional(rollbackFor = Exception.class)
    boolean saveOrUpdateBatch(Collection<T> entityList);

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     * @param batchSize  每次的数量
     */
    boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize);

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    boolean removeById(Serializable id);

    /**
     * 根据 ID 删除
     *
     * @param id      主键(类型必须与实体类型字段保持一致)
     * @param useFill 是否启用填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    boolean removeById(Serializable id, boolean useFill);

    /**
     * 根据实体(ID)删除
     *
     * @param entity 实体
     * @since 3.4.4
     */
    boolean removeById(T entity);

    /**
     * 根据 columnMap 条件，删除记录
     *
     * @param columnMap 表字段 map 对象
     */
    boolean removeByMap(Map<String, Object> columnMap);

    /**
     * 根据id删除实体
     *
     * @param id 主键id
     * @return true-成功，false-失败
     */
    boolean remove(Serializable id);

    /**
     * 根据 entity 条件，删除记录
     *
     * @param queryWrapper 实体包装类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    boolean remove(Wrapper<T> queryWrapper);

    /**
     * 删除（根据ID 批量删除）
     *
     * @param list 主键ID或实体列表
     */
    boolean removeByIds(Collection<?> list);

    /**
     * 批量删除
     *
     * @param list    主键ID或实体列表
     * @param useFill 是否填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    @Transactional(rollbackFor = Exception.class)
    boolean removeByIds(Collection<?> list, boolean useFill);

    /**
     * 根据id列表删除
     *
     * @param idList id列表
     * @return true-成功，false-失败
     */
    boolean removeBatch(List<Serializable> idList);

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list 主键ID或实体列表(主键ID类型必须与实体类型字段保持一致)
     * @return 删除结果
     * @since 3.5.0
     */
    @Transactional(rollbackFor = Exception.class)
    boolean removeBatchByIds(Collection<?> list);

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list    主键ID或实体列表(主键ID类型必须与实体类型字段保持一致)
     * @param useFill 是否启用填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    @Transactional(rollbackFor = Exception.class)
    boolean removeBatchByIds(Collection<?> list, boolean useFill);

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list      主键ID或实体列表
     * @param batchSize 批次大小
     * @return 删除结果
     * @since 3.5.0
     */
    boolean removeBatchByIds(Collection<?> list, int batchSize) ;

    /**
     * 批量删除(jdbc批量提交)
     *
     * @param list      主键ID或实体列表
     * @param batchSize 批次大小
     * @param useFill   是否启用填充(为true的情况,会将入参转换实体进行delete删除)
     * @return 删除结果
     * @since 3.5.0
     */
    boolean removeBatchByIds(Collection<?> list, int batchSize, boolean useFill);

    /**
     * 根据id更新数据
     *
     * @param entity 实体信息
     * @return true-成功，false-失败
     */
    boolean update(T entity);

    /**
     * 根据 ID 选择修改
     *
     * @param entity 实体对象
     */
    boolean updateById(T entity) ;

    /**
     * 根据 UpdateWrapper 条件，更新记录 需要设置sqlset
     *
     * @param updateWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper}
     */
    boolean update(Wrapper<T> updateWrapper) ;

    /**
     * 根据 whereEntity 条件，更新记录
     *
     * @param entity        实体对象
     * @param updateWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper}
     */
    boolean update(T entity, Wrapper<T> updateWrapper);

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     */
    @Transactional(rollbackFor = Exception.class)
    boolean updateBatchById(Collection<T> entityList);

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     */
    boolean updateBatchById(Collection<T> entityList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param entity 实体对象
     */
    boolean saveOrUpdate(T entity);
}
