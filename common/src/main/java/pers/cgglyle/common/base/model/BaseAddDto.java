package pers.cgglyle.common.base.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础添加数据模型
 *
 * @author cgglyle
 * @date 2022-01-04 09:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseAddDto extends BaseDto {
    @ApiModelProperty("创建者")
    private Integer createUser;
}
