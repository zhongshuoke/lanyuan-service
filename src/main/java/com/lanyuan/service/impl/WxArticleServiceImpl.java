package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.WxArticle;
import com.lanyuan.mapper.WxArticleMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.WxArticleService;

@Transactional
@Service("wxArticleService")
public class WxArticleServiceImpl implements WxArticleService {
	@Autowired
	private WxArticleMapper wxArticleMapper;

	public PageView query(PageView pageView, WxArticle wxArticle) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", wxArticle);
		List<WxArticle> list = wxArticleMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	
	public PageView queryNoMatch(WxArticle account,PageView pageView) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", account);
		List<WxArticle> list = wxArticleMapper.queryNoMatch(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<WxArticle> queryAll(WxArticle t) {
		return wxArticleMapper.queryAll(t);
	}
	
	public List<WxArticle> queryLastestWxArticle(String class_id, String keyword, int limit) {
		return this.queryMoreWxArticle(null, 0, limit, class_id, keyword);
	}
	
	public List<WxArticle> queryMoreWxArticle(Long max_article_id, int offset, int limit, String class_id, String keyword) {
		List<WxArticle> wxArticleList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("max_article_id", max_article_id);
		map.put("offset", offset);
		map.put("limit", limit);
		if(StringUtils.isBlank(class_id)) {
			wxArticleList = wxArticleMapper.queryMoreWxArticleNoClassId(map);
		}else {
			map.put("class_id", class_id);
			wxArticleList = wxArticleMapper.queryMoreWxArticleByClassId(map);
		}
		return wxArticleList;
	}

	public void delete(String id) throws Exception {
		wxArticleMapper.delete(id);
	}

	public void update(WxArticle t) throws Exception {
		wxArticleMapper.update(t);
	}

	public WxArticle getById(String id) {
		return wxArticleMapper.getById(id);
	}

	
	public void add(WxArticle t) throws Exception {
		wxArticleMapper.add(t);
	}
	
	public WxArticle isExist(String wxAccountName) {
		return wxArticleMapper.isExist(wxAccountName);
	}


	public WxArticle querySingleArticle(String title) {
		return wxArticleMapper.querySingleArticle(title);
	}


	public WxArticle countArticle(WxArticle wxArticle) {
		return wxArticleMapper.countArticle(wxArticle);
	}


	public void recomm(String id) {
		wxArticleMapper.recomm(id);
	}


	public void updateRecommStatus(String id) {
		wxArticleMapper.updateRecommStatus(id);
	}

}
