package com.xxxx.controller;

import com.xxxx.mybatis.domain.Area;
import com.xxxx.repo.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/superadmin")
public class AreaController {

	Logger logger = LoggerFactory.getLogger(AreaController.class);

	@Autowired
	AreaService areaService;

	@RequestMapping(value = "/getAreaList", method = RequestMethod.GET)
	@ResponseBody
	public ModelMap getAreaList() {
		logger.info("========start======");
		long startTime = System.currentTimeMillis();

		ModelMap modelMap = new ModelMap();
		try {
			List<Area> list = areaService.getList();
			modelMap.put("list", list);
			modelMap.put("count", list.size());
		} catch (Exception e) {
			modelMap.put("code", 500);
		}

		long endTime = System.currentTimeMillis();
		logger.debug("====cost time " + (endTime - startTime) + "===");
		logger.info("========end======");

		logger.error("error info");

		return modelMap;

	}

}
