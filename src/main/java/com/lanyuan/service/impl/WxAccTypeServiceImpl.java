package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.WxAccType;
import com.lanyuan.mapper.WxAccTypeMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.WxAccTypeService;

@Transactional
@Service("wxAccTypeService")
public class WxAccTypeServiceImpl implements WxAccTypeService {
	@Autowired
	private WxAccTypeMapper wxAccTypeMapper;

	public PageView query(PageView pageView, WxAccType wxAccType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", wxAccType);
		List<WxAccType> list = wxAccTypeMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	
	public PageView queryNoMatch(WxAccType wxAccType,PageView pageView) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", wxAccType);
		List<WxAccType> list = wxAccTypeMapper.queryNoMatch(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<WxAccType> queryAll(WxAccType t) {
		return wxAccTypeMapper.queryAll(t);
	}

	public void delete(String id) throws Exception {
		wxAccTypeMapper.delete(id);
	}

	public void update(WxAccType t) throws Exception {
		wxAccTypeMapper.update(t);
	}
	
	public void add(WxAccType t) throws Exception {
		wxAccTypeMapper.add(t);
	}

	
	public WxAccType querySingleType(String wxTypeSN) {
		return wxAccTypeMapper.querySingleType(wxTypeSN);
	}
	
	public WxAccType countType(WxAccType wxAccType) {
		return wxAccTypeMapper.countType(wxAccType);
	}


	public WxAccType getById(String id) {
		return wxAccTypeMapper.getById(id);
	}


	public WxAccType isExist(String wxTypeSN) {
		return wxAccTypeMapper.isExist(wxTypeSN);
	}
}
