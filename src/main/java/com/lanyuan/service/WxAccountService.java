package com.lanyuan.service;

import com.lanyuan.base.BaseService;
import com.lanyuan.entity.WxAccount;
import com.lanyuan.pulgin.mybatis.plugin.PageView;



public interface WxAccountService extends BaseService<WxAccount>{
	public WxAccount querySingleAccount(String wxAccountName);
	public WxAccount isExist(String wxAccountName);
	/**
	 * 验证用户登陆
	 * @author caokun
	 * date：2015-1-25
	 * @param WxAccount account
	 * @return
	 */
	public WxAccount countAccount(WxAccount account);
	
	public void addwxinfo(WxAccount wxAccount);
	
	/**
	 * @param account
	 * @param pageView
	 * @return
	 */
	public PageView queryNoMatch(WxAccount account,PageView pageView);
}
