package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.WxTask;
import com.lanyuan.mapper.WxTaskMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.WxTaskService;

@Transactional
@Service("wxTaskService")
public class WxTaskServiceImpl implements WxTaskService {
	@Autowired
	private WxTaskMapper wxTaskMapper;

	public PageView query(PageView pageView, WxTask wxSchedule) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", wxSchedule);
		List<WxTask> list = wxTaskMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	
	public PageView queryNoMatch(WxTask WxTask,PageView pageView) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", WxTask);
		List<WxTask> list = wxTaskMapper.queryNoMatch(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<WxTask> queryAll(WxTask t) {
		return wxTaskMapper.queryAll(t);
	}

	public void delete(String id) throws Exception {
		wxTaskMapper.delete(id);
	}

	public void update(WxTask t) throws Exception {
		wxTaskMapper.update(t);
	}
	
	public void add(WxTask t) throws Exception {
		wxTaskMapper.add(t);
	}

	
	public WxTask querySingleTask(String name) {
		return wxTaskMapper.querySingleTask(name);
	}
	
	public WxTask countTask(WxTask wxSchedule) {
		return wxTaskMapper.countTask(wxSchedule);
	}


	public WxTask getById(String id) {
		return wxTaskMapper.getById(id);
	}


	public WxTask isExist(int crontab_id) {
		return wxTaskMapper.isExist(crontab_id);
	}


	public void updateTasks() {
		wxTaskMapper.updateTasks();
	}


}
