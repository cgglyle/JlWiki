package pers.cgglyle.wiki.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.cgglyle.common.base.controller.BaseController;
import pers.cgglyle.wiki.model.dto.WikiMongoAddDto;
import pers.cgglyle.wiki.model.dto.WikiMongoDeleteDto;
import pers.cgglyle.wiki.model.dto.WikiMongoUpdateDto;
import pers.cgglyle.wiki.model.query.WikiMongoQuery;
import pers.cgglyle.wiki.service.intf.WikiService;

/**
 * @author cgglyle
 * @date 2022-01-13 11:47
 */
@Tag(name = "wiki控制器", description = "wiki控制器")
@CrossOrigin
@RestController
@RequestMapping("/wiki")
public class WikiController extends BaseController<WikiService, WikiMongoQuery, WikiMongoAddDto, WikiMongoUpdateDto, WikiMongoDeleteDto> {
}
