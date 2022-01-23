package pers.cgglyle.wiki.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * wiki显示模型
 *
 * @author cgglyle
 * @date 2022-01-13 11:41
 */
@Data
public class WikiVo {
    @Schema(description = "wiki标题")
    private String wikiTitle;
    @Schema(description = "wiki本体")
    private Object wiki;
    /**
     * wiki在mongodb中的主键id
     */
    @Schema(description = "wiki在mongodb中的主键id")
    private String wikiId;

    /**
     * wiki标题
     */
    @Schema(description = "wiki标题")
    private String title;

    /**
     * wiki的状态
     */
    @Schema(description = "wiki的状态")
    private String isStatus;

    /**
     * 是否为公开状态（1为公开，0为私密）
     */
    @Schema(description = "是否为公开状态（1为公开，0为私密）")
    private boolean isPublic;

    /**
     * wiki当前版本信息
     */
    @Schema(description = "wiki当前版本信息")
    private Integer wikiVersion;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private Date updateTime;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private Integer createUser;

    /**
     * 最后更新者
     */
    @Schema(description = "最后更新者")
    private Integer updateUser;
}
