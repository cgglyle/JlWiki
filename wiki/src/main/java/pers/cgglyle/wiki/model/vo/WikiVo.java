package pers.cgglyle.wiki.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

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
}
