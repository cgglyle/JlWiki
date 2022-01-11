package pers.cgglyle.common.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 操作日志表(OperationLog)实体类
 *
 * @author cgglyle
 * @since 2021-12-14 10:59:27
 */

@ApiModel("OperationLog实体类")
@TableName("operation_log")
public class OperationLogEntity {


    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称
     */
    @ApiModelProperty("用户id")
    @TableField("user_name")
    private String userName;

    /**
     * 操作模块
     */
    @ApiModelProperty("操作模块")
    @TableField("operation_module")
    private String operationModule;

    /**
     * 请求地址
     */
    @ApiModelProperty("请求地址")
    @TableField("request_address")
    private String requestAddress;

    /**
     * 请求方式(GET,POST,PUT,DELETE)
     */
    @ApiModelProperty("请求方式(GET,POST,PUT,DELETE)")
    @TableField("request_method")
    private String requestMethod;

    /**
     * 请求参数
     */
    @ApiModelProperty("请求参数")
    @TableField("request_parameter")
    private String requestParameter;

    /**
     * 返回结果
     */
    @ApiModelProperty("返回结果")
    @TableField("return_result")
    private String returnResult;

    /**
     * 状态（1-成功，0-失败）
     */
    @ApiModelProperty("状态（1-成功，0-失败）")
    @TableField("is_status")
    private boolean isStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 请求结束时间
     */
    @ApiModelProperty("请求结束时间")
    @TableField("query_end_time")
    private Long queryEndTime;
}

