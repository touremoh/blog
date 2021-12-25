package com.tourem.controller;

import com.tourem.dto.AuthorDto;
import com.tourem.service.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController extends AbstractTouremController<AuthorDto> {
	protected AuthorController(AuthorService service) {
		super(service);
	}
}
