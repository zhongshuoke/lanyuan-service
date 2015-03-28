package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.WxSchedule;
import com.lanyuan.mapper.WxScheduleMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.WxScheduleService;

@Transactional
@Service("wxScheduleService")
public class WxScheduleServiceImpl implements WxScheduleService {
	@Autowired
	private WxScheduleMapper wxScheduleMapper;

	public PageView query(PageView pageView, WxSchedule wxSchedule) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", wxSchedule);
		List<WxSchedule> list = wxScheduleMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	
	public PageView queryNoMatch(WxSchedule WxSchedule,PageView pageView) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", WxSchedule);
		List<WxSchedule> list = wxScheduleMapper.queryNoMatch(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<WxSchedule> queryAll(WxSchedule t) {
		return wxScheduleMapper.queryAll(t);
	}

	public void delete(String id) throws Exception {
		wxScheduleMapper.delete(id);
	}

	public void update(WxSchedule t) throws Exception {
		wxScheduleMapper.update(t);
	}
	
	public void add(WxSchedule t) throws Exception {
		wxScheduleMapper.add(t);
	}

	
	public WxSchedule querySingleSchedule(String hour) {
		return wxScheduleMapper.querySingleSchedule(hour);
	}
	
	public WxSchedule countSchedule(WxSchedule wxSchedule) {
		return wxScheduleMapper.countSchedule(wxSchedule);
	}


	public WxSchedule getById(String id) {
		return wxScheduleMapper.getById(id);
	}


	public WxSchedule isExist(String hour) {
		return wxScheduleMapper.isExist(hour);
	}

}
