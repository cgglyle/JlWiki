package pers.cgglyle.service.account.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.cgglyle.common.base.controller.BaseController;
import pers.cgglyle.common.base.model.BaseDeleteDto;
import pers.cgglyle.service.account.model.dto.GroupAddDto;
import pers.cgglyle.service.account.model.dto.GroupUpdateDto;
import pers.cgglyle.service.account.model.query.GroupQuery;
import pers.cgglyle.service.account.service.AccountService;

/**
 * 用户组控制层
 *
 * @author cgglyle
 * @date 2021-12-10 10:01
 */
@Api(tags = "用户组控制")
@CrossOrigin
@RestController
@RequestMapping("/group")
public class GroupController extends BaseController<AccountService,GroupQuery,GroupAddDto,GroupUpdateDto, BaseDeleteDto> {

}
