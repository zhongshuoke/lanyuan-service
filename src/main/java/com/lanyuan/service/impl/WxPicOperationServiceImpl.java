package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.WxPicOperation;
import com.lanyuan.mapper.WxPicOperationMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.WxPicOperationService;

@Transactional
@Service("WxPicOperationService")
public class WxPicOperationServiceImpl implements WxPicOperationService {
	@Autowired
	private WxPicOperationMapper wxPicOperationMapper;

	public PageView query(PageView pageView, WxPicOperation wxPicOperation) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", wxPicOperation);
		List<WxPicOperation> list = wxPicOperationMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<WxPicOperation> queryAll(WxPicOperation t) {
		return wxPicOperationMapper.queryAll(t);
	}

	public void delete(String id) throws Exception {
		wxPicOperationMapper.delete(id);
	}

	public void update(WxPicOperation t) throws Exception {
		wxPicOperationMapper.update(t);
	}
	
	public void add(WxPicOperation t) throws Exception {
		wxPicOperationMapper.add(t);
	}

	public WxPicOperation getById(String id) {
		return wxPicOperationMapper.getById(id);
	}
}
