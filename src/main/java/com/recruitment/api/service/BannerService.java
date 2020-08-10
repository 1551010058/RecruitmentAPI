package com.recruitment.api.service;

import java.util.List;

import com.recruitment.api.entities.Banner;

public interface BannerService {

	List<Banner> GetBannerList(String keyword, int position, int currentPage, int recordPerpage);
	
    Banner GetBanner(int bannerID);
    
    Banner AddBanner(Banner banner);
    
    Banner UpdateBanner(Banner banner);
    
    int DeleteBanner(int bannerID);
}
