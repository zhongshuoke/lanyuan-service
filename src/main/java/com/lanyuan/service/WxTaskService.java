package com.lanyuan.service;

import com.lanyuan.base.BaseService;
import com.lanyuan.entity.WxTask;
import com.lanyuan.pulgin.mybatis.plugin.PageView;


/**
 * 微信抓取任务接口
 * @author caokun
 *
 */
public interface WxTaskService extends BaseService<WxTask>{
	public WxTask querySingleTask(String name);
	public WxTask isExist(int crontab_id);

	public WxTask countTask(WxTask wxTask);
	
	/**
	 * 作用在于触发任务的执行
	 * last_update
	 */
	public void updateTasks();
	
	/**
	 * @param wxSchedule
	 * @param pageView
	 * @return
	 */
	public PageView queryNoMatch(WxTask wxTask,PageView pageView);
}
