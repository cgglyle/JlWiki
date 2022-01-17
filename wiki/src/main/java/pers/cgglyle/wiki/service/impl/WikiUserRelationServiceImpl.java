package pers.cgglyle.wiki.service.impl;

import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.wiki.mapper.WikiUserRelationMapper;
import pers.cgglyle.wiki.model.entity.WikiUserRelationEntity;
import pers.cgglyle.wiki.service.WikiUserRelationService;

/**
 * 用户与wiki之间的关系(WikiUserRelation)表服务实现类
 *
 * @author cgglyle
 * @since 2022-01-14 14:57:30
 */
@Service("wikiUserRelationService")
public class WikiUserRelationServiceImpl extends BaseServiceImpl<WikiUserRelationMapper, WikiUserRelationEntity> implements WikiUserRelationService {

}
