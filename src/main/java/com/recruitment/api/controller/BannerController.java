package com.recruitment.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.api.constant.ApiURL;
import com.recruitment.api.constant.ResultJson;
import com.recruitment.api.service.BannerService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/banner/")
@Api(tags = { ApiURL.BANNER })
public class BannerController {

	@Autowired
	private BannerService bannerService;
	
	@GetMapping("Search")
	public ResponseEntity<Object> Search(String keyword, int position,
			int currentPage, int recordPerpage) {
		return ResponseEntity.ok(bannerService.GetBannerList(keyword, position, currentPage, recordPerpage));
	}
}