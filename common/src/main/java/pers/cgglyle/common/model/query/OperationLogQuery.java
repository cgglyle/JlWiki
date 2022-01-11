package pers.cgglyle.common.model.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseQuery;

import java.time.LocalDateTime;

/**
 * 日志请求
 *
 * @author cgglyle
 * @date 2021-12-15 13:50
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OperationLogQuery extends BaseQuery {

    /**
     * 用户名称
     */
    @ApiModelProperty("用户id")
    private String userName;

    /**
     * 操作模块
     */
    @ApiModelProperty("操作模块")
    private String operationModule;

    /**
     * 请求地址
     */
    @ApiModelProperty("请求地址")
    private String requestAddress;

    /**
     * 请求方式(GET,POST,PUT,DELETE)
     */
    @ApiModelProperty("请求方式(GET,POST,PUT,DELETE)")
    private String requestMethod;


    /**
     * 状态（1-成功，0-失败）
     */
    @ApiModelProperty("状态（1-成功，0-失败）")
    private boolean isStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;


}
