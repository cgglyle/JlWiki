package pers.cgglyle.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.cgglyle.base.model.BaseQuery;
import pers.cgglyle.response.PageResult;

/**
 * 基础服务层接口。
 *
 * @author cgglyle
 * @date 2021/12/6
 */
public interface IBaseService<T> extends IService<T> {
    /**
     * 根据查询体分页查询。
     *
     * @param baseQuery 查询体
     * @return 分页模型
     */
    PageResult getPage(BaseQuery baseQuery);
}
