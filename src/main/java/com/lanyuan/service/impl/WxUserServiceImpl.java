package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.WxUser;
import com.lanyuan.mapper.WxUserMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.WxUserService;

@Transactional
@Service("wxUserService")
public class WxUserServiceImpl implements WxUserService {
	@Autowired
	private WxUserMapper wxUserMapper;

	public PageView query(PageView pageView, WxUser wxUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", wxUser);
		List<WxUser> list = wxUserMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<WxUser> queryAll(WxUser t) {
		return wxUserMapper.queryAll(t);
	}

	public void delete(String id) throws Exception {
		wxUserMapper.delete(id);
	}

	public void update(WxUser t) throws Exception {
		wxUserMapper.update(t);
	}
	
	public void add(WxUser t) throws Exception {
		wxUserMapper.add(t);
	}

	public WxUser getById(String id) {
		return wxUserMapper.getById(id);
	}
}
