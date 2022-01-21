package pers.cgglyle.authenticate.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.cgglyle.authenticate.model.dto.GroupAddDto;
import pers.cgglyle.authenticate.model.dto.GroupUpdateDto;
import pers.cgglyle.authenticate.model.query.GroupQuery;
import pers.cgglyle.authenticate.service.intf.AccountService;
import pers.cgglyle.common.base.controller.BaseController;
import pers.cgglyle.common.base.model.BaseDeleteDto;

/**
 * 用户组控制层
 *
 * @author cgglyle
 * @date 2021-12-10 10:01
 */
@Tag(name = "用户组控制")
@CrossOrigin
@RestController
@RequestMapping("/group")
public class GroupController extends BaseController<AccountService, GroupQuery, GroupAddDto, GroupUpdateDto, BaseDeleteDto> {

}
