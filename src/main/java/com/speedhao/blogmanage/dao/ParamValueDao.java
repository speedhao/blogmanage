package com.speedhao.blogmanage.dao;

import java.util.List;

import com.speedhao.blogmanage.model.ParamValue;

public interface ParamValueDao {
	/**
	 * 根据name，code查询值
	 * @param name
	 * @param code
	 * @return
	 */
	public List<ParamValue> selectPV(ParamValue pv);
	
	/**
	 * 根据name查询值
	 * @param pv
	 * @return
	 */
	public List<ParamValue> selectCV(ParamValue pv);
}
