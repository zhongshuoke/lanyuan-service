package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.WxRecommendToday;
import com.lanyuan.mapper.WxRecommendTodayMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.WxRecommendTodayService;

@Transactional
@Service("wxRecommendTodayService")
public class WxRecommendTodayServiceImpl implements WxRecommendTodayService {
	@Autowired
	private WxRecommendTodayMapper wxRecommendTodayMapper;

	public PageView query(PageView pageView, WxRecommendToday wxRecommendToday) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", wxRecommendToday);
		List<WxRecommendToday> list = wxRecommendTodayMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	
	public PageView queryNoMatch(WxRecommendToday account,PageView pageView) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", account);
		List<WxRecommendToday> list = wxRecommendTodayMapper.queryNoMatch(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<WxRecommendToday> queryAll(WxRecommendToday t) {
		return wxRecommendTodayMapper.queryAll(t);
	}
	
	public List<WxRecommendToday> queryLastestRecommArticle(String class_id, String keyword, int limit) {
		return this.queryMoreRecommArticle(null, 0, limit, class_id, keyword);
	}
	
	public List<WxRecommendToday> queryMoreRecommArticle(Long max_article_id, int offset, int limit, String class_id, String keyword) {
		List<WxRecommendToday> wxRecommArticleList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("max_article_id", max_article_id);
		map.put("offset", offset);
		map.put("limit", limit);
		if(StringUtils.isBlank(class_id)) {
			wxRecommArticleList = wxRecommendTodayMapper.queryMoreRecommArticleNoClassId(map);
		}else {
			map.put("class_id", class_id);
			wxRecommArticleList = wxRecommendTodayMapper.queryMoreRecommArticleByClassId(map);
		}
		return wxRecommArticleList;
	}

	public void delete(String id) throws Exception {
		wxRecommendTodayMapper.delete(id);
	}

	public void update(WxRecommendToday t) throws Exception {
		wxRecommendTodayMapper.update(t);
	}

	public WxRecommendToday getById(String id) {
		return wxRecommendTodayMapper.getById(id);
	}

	
	public void add(WxRecommendToday t) throws Exception {
		wxRecommendTodayMapper.add(t);
	}
	
	public WxRecommendToday isExist(int id) {
		return wxRecommendTodayMapper.isExist(id);
	}


	public WxRecommendToday querySingleRecommArticle(int id) {
		return wxRecommendTodayMapper.querySingleRecommArticle(id);
	}


	public WxRecommendToday countRecommArticle(WxRecommendToday wxRecommArticle) {
		return wxRecommendTodayMapper.countRecommArticle(wxRecommArticle);
	}
}
