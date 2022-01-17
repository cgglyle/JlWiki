package pers.cgglyle.wiki.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.cgglyle.common.base.model.BaseDto;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.impl.BaseRelationServiceImpl;
import pers.cgglyle.common.model.entity.OperationLogEntity;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.wiki.model.dto.WikiMongoAddDto;
import pers.cgglyle.wiki.model.dto.WikiMongoDeleteDto;
import pers.cgglyle.wiki.model.entity.WikiEntity;
import pers.cgglyle.wiki.model.entity.WikiUserRelationEntity;
import pers.cgglyle.wiki.model.query.WikiMongoQuery;
import pers.cgglyle.wiki.model.vo.WikiVo;
import pers.cgglyle.wiki.service.WikiMongoService;
import pers.cgglyle.wiki.service.WikiService;
import pers.cgglyle.wiki.service.WikiUserRelationService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cgglyle
 * @date 2022-01-13 11:44
 */
@Service
public class WikiServiceImpl extends BaseRelationServiceImpl implements WikiService {
    @Autowired
    private WikiMongoService wikiMongoService;
    @Autowired
    private WikiUserRelationService wikiUserRelationService;

    @Override
    public PageResult get(BaseQuery query) throws IllegalAccessException {
        if (query instanceof WikiMongoQuery wikiMongoQuery) {
            // 分页条件
            PageRequest pageRequest = PageRequest.of(query.getPageNum().intValue() - 1, query.getPageSize().intValue());
            // 请求条件
            Query tempQuery = new Query();
            // 查询符合条件的条目数
            long count = wikiMongoService.count(tempQuery, OperationLogEntity.class, wikiMongoQuery.getCollection());
            // 分页条件放入请求
            tempQuery.with(pageRequest);
            // 查出日志体
            List<?> all = wikiMongoService.find(tempQuery, WikiEntity.class, wikiMongoQuery.getCollection());
            Page<?> page = PageableExecutionUtils.getPage(all, pageRequest, () -> count);
            // 封装显示
            List<WikiVo> collect = page.getContent().stream().map(o -> {
                WikiVo vo = new WikiVo();
                BeanUtils.copyProperties(o, vo);
                WikiUserRelationEntity entity = wikiUserRelationService.getById(vo.getWikiId());
                BeanUtils.copyProperties(entity, vo);
                return vo;
            }).collect(Collectors.toList());
            return new PageResult(query.getPageNum(), query.getPageSize(), page.getTotalElements(), page.getTotalPages(), collect);
        }
        return super.get(query);
    }

    @Transactional
    @Override
    public boolean add(BaseDto dto) {
        if (dto instanceof WikiMongoAddDto addDto) {
            WikiEntity wiki = new WikiEntity();
            BeanUtils.copyProperties(addDto, wiki);
            String wikiId = wikiMongoService.save(wiki, addDto.getCollection());
            WikiUserRelationEntity wikiUserRelationEntity = new WikiUserRelationEntity();
            BeanUtils.copyProperties(addDto, wikiUserRelationEntity);
            wikiUserRelationEntity.setWikiId(wikiId);
            wikiUserRelationEntity.setWikiVersion(1);
            return wikiUserRelationService.add(wikiUserRelationEntity);
        }
        throw new ApiException("未支持请求");
    }

    @Override
    public boolean update(BaseDto dto) {
        return super.update(dto);
    }

    @Override
    public boolean delete(BaseDto dto) {
        if (dto instanceof WikiMongoDeleteDto deleteDto) {
            return wikiMongoService.deleteById(deleteDto.getId());
        }
        return super.delete(dto);
    }
}
