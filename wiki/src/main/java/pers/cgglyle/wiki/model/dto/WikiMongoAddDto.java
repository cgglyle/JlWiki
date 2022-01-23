package pers.cgglyle.wiki.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseAddDto;

/**
 * @author cgglyle
 * @date 2022-01-13 11:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WikiMongoAddDto extends BaseAddDto {
    /**
     * wiki本体
     */
    @Schema(description = "wiki本体")
    private Object wiki;

    @Schema(description = "集合名")
    private String collection;

    /**
     * wiki标题
     */
    @Schema(description = "wiki标题")
    private String title;

    /**
     * 是否为公开状态（1为公开，0为私密）
     */
    @Schema(description = "是否为公开状态（1为公开，0为私密）")
    private boolean isPublic;

    /**
     * 最后更新者
     */
    @Schema(description = "最后更新者")
    private Integer updateUser;
}
