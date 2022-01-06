package com.tourem.controller;

import com.tourem.dto.ArticleDto;
import com.tourem.service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController extends AbstractTouremController<ArticleDto> {
	protected ArticleController(ArticleService service) {
		super(service);
	}
}
