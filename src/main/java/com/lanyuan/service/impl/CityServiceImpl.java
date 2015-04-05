package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.City;
import com.lanyuan.mapper.CityMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.CityService;

@Transactional
@Service("cityService")
public class CityServiceImpl implements CityService {
	@Autowired
	private CityMapper cityMapper;

	public PageView query(PageView pageView, City city) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", city);
		List<City> list = cityMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<City> queryAll(City c) {
		// TODO Auto-generated method stub
		return cityMapper.queryAll(c);
	}

	public void delete(String id) throws Exception {
		cityMapper.delete(id);
	}

	public void update(City c) throws Exception {
		cityMapper.update(c);
	}

	public City getById(String id) {
		return cityMapper.getById(id);
	}

	
	public void add(City c) throws Exception {
		cityMapper.add(c);
	}
	
	public City isExist(int cityId) {
		return cityMapper.isExist(cityId);
	}

	
	public City countCity(City c) {
		return cityMapper.countCity(c);
	}
}
