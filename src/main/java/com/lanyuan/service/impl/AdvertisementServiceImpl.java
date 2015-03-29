package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.Advertisement;
import com.lanyuan.mapper.AdvertisementMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.AdvertisementService;

@Transactional
@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {
	@Autowired
	private AdvertisementMapper advertisementMapper;

	public PageView query(PageView pageView, Advertisement advertisement) { 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", advertisement);
		List<Advertisement> list = advertisementMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<Advertisement> queryAll(Advertisement t) {
		return advertisementMapper.queryAll(t);
	}

	public void delete(String id) throws Exception {
		advertisementMapper.delete(id);
	}

	public void update(Advertisement t) throws Exception {
		advertisementMapper.update(t);
	}

	public Advertisement getById(String id) {
		return advertisementMapper.getById(id);
	}
	
	public void add(Advertisement t) throws Exception {
		advertisementMapper.add(t);
	}

	public int count(Advertisement advertisement) {
		return advertisementMapper.count(advertisement);
	}
}
