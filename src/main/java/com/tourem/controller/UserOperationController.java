package com.tourem.controller;

import com.tourem.dto.UserOperationDto;
import com.tourem.service.UserOperationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operations")
public class UserOperationController extends AbstractTouremController<UserOperationDto> {
	protected UserOperationController(UserOperationService service) {
		super(service);
	}
}
