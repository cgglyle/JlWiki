package pers.cgglyle.authenticate.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.cgglyle.common.base.controller.BaseController;
import pers.cgglyle.common.base.model.BaseDeleteDto;
import pers.cgglyle.common.base.model.BaseUpdateDto;
import pers.cgglyle.authenticate.model.dto.PermissionAddDto;
import pers.cgglyle.authenticate.model.query.PermissionQuery;
import pers.cgglyle.authenticate.service.AccountService;

/**
 * @author cgglyle
 * @date 2021-12-29 14:36
 */
@Tag(name = "权限控制")
@CrossOrigin
@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController<AccountService,PermissionQuery,PermissionAddDto, BaseUpdateDto, BaseDeleteDto> {

}
