package com.lanyuan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanyuan.entity.TypePic;
import com.lanyuan.mapper.TypePicMapper;
import com.lanyuan.pulgin.mybatis.plugin.PageView;
import com.lanyuan.service.TypePicService;

@Transactional
@Service("TypePicService")
public class TypePicServiceImpl implements TypePicService {
	@Autowired
	private TypePicMapper typePicMapper;

	public PageView query(PageView pageView, TypePic typePic) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", typePic);
		List<TypePic> list = typePicMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	public List<TypePic> queryAll(TypePic typePic) {
        return typePicMapper.queryAll(typePic);
	}

	public void delete(String id) throws Exception {
		typePicMapper.delete(id);
	}

	public void update(TypePic typePic) throws Exception {
		typePicMapper.update(typePic);
	}

	public TypePic getById(String id) {
		return typePicMapper.getById(id);
	}

	public void add(TypePic typePic) throws Exception {
		typePicMapper.add(typePic);
	}


}
