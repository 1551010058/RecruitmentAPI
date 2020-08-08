package com.recruitment.api.service;

import java.util.List;

import com.recruitment.api.entities.Banner;

public interface BannerService {

	List<Banner> GetBannerList(String keyword, int position, int currentPage, int recordPerpage);
	
    Banner GetBanner(int bannerID);
    
    int DeleteBanner(int bannerID);
}
