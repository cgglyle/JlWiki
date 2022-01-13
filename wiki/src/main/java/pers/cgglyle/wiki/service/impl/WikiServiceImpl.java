package pers.cgglyle.wiki.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.model.BaseDto;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.impl.BaseRelationServiceImpl;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.wiki.model.dto.WikiMongoAddDto;
import pers.cgglyle.wiki.model.dto.WikiMongoDeleteDto;
import pers.cgglyle.wiki.model.entity.WikiEntity;
import pers.cgglyle.wiki.model.query.WikiMongoQuery;
import pers.cgglyle.wiki.model.vo.WikiVo;
import pers.cgglyle.wiki.service.WikiMongoService;
import pers.cgglyle.wiki.service.WikiService;

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

    @Override
    public PageResult get(BaseQuery query) throws IllegalAccessException {
        if (query instanceof WikiMongoQuery wikiMongoQuery){
            List<?> all = wikiMongoService.findAll(wikiMongoQuery.getCollection());
            List<WikiVo> collect = all.stream().map(wiki -> {
                WikiVo vo = new WikiVo();
                BeanUtils.copyProperties(wiki, vo);
                return vo;
            }).collect(Collectors.toList());
            return new PageResult(0,0,0,0,collect);
        }
        return super.get(query);
    }

    @Override
    public boolean add(BaseDto dto) {
        if (dto instanceof WikiMongoAddDto addDto){
            WikiEntity wiki = new WikiEntity();
            BeanUtils.copyProperties(addDto, wiki);
            return wikiMongoService.save(wiki, addDto.getCollection());
        }
        throw new ApiException("未支持请求");
    }

    @Override
    public boolean update(BaseDto dto) {
        return super.update(dto);
    }

    @Override
    public boolean delete(BaseDto dto) {
        if (dto instanceof WikiMongoDeleteDto deleteDto){
            return wikiMongoService.deleteById(deleteDto.getId());
        }
        return super.delete(dto);
    }
}
