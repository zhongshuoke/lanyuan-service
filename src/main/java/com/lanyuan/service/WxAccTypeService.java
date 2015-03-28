package com.lanyuan.service;

import com.lanyuan.base.BaseService;
import com.lanyuan.entity.WxAccType;
import com.lanyuan.pulgin.mybatis.plugin.PageView;



public interface WxAccTypeService extends BaseService<WxAccType>{
	
	public WxAccType querySingleType(String wxTypeSN);
	
	public WxAccType isExist(String wxTypeSN);

	public WxAccType countType(WxAccType wxAccType);
	
	/**
	 * @param wxAccType
	 * @param pageView
	 * @return
	 */
	public PageView queryNoMatch(WxAccType wxAccType,PageView pageView);
}
