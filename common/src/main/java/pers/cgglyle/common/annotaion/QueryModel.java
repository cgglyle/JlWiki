package pers.cgglyle.common.annotaion;

import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.enums.QueryModelEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 查询模式注解
 * <p>控制{@link pers.cgglyle.common.base.service.IBaseService#get(BaseQuery)}
 * 方法的查询方式。
 * <p>其中查询方式方式主要有
 * <ul>
 *     <li>{@code EQ} 精确相等
 *     <li>{@code LIKE} 模糊查询
 * </ul>
 *
 * @author cgglyle
 * @date 2022-01-08 22:30
 * @see pers.cgglyle.common.base.service.IBaseService#get(BaseQuery)
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryModel {
    /**
     * 查询方式控制
     */
    QueryModelEnum value() default QueryModelEnum.LIKE;
}
