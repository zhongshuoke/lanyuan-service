package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.WxAccount;
import com.lanyuan.mapper.WxAccountMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.WxAccountService;

@Transactional
@Service("wxAccountService")
public class WxAccountServiceImpl implements WxAccountService {
	@Autowired
	private WxAccountMapper wxAccountMapper;

	public PageView query(PageView pageView, WxAccount account) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", account);
		List<WxAccount> list = wxAccountMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	
	public PageView queryNoMatch(WxAccount account,PageView pageView) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", account);
		List<WxAccount> list = wxAccountMapper.queryNoMatch(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<WxAccount> queryAll(WxAccount t) {
		// TODO Auto-generated method stub
		return wxAccountMapper.queryAll(t);
	}

	public void delete(String id) throws Exception {
		wxAccountMapper.delete(id);
	}

	public void update(WxAccount t) throws Exception {
		wxAccountMapper.update(t);
	}

	public WxAccount getById(String id) {
		return wxAccountMapper.getById(id);
	}

	
	public void add(WxAccount t) throws Exception {
		wxAccountMapper.add(t);
	}

	
	public WxAccount querySingleAccount(String wxAccountName) {
		return wxAccountMapper.querySingleAccount(wxAccountName);
	}

	
	public WxAccount isExist(String wxAccountName) {
		return wxAccountMapper.isExist(wxAccountName);
	}

	
	public WxAccount countAccount(WxAccount account) {
		return wxAccountMapper.countAccount(account);
	}


	public void addwxinfo(WxAccount wxAccount) {
		wxAccountMapper.addwxinfo(wxAccount);
	}
}
