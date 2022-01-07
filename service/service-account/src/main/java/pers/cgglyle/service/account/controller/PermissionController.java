package pers.cgglyle.service.account.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.cgglyle.common.base.controller.BaseController;
import pers.cgglyle.common.base.model.BaseDeleteDto;
import pers.cgglyle.common.base.model.BaseUpdateDto;
import pers.cgglyle.service.account.model.dto.PermissionAddDto;
import pers.cgglyle.service.account.model.query.PermissionQuery;
import pers.cgglyle.service.account.service.AccountService;

/**
 * @author cgglyle
 * @date 2021-12-29 14:36
 */
@Api(tags = "权限控制")
@CrossOrigin
@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController<AccountService,PermissionQuery,PermissionAddDto, BaseUpdateDto, BaseDeleteDto> {

}
