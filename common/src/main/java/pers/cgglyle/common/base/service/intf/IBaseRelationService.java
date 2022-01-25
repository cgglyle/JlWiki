package pers.cgglyle.common.base.service.intf;

import pers.cgglyle.common.base.model.BaseDto;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.response.PageResult;

/**
 * 基础中间服务层
 * <p> 中间层用于连接各个基础服务的
 *
 * @author cgglyle
 * @date 2021-12-30 14:41
 */
public interface IBaseRelationService {

    /**
     * 根据请求获取分页信息
     * <p> 钩子函数
     *
     * @param query 请求模型
     * @return 分页模型
     * @throws IllegalAccessException 非法访问异常
     */
    PageResult get(BaseQuery query) throws Exception;

    /**
     * 根据请求添加模型
     * <p> 钩子函数
     *
     * @param dto 添加请求模型
     * @return 成功失败
     */
    boolean add(BaseDto dto);

    /**
     * 根据请求更新数据
     * <p> 钩子函数
     *
     * @param dto 更新请求模型
     * @return 成功失败
     */
    boolean update(BaseDto dto);

    /**
     * 根据id删除数据
     * <p> 钩子函数
     *
     * @param dto 删除请求模型
     * @return 成功失败
     */
    boolean delete(BaseDto dto);

    /**
     * 批量删除数据
     * <p> 钩子函数
     *
     * @param dto 删除请求模型
     * @return 成功失败
     */
    boolean batchDelete(BaseDto dto);
}
