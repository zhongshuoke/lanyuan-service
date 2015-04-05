package com.lanyuan.service;

import java.util.List;

import com.lanyuan.base.BaseService;
import com.lanyuan.entity.WxArticle;
import com.lanyuan.entity.WxRecommendToday;
import com.lanyuan.pulgin.mybatis.plugin.PageView;



public interface WxRecommendTodayService extends BaseService<WxRecommendToday>{
	public WxRecommendToday querySingleRecommArticle(int id);
	public WxRecommendToday isExist(int id);
	/**
	 * 查询推荐文章数量
	 * @author caokun
	 * date：2015-1-25
	 * @param WxRecommendToday wxRecommendToday
	 * @return
	 */
	public WxRecommendToday countRecommArticle(WxRecommendToday wxRecommendToday);
	
	/**
	 * @param wxArticle
	 * @param pageView
	 * @return
	 */
	public PageView queryNoMatch(WxRecommendToday wxRecommendToday,PageView pageView);
	
	public List<WxRecommendToday> queryLastestRecommArticle(String class_id, String keyword, int limit);
	
	public List<WxRecommendToday> queryMoreRecommArticle(Long max_article_id, int offset, int limit, String class_id, String keyword);
}
