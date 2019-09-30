package com.mycompany.myapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.mycompany.myapp.bean.技術情報Bean;
import com.mycompany.myapp.service.文件db;
import com.mycompany.myapp.service.親Service;

/**
 *
 *  主要负责管理技术者的个人技术情报。
 *  主要负责管理案件的技术情报。
 *  用技术者ID查找技术情报ID
 * @author haoyan
 *
 */
public class 技術情報Service extends 親Service{
	// "名称" 必须放在0号位，否则全件检索时会出问题
	String[] fileName = { "技術ID", "技術方向", "技術項目", "资格_等级", "年数_开始年月", "備考説明"};

	文件db file_db = new 文件db("技術情報");

	/**
	 *
	 * @param 技术项目_情報ListMap
	 * @return
	 */
	public List 登陆技術情报List(List<Map<String, Object>> 技术项目_情報ListMap) {

		// 技術情报List为空就中指登陆
		if(CollectionUtils.isEmpty(技术项目_情報ListMap)) {
			return null;
		}
		List 技术情报IDList = new ArrayList();
		for(Map<String, Object> 技术项目_情報Map : 技术项目_情報ListMap) {
			技術情報Bean 技術情報bean = get技術情報BeanFrom技术项目_情報Map(技术项目_情報Map);
			技术情报IDList.add(追加技術情報_byFile_db_技術情報bean(技術情報bean));
		}
		return 技术情报IDList;

	}

	/**
	 *
	 * @param bean
	 * @return
	 */
	private String 追加技術情報_byFile_db_技術情報bean(技術情報Bean bean) {
		String path;
		String 技術ID = null;

		// ①採番
		//ID = file_db.取得对象文件的记录数(file_db.getSPath() + "技術ID" + ".txt")+1 +"";
		技術ID = ID採番(file_db, "技術ID");

		for(String s文件名 : fileName) {

			path = file_db.getSPath() +  s文件名 + ".txt";

			switch(s文件名) {
			case "技術ID":
				if(!StringUtils.isEmpty(技術ID)) {
					file_db.文件書込(path, 技術ID + "," + 技術ID);
				}
				break;

			case "技術方向":

				if(!StringUtils.isEmpty(bean.get技術方向())) {
					file_db.文件書込(path, 技術ID + "," + bean.get技術方向());
				}
				break;

			case "技術項目":

				if(!StringUtils.isEmpty(bean.get技術項目())) {
					file_db.文件書込(path, 技術ID + "," + bean.get技術項目());
				}
				break;

			case "资格_等级":

				if(!StringUtils.isEmpty(bean.get资格_等级())) {
					file_db.文件書込(path, 技術ID + "," + bean.get资格_等级());
				}
				break;

			case "年数_开始年月":

				if(!StringUtils.isEmpty(bean.get年数_开始年月())) {
					file_db.文件書込(path, 技術ID + "," + bean.get年数_开始年月());
				}
				break;

			case "備考説明":

				if(!StringUtils.isEmpty(bean.get備考説明())) {
					file_db.文件書込(path, 技術ID + "," + bean.get備考説明());
				}
				break;
			}
		}
		return 技術ID;

	}

	private 技術情報Bean get技術情報BeanFrom技术项目_情報Map(Map<String, Object> 技术项目_情報Map) {
		技術情報Bean 技術情報bean = new 技術情報Bean();
		for(Entry<String, Object> entry : 技术项目_情報Map.entrySet()) {
			String sValue = listToStr(entry.getValue());
			if(StringUtils.isEmpty(sValue)) {
				continue;
			}
			switch(entry.getKey()) {
			case "技術ID":技術情報bean.set技術ID(sValue);break;
			case "技術方向":技術情報bean.set技術方向(sValue);break;
			case "技術項目":技術情報bean.set技術項目(sValue);break;
			case "资格_等级":技術情報bean.set资格_等级(sValue);break;
			case "年数_开始年月":技術情報bean.set年数_开始年月(sValue);break;
			case "備考説明":技術情報bean.set備考説明(sValue);break;
			}
		}
		return 技術情報bean;
	}

}
