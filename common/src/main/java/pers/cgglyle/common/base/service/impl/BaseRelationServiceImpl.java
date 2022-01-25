package pers.cgglyle.common.base.service.impl;

import pers.cgglyle.common.base.model.BaseDto;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.intf.IBaseRelationService;
import pers.cgglyle.common.response.PageResult;

/**
 * 基础关系服务层
 * <p> 中间层用于连接各个基础服务的
 *
 * @author cgglyle
 * @date 2021-12-30 14:37
 */
public class BaseRelationServiceImpl implements IBaseRelationService {

    @Override
    public PageResult get(BaseQuery query) throws Exception {
        throw new UnsupportedOperationException("未实现的操作");
    }

    @Override
    public boolean add(BaseDto dto) {
        throw new UnsupportedOperationException("未实现的操作");
    }

    @Override
    public boolean update(BaseDto dto) {
        throw new UnsupportedOperationException("未实现的操作");
    }

    @Override
    public boolean delete(BaseDto dto) {
        throw new UnsupportedOperationException("未实现的操作");
    }

    @Override
    public boolean batchDelete(BaseDto dto) {
        throw new UnsupportedOperationException("未实现的操作");
    }
}
