package pers.cgglyle.common.base.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 基础删除数据模型
 *
 * @author cgglyle
 * @date 2022-01-04 10:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseDeleteDto extends BaseDto {
    @ApiModelProperty("删除id")
    private Serializable id;
    @ApiModelProperty("删除id列表")
    private List<Serializable> idList;
}
