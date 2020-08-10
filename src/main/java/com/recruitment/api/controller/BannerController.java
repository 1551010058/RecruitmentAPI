package com.recruitment.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.api.constant.ApiURL;
import com.recruitment.api.entities.Banner;
import com.recruitment.api.service.BannerService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/banner")
@Api(tags = { ApiURL.BANNER })
public class BannerController {

	@Autowired
	private BannerService bannerService;
	
	@GetMapping("/{bannerID}")
	public ResponseEntity<Object> Get(@PathVariable("bannerID") int bannerID){
		return ResponseEntity.ok(bannerService.GetBanner(bannerID));
	}
	
	@GetMapping("/Search")
	public ResponseEntity<Object> Search(String keyword, int position,
			int currentPage, int recordPerpage)
	{
		return ResponseEntity.ok(bannerService.GetBannerList(keyword, position, currentPage, recordPerpage));
	}
	
	@DeleteMapping("/{bannerID}")
	public ResponseEntity<Object> Delete(@PathVariable("bannerID") int bannerID){
		return ResponseEntity.ok(bannerService.DeleteBanner(bannerID));
	}
	
	@PostMapping()
	public ResponseEntity<Object> Update(@Valid @RequestBody Banner banner){
		Object res = banner.getBannerID() > 0 ? bannerService.UpdateBanner(banner) : bannerService.AddBanner(banner);
		return ResponseEntity.ok(res);
	}
}
