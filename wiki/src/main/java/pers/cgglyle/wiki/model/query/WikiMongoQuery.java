package pers.cgglyle.wiki.model.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseQuery;

/**
 * @author cgglyle
 * @date 2022-01-13 11:51
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WikiMongoQuery extends BaseQuery {
    private String collection;
}
