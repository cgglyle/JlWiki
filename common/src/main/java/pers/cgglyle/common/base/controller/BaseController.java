package pers.cgglyle.common.base.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.cgglyle.common.annotaion.OperationLog;
import pers.cgglyle.common.base.model.BaseAddDto;
import pers.cgglyle.common.base.model.BaseDeleteDto;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.model.BaseUpdateDto;
import pers.cgglyle.common.base.service.IBaseRelationService;
import pers.cgglyle.common.response.PageResult;

/**
 * 基础控制器
 *
 * <p>此控制器是基础控制器，默认实现以下功能
 * <ul>
 *     <li>{@code get}获取一个分页
 *     <li>{@code add}添加一个数据
 *     <li>{@code update}更新一个数据
 *     <li>{@code delete}删除一个数据
 *     <li>{@code batchDelete}批量删除数据
 * </ul>
 *
 * <h2>注意！</h2>
 * <p>在继承此类的时候要注意泛型：{@code T}综合处理类, {@code BQ}请求模型,
 * {@code BA}添加模型, {@code BU}升级模型, {@code BD}删除模型
 * <p>如果不想使用其中的某一个功能，请将相应的泛型填写成基础类型，
 * 而且需要注意综合处理类中不允许处理基础类型的请求。
 * <p><pre>例如：
 * {@code
 *     @Override
 *     public boolean update(BaseDto dto) {
 *         if (dto instanceof RoleUpdateDto roleUpdateDto) {
 *             RoleEntity roleEntity = new RoleEntity();
 *             BeanUtils.copyProperties(roleUpdateDto, roleEntity);
 *             return roleService.update(roleEntity);
 *         }
 *         if (dto instanceof UserUpdateDto userUpdateDto) {
 *             UserEntity userEntity = new UserEntity();
 *             BeanUtils.copyProperties(userUpdateDto, userEntity);
 *             return userService.update(userEntity);
 *         }
 *         // 在最后需要直接抛出异常
 *         throw new ApiException("未支持的请求");
 *     }
 * }</pre></p>
 * <p>并且提供基础调用的服务{@code baseRelationService}
 *
 * @author cgglyle
 * @date 2022-01-06 15:05
 */
@Slf4j
@RestController
public abstract class BaseController<T extends IBaseRelationService, BQ extends BaseQuery,
        BA extends BaseAddDto, BU extends BaseUpdateDto, BD extends BaseDeleteDto> {
    @Autowired
    protected T baseRelationService;

    /**
     * 获取分页信息
     *
     * @param query 请求模型
     * @return 分页模型
     */
    @Operation(summary = "获取分页", description = "根据请求信息获取分页")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "1000", description = "请求成功"),
            @ApiResponse(responseCode = "1020", description = "系统内部错误")
    })
    @GetMapping("get")
    public PageResult get(BQ query) throws IllegalAccessException {
        log.info("获取分页");
        return baseRelationService.get(query);
    }

    /**
     * 添加一个数据
     *
     * @param dto 添加模型
     * @return 成功失败
     */
    @OperationLog(operationMethod = "POST")
    @Operation(summary = "添加数据")
    @PostMapping("add")
    public boolean add(@RequestBody  BA dto) {
        log.info("添加数据");
        return baseRelationService.add(dto);
    }

    /**
     * 更新一个数据
     *
     * @param dto 更新模型
     * @return 成功失败
     */
    @OperationLog(operationMethod = "PUT")
    @Operation(summary = "更新数据")
    @PutMapping("update")
    public boolean update(@RequestBody BU dto) {
        log.info("更新数据");
        return baseRelationService.update(dto);
    }

    /**
     * 删除一个数据
     *
     * @param dto 删除模型
     * @return 成功失败
     */
    @OperationLog(operationMethod = "DELETE")
    @Operation(summary = "删除数据")
    @DeleteMapping("delete")
    public boolean delete(@RequestBody BD dto) {
        log.info("删除数据");
        return baseRelationService.delete(dto);
    }

    /**
     * 批量删除
     *
     * @param dto 删除模型
     * @return 成功失败
     */
    @OperationLog(operationMethod = "DELETE")
    @Operation(summary = "批量删除数据")
    @DeleteMapping("batchDelete")
    public boolean batchDelete(@RequestBody BD dto) {
        log.info("批量删除数据");
        return baseRelationService.batchDelete(dto);
    }
}
