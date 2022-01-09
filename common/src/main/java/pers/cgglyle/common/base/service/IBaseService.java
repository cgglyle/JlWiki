package pers.cgglyle.common.base.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.cgglyle.common.annotaion.QueryModel;
import pers.cgglyle.common.base.model.BaseQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 基础服务层接口。
 *
 * @author cgglyle
 * @date 2021/12/6
 */
public interface IBaseService<T> extends IService<T> {

    /**
     * 根据查询条件，查询分页信息
     * <p>支持根据查询条件动态查询
     * <p>需要在继承了{@code BaseQuery}的请求类中的成员上标注上
     * {@link QueryModel#value()}，并控制{@code value}的值。
     *
     * @param query 查询模型
     * @return 分页模型
     * @throws IllegalAccessException 非法访问异常
     * @see QueryModel
     */
    Page<T> get(BaseQuery query) throws IllegalAccessException;

    /**
     * 存储实体信息
     *
     * @param entity 实体信息
     * @return true-成功，false-失败
     */
    boolean add(T entity);

    /**
     * 根据id删除实体
     *
     * @param id 主键id
     * @return true-成功，false-失败
     */
    boolean delete(Serializable id);

    /**
     * 根据id更新数据
     *
     * @param entity 实体信息
     * @return true-成功，false-失败
     */
    boolean update(T entity);

    /**
     * 根据id列表删除
     *
     * @param idList id列表
     * @return true-成功，false-失败
     */
    boolean batchDelete(List<Serializable> idList);

}
