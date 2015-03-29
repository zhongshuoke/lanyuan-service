package com.lanyuan.service;

import com.lanyuan.base.BaseService;
import com.lanyuan.entity.Advertisement;

public interface AdvertisementService extends BaseService<Advertisement>{
	public int count(Advertisement advertisement);
}
