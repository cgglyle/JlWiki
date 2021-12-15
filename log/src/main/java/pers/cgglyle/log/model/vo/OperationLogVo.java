package pers.cgglyle.log.model.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * @author cgglyle
 * @date 2021-12-15 13:48
 */
public class OperationLogVo {
    @ApiModelProperty("主键")
    private Integer id;

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
     * 请求参数
     */
    @ApiModelProperty("请求参数")
    private JSONObject requestParameter;

    /**
     * 返回结果
     */
    @ApiModelProperty("返回结果")
    private JSONObject returnResult;

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

    /**
     * 请求结束时间
     */
    @ApiModelProperty("请求结束时间")
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

    public JSONObject getRequestParameter() {
        return requestParameter;
    }

    public void setRequestParameter(JSONObject requestParameter) {
        this.requestParameter = requestParameter;
    }

    public JSONObject getReturnResult() {
        return returnResult;
    }

    public void setReturnResult(JSONObject returnResult) {
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
