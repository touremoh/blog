package com.tourem.controller;

import com.tourem.dto.UserRoleDto;
import com.tourem.service.UserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class UserRoleController extends AbstractTouremController<UserRoleDto> {
	protected UserRoleController(UserRoleService service) {
		super(service);
	}
}
