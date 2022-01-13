package pers.cgglyle.wiki.model.dto;

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
    private Object wiki;
    private String collection;
}
