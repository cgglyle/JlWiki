package pers.cgglyle.wiki.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseEntity;

/**
 * 用户与wiki之间的关系(WikiUserRelation)实体类
 *
 * @author cgglyle
 * @since 2022-01-14 14:57:30
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "WikiUserRelation实体类")
@TableName("wiki_user_relation")
public class WikiUserRelationEntity extends BaseEntity {

    /**
     * wiki在mongodb中的主键id
     */
    @Schema(description = "wiki在mongodb中的主键id")
    @TableField("wiki_id")
    private String wikiId;

    /**
     * wiki标题
     */
    @Schema(description = "wiki标题")
    @TableField("title")
    private String title;

    /**
     * 是否为公开状态（1为公开，0为私密）
     */
    @Schema(description = "是否为公开状态（1为公开，0为私密）")
    @TableField("is_public")
    private boolean isPublic;

    /**
     * wiki当前版本信息
     */
    @Schema(description = "wiki当前版本信息")
    @TableField("wiki_version")
    private Integer wikiVersion;

    /**
     * 最后更新者
     */
    @Schema(description = "最后更新者")
    @TableField("update_user")
    private Integer updateUser;


}

