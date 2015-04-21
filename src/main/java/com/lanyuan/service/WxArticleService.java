package com.lanyuan.service;

import java.util.List;

import com.lanyuan.base.BaseService;
import com.lanyuan.entity.WxArticle;
import com.lanyuan.pulgin.mybatis.plugin.PageView;



public interface WxArticleService extends BaseService<WxArticle>{
	public WxArticle querySingleArticle(String title);
	public WxArticle isExist(String title);
	/**
	 * 验证用户登陆
	 * @author caokun
	 * date：2015-1-25
	 * @param WxArticle wxArticle
	 * @return
	 */
	public WxArticle countArticle(WxArticle wxArticle);
	
	public void recomm(String id);
	
	/**
	 * @param wxArticle
	 * @param pageView
	 * @return
	 */
	public PageView queryNoMatch(WxArticle wxArticle,PageView pageView);
	
	public List<WxArticle> queryLastestWxArticle(String class_id, String keyword, int limit);
	
	public List<WxArticle> queryMoreWxArticle(Long max_article_id, int offset, int limit, String class_id, String keyword);
}
