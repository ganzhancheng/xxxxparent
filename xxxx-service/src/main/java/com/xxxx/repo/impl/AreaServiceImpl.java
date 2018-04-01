package com.xxxx.repo.impl;

import com.xxxx.mybatis.IDao.AreaDao;
import com.xxxx.mybatis.domain.Area;
import com.xxxx.repo.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaDao areaDao;

	@Override
	public List<Area> getList() {
		return areaDao.queryArea();
	}
}
