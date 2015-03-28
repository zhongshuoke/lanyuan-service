package com.lanyuan.service;

import com.lanyuan.base.BaseService;
import com.lanyuan.entity.WxUser;
import com.lanyuan.pulgin.mybatis.plugin.PageView;


/**
 * 众说客注册用户接口
 * @author caokun
 *
 */
public interface WxUserService extends BaseService<WxUser>{
	public WxUser querySingleUser(String name);
	public WxUser isExist(int id);

	public WxUser countUser(WxUser wxUser);
	
	/**
	 * @param wxSchedule
	 * @param pageView
	 * @return
	 */
	public PageView queryNoMatch(WxUser wxUser,PageView pageView);
}
