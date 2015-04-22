package com.lanyuan.service;

import com.lanyuan.base.BaseService;
import com.lanyuan.entity.Advertisement;
import com.lanyuan.entity.City;

public interface AdvertisementService extends BaseService<Advertisement>{
	public int count(Advertisement advertisement);
	
	public Advertisement isExist(int Id); 
}
