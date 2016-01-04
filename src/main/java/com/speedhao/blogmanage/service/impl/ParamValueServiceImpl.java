package com.speedhao.blogmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speedhao.blogmanage.dao.ParamValueDao;
import com.speedhao.blogmanage.model.ParamValue;
import com.speedhao.blogmanage.service.ParamValueService;

@Service
public class ParamValueServiceImpl implements ParamValueService {

	@Autowired
	private ParamValueDao paramValueDao;

	@Override
	public String getValue(String name, String code) {
		ParamValue pv = new ParamValue();
		pv.setParam_name(name);
		pv.setParam_code(code);
		List<ParamValue> list = paramValueDao.selectPV(pv);
		if(list != null && !list.isEmpty())
		{
			return list.get(0).getParam_value();
		}
		else
		{
			return "...";
		}
	}

	@Override
	public List<ParamValue> getCVbyName(String name) {
		ParamValue pv = new ParamValue();
		pv.setParam_name(name);
		return paramValueDao.selectCV(pv);
	}

}
