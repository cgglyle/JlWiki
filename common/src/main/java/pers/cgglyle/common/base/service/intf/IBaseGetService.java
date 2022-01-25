package pers.cgglyle.common.base.service.intf;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import pers.cgglyle.common.annotaion.QueryModel;
import pers.cgglyle.common.base.model.BaseQuery;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author cgglyle
 * @date 2022-01-25 14:55
 */
public interface IBaseGetService<T> {

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<T> listByIds(Collection<? extends Serializable> idList);

    /**
     * 查询（根据 columnMap 条件）
     *
     * @param columnMap 表字段 map 对象
     */
    List<T> listByMap(Map<String, Object> columnMap);

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
    Page<T> get(BaseQuery query) throws Exception;

    /**
     * 根据 Wrapper，查询一条记录 <br/>
     * <p>结果集，如果是多个会抛出异常，随机取一条加上限制条件 wrapper.last("LIMIT 1")</p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    T getOne(Wrapper<T> queryWrapper);

    /**
     * 根据 Wrapper，查询一条记录
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     * @param throwEx      有多个 result 是否抛出异常
     */
    T getOne(Wrapper<T> queryWrapper, boolean throwEx);

    /**
     * 根据 Wrapper，查询一条记录
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    Map<String, Object> getMap(Wrapper<T> queryWrapper);

    /**
     * 根据 Wrapper，查询一条记录
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     * @param mapper       转换函数
     */
    <V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper);

    /**
     * 查询总记录数
     *
     * @see Wrappers#emptyWrapper()
     */
    long count();

    /**
     * 根据 Wrapper 条件，查询总记录数
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    long count(Wrapper<T> queryWrapper);

    /**
     * 查询列表
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    List<T> list(Wrapper<T> queryWrapper);

    /**
     * 查询所有
     *
     * @see Wrappers#emptyWrapper()
     */
    List<T> list();

    /**
     * 翻页查询
     *
     * @param page         翻页对象
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    <E extends IPage<T>> E page(E page, Wrapper<T> queryWrapper);

    /**
     * 无条件翻页查询
     *
     * @param page 翻页对象
     * @see Wrappers#emptyWrapper()
     */
    <E extends IPage<T>> E page(E page);

    /**
     * 查询列表
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper);

    /**
     * 查询所有列表
     *
     * @see Wrappers#emptyWrapper()
     */
    List<Map<String, Object>> listMaps();

    /**
     * 查询全部记录
     */
    List<Object> listObjs();

    /**
     * 查询全部记录
     *
     * @param mapper 转换函数
     */
    <V> List<V> listObjs(Function<? super Object, V> mapper);

    /**
     * 根据 Wrapper 条件，查询全部记录
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    List<Object> listObjs(Wrapper<T> queryWrapper);

    /**
     * 根据 Wrapper 条件，查询全部记录
     *
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     * @param mapper       转换函数
     */
    <V> List<V> listObjs(Wrapper<T> queryWrapper, Function<? super Object, V> mapper);

    /**
     * 翻页查询
     *
     * @param page         翻页对象
     * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
     */
    <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<T> queryWrapper);

    /**
     * 无条件翻页查询
     *
     * @param page 翻页对象
     * @see Wrappers#emptyWrapper()
     */
    <E extends IPage<Map<String, Object>>> E pageMaps(E page);

    /**
     * 获取对应 entity 的 BaseMapper
     *
     * @return BaseMapper
     */
    BaseMapper<T> getBaseMapper();

    /**
     * 获取 entity 的 class
     *
     * @return {@link Class<T>}
     */
    Class<T> getEntityClass();

    /**
     * 链式查询 普通
     *
     * @return QueryWrapper 的包装类
     */
    QueryChainWrapper<T> query();

    /**
     * 链式查询 lambda 式
     * <p>注意：不支持 Kotlin </p>
     *
     * @return LambdaQueryWrapper 的包装类
     */
    LambdaQueryChainWrapper<T> lambdaQuery();
}
