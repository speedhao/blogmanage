package com.speedhao.blogmanage.service;

import java.util.List;

import com.speedhao.blogmanage.model.ParamValue;

public interface ParamValueService {

	/**
	 * 根据name，code获取value
	 * @param name
	 * @param code
	 * @return
	 */
	public String getValue(String name, String code);
	
	/**
	 * 根据name查询code,value
	 * @param name
	 * @return
	 */
	public List<ParamValue> getCVbyName(String name);
}
