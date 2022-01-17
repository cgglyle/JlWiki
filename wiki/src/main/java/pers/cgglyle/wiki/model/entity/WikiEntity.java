package pers.cgglyle.wiki.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * wiki实体
 *
 * @author cgglyle
 * @date 2022-01-13 11:40
 */
@Data
public class WikiEntity {
    @Schema(description = "wikiId")
    private String id;
    @Schema(description = "wiki本体")
    private Object wiki;
}
