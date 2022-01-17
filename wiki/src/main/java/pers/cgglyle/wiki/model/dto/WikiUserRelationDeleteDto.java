package pers.cgglyle.wiki.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pers.cgglyle.common.base.model.BaseDeleteDto;

/**
 * 用户与wiki之间的关系(WikiUserRelation)删除请求模型
 *
 * @author cgglyle
 * @since 2022-01-14 14:57:30
 */

@Schema(description = "WikiUserRelation删除请求模型")
public class WikiUserRelationDeleteDto extends BaseDeleteDto {

}

