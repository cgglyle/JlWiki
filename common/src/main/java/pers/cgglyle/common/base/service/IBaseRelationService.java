package pers.cgglyle.common.base.service;

import pers.cgglyle.common.base.model.BaseDto;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.response.PageResult;

/**
 * 基础中间服务层
 * <p>
 * 中间层用于连接各个基础服务的
 * <p>
 * Controller层
 * ⬇
 * BaseRelationService层
 * ⬇
 * BaseService层
 *
 * @author cgglyle
 * @date 2021-12-30 14:41
 */
public interface IBaseRelationService {

    /**
     * 根据请求获取分页信息
     * <p>
     * 抽象方法，需要重写
     * <p>
     * 请求参数必须继承{@link pers.cgglyle.common.base.model.BaseQuery}
     *
     * @param query 请求模型
     * @return 分页模型
     */
    PageResult get(BaseQuery query);

    /**
     * 根据请求添加模型
     *
     * @param dto 添加请求模型
     * @return 成功失败
     */
    boolean add(BaseDto dto);

    /**
     * 根据请求更新数据
     *
     * @param dto 更新请求模型
     * @return 成功失败
     */
    boolean update(BaseDto dto);

    /**
     * 根据id删除数据
     *
     * @param dto 删除请求模型
     * @return 成功失败
     */
    boolean delete(BaseDto dto);

    /**
     * 批量删除数据
     *
     * @param dto 删除请求模型
     * @return 成功失败
     */
    boolean batchDelete(BaseDto dto);
}
