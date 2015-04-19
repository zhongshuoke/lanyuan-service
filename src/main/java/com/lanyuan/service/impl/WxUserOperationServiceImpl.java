package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.WxUserOperation;
import com.lanyuan.mapper.WxUserOperationMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.WxUserOperationService;

@Transactional
@Service("wxUserOperationService")
public class WxUserOperationServiceImpl implements WxUserOperationService {
	@Autowired
	private WxUserOperationMapper wxUserOperationMapper;

	public PageView query(PageView pageView, WxUserOperation wxUserOperation) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", wxUserOperation);
		List<WxUserOperation> list = wxUserOperationMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<WxUserOperation> queryAll(WxUserOperation t) {
		return wxUserOperationMapper.queryAll(t);
	}

	public void delete(String id) throws Exception {
		wxUserOperationMapper.delete(id);
	}

	public void update(WxUserOperation t) throws Exception {
		wxUserOperationMapper.update(t);
	}
	
	public void add(WxUserOperation t) throws Exception {
		wxUserOperationMapper.add(t);
	}

	public WxUserOperation getById(String id) {
		return wxUserOperationMapper.getById(id);
	}
}
