package com.lanyuan.service;

import java.util.List;

import com.lanyuan.base.BaseService;
import com.lanyuan.entity.City;
import com.lanyuan.entity.WxAccType;
import com.lanyuan.pulgin.mybatis.plugin.PageView;



public interface CityService extends BaseService<City>{
	
	public City isExist(int cityId);

	public City countCity(City city);
	
	public List<City> queryCityList(int offset, int limit);
	
}
