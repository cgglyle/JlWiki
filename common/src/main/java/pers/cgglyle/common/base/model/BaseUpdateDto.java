package pers.cgglyle.common.base.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础更新模型
 *
 * @author cgglyle
 * @date 2022-01-04 09:51
 */
@Data
@Schema(description = "基础更新模型")
@EqualsAndHashCode(callSuper = true)
public class BaseUpdateDto extends BaseDto {
}
