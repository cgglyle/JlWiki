package pers.cgglyle.log.model.query;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.base.model.BaseQuery;

import java.time.LocalDateTime;

/**
 * @author cgglyle
 * @date 2021-12-15 13:50
 */
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
}
