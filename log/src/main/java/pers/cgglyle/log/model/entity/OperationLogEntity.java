package pers.cgglyle.log.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperationModule() {
        return operationModule;
    }

    public void setOperationModule(String operationModule) {
        this.operationModule = operationModule;
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestParameter() {
        return requestParameter;
    }

    public void setRequestParameter(String requestParameter) {
        this.requestParameter = requestParameter;
    }

    public String getReturnResult() {
        return returnResult;
    }

    public void setReturnResult(String returnResult) {
        this.returnResult = returnResult;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(Long queryEndTime) {
        this.queryEndTime = queryEndTime;
    }
}

