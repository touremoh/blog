package com.tourem.controller;

import com.tourem.dto.ImageUrlDto;
import com.tourem.service.ImageUrlService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class ImageController extends AbstractTouremController<ImageUrlDto> {
	protected ImageController(ImageUrlService service) {
		super(service);
	}
}
