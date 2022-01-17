package pers.cgglyle.common.model.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 日志请求
 *
 * @author cgglyle
 * @date 2021-12-15 13:50
 */
@Data
public class OperationLogQuery {

    private int pageNum = 1;
    private int pageSize = 20;
    /**
     * 用户名称
     */
    @Schema(description = "用户id")
    private String userName;

    /**
     * 操作模块
     */
    @Schema(description = "操作模块")
    private String operationModule;

    /**
     * 请求地址
     */
    @Schema(description = "请求地址")
    private String requestAddress;

    /**
     * 请求方式(GET,POST,PUT,DELETE)
     */
    @Schema(description = "请求方式(GET,POST,PUT,DELETE)")
    private String requestMethod;


    /**
     * 状态（1-成功，0-失败）
     */
    @Schema(description = "状态（1-成功，0-失败）")
    private boolean isStatus;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createTime;


}
