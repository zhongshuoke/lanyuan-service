package com.lanyuan.service;

import com.lanyuan.base.BaseService;
import com.lanyuan.entity.WxSchedule;
import com.lanyuan.pulgin.mybatis.plugin.PageView;


/**
 * 微信抓取计划接口
 * @author caokun
 *
 */
public interface WxScheduleService extends BaseService<WxSchedule>{
	public WxSchedule querySingleSchedule(String hour);
	public WxSchedule isExist(String hour);

	public WxSchedule countSchedule(WxSchedule wxSchedule);
	
	/**
	 * @param wxSchedule
	 * @param pageView
	 * @return
	 */
	public PageView queryNoMatch(WxSchedule wxSchedule,PageView pageView);
}
