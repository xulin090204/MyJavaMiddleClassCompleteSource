package com.mycompany.myapp.service.impl;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.mycompany.myapp.bean.案件Bean;
import com.mycompany.myapp.bean.案件検索Bean;
import com.mycompany.myapp.service.文件db;
import com.mycompany.myapp.service.親Service;

public class 案件Service extends 親Service{
	// "名称" 必须放在0号位，否则全件检索时会出问题
	String[] fileName = {
			"案件ID",
			"案件名称",
			"案件概要",
			"案件場所",
			"担当職種",
			"所在工程",
			"作業開始年月",
			"作業预计终了年月",
			"作業实际终了年月",
			"募集人数",
			"チーム人数",
			"開発言語" ,
			"FrameWork",
			"ツール",
			"OS",
			"DB"
			};

	文件db file_db = new 文件db("案件");

	public List<案件Bean> 検索案件_by検索Bean(案件検索Bean bean) {

		file_db.情報読み込み(fileName);

		Map<String,List<String>> 中間結果IDList = get中間結果_by案件検索Bean(bean);

		List<String> 最終結果IDList = get最終結果_by中間結果(中間結果IDList);

		return 取得検索結果_by最終結果(最終結果IDList);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<案件Bean> 取得検索結果_by最終結果(List<String> 最終結果idList) {

		List<案件Bean> 案件BeanList = new ArrayList();

		for (String 案件id : 最終結果idList) {

			案件BeanList.add(取得案件情報_by案件id(案件id));
		}

		return 案件BeanList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private 案件Bean 取得案件情報_by案件id(String 案件id) {

		Map<String, Map> 大Map = file_db.getMap_data();

		案件Bean 案件bean = new 案件Bean();

		//案件bean.setS_ID(案件id);

		for (Map.Entry<String, Map> entry : 大Map.entrySet()) {

			if (entry == null) {

				continue;

			}

			Map<String, String> 小Map;

			String 小Map名 = entry.getKey();

			switch (小Map名) {

			case "案件名称":
				小Map = entry.getValue();
				案件bean.set案件名称(小Map.get(案件id));
				break;
			case "案件概要":
				小Map = entry.getValue();
				案件bean.set案件概要(小Map.get(案件id));
				break;
			case "作業開始年月日":
				小Map = entry.getValue();
				案件bean.set作業開始年月日(小Map.get(案件id));
				break;
			case "案件場所":
				小Map = entry.getValue();
				案件bean.set案件場所(小Map.get(案件id));
				break;
			case "募集人数":
				小Map = entry.getValue();
				案件bean.set募集人数(小Map.get(案件id));
				break;
			}
		}
		return 案件bean;
	}



	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map<String,List<String>> get中間結果_by案件検索Bean(案件検索Bean bean) {

		Map<String,List<String>> 中間結果list = new HashMap();
		if (StringUtils.isNotEmpty(bean.getS_ID())) {

			/*IDList_name = getIDList_byNameandValue("姓名", "Aさん");*/
			中間結果list.put("ID",Arrays.asList(bean.getS_ID()));
		}

		if (StringUtils.isNotEmpty(bean.get案件名称())) {

			//IDList_name = getIDList_byNameandValue("案件名称", "Aさん");
			中間結果list.put("案件名称",getIDList_by小Map名andValue("案件名称", bean.get案件名称(), "==",file_db));

		}
		Object getIDList_byNameandValue;
		if (StringUtils.isNotEmpty(bean.get案件概要())) {

			//IDList_name = getIDList_byNameandValue("案件概要", "Aさん");
			中間結果list.put("案件概要",getIDList_by小Map名andValue("案件概要", bean.get案件概要(), "like",file_db));

		}
		if (StringUtils.isNotEmpty(bean.get案件概要())) {

			//IDList_name = getIDList_byNameandValue("案件場所", "Aさん");
			中間結果list.put("案件場所",getIDList_by小Map名andValue("案件場所", bean.get案件場所(), "like",file_db));

		}
		if (StringUtils.isNotEmpty(bean.get職種())) {

			//IDList_name = getIDList_byNameandValue("職種", "Aさん");
			中間結果list.put("職種",getIDList_by小Map名andValue("職種", bean.get職種(), "like",file_db));

		}
		if (StringUtils.isNotEmpty(bean.get工程())) {

			//IDList_name = getIDList_byNameandValue("職種", "Aさん");
			中間結果list.put("工程",getIDList_by小Map名andValue("工程", bean.get工程(), "like",file_db));

		}

		if (StringUtils.isNotEmpty(bean.get案件開始日_開始())) {

			中間結果list.put("案件開始日",getIDList_by小Map名andValue("案件開始日", bean.get案件開始日_開始(), ">=",file_db));

		}

		if (StringUtils.isNotEmpty(bean.get案件開始日_終了())) {

			中間結果list.put("案件開始日",getIDList_by小Map名andValue("案件開始日", bean.get案件開始日_終了(), "<=",file_db));

		}

		if (StringUtils.isNotEmpty(bean.get案件場所())) {

			中間結果list.put("場所",getIDList_by小Map名andValue("場所", bean.get案件場所(), "",file_db));
		}


		if (StringUtils.isNotEmpty(bean.get人数_開始())) {

			中間結果list.put("人数",getIDList_by小Map名andValue("人数", bean.get人数_開始(), ">=",file_db));
		}

		if (StringUtils.isNotEmpty(bean.get人数_終了())) {

			中間結果list.put("人数",getIDList_by小Map名andValue("人数", bean.get人数_終了(), "<=",file_db));
		}

		if (StringUtils.isNotEmpty(bean.get予定終了日_開始())) {

			中間結果list.put("予定終了日",getIDList_by小Map名andValue("予定終了日", bean.get予定終了日_開始(), ">=",file_db));
		}

		if (StringUtils.isNotEmpty(bean.get予定終了日_終了())) {

			中間結果list.put("予定終了日",getIDList_by小Map名andValue("予定終了日", bean.get予定終了日_終了(), "<=",file_db));
		}

		if (StringUtils.isNotEmpty(bean.get実際終了日_開始())) {

			中間結果list.put("実際終了日",getIDList_by小Map名andValue("実際終了日", bean.get実際終了日_開始(), ">=",file_db));
		}

		if (StringUtils.isNotEmpty(bean.get予定終了日_終了())) {

			中間結果list.put("実際終了日",getIDList_by小Map名andValue("実際終了日", bean.get実際終了日_終了(), "<=",file_db));
		}
		/*
		if (StringUtils.isNotEmpty(bean.get契約種類())) {

			中間結果list.put("契約種類",getIDList_by小Map名andValue("契約種類", bean.get契約種類(), "=="));
		}
		if (StringUtils.isNotEmpty(bean.get電話名称())) {

			中間結果list.put("電話名称",getIDList_by小Map名andValue("電話名称", bean.get電話名称(), "=="));
		}
*/

		// 无条件检索时
		if(allfieldIsNUll(bean)) {

			//中間結果list.put("名称",file_db.取得全ID_by項目名("名称"));
			中間結果list.put("ID",file_db.取得全部ID(fileName[0]));
		}

		// 削除時の対応
		中間結果list.put("削除年月日",getIDList_by小Map名andValue("削除年月日", "", "!=" ,file_db));

		return 中間結果list;

	}


	public String 追加案件_by案件Bean(案件Bean bean) {

//		文件db file_db = new 文件db("案件");
//
//		// ①チェック入力
//		file_db.情報読み込み(fileName);

		// ②追加処理
		追加案件_byFile_db_案件Bean(bean);


		return "";
	}

	private String 追加案件_byFile_db_案件Bean(案件Bean bean) {

		String path;
		String 案件ID = null;

		// ①採番
		//ID = file_db.取得对象文件的记录数(file_db.getSPath() + "案件名称" + ".txt")+1 +"";
		// 由于采用了父Class来统一管理采番的问题，所以这里的写法要改变一下 2019-4-23
		案件ID = ID採番(file_db, "案件ID");

		for(String s文件名 : fileName) {

			path = file_db.getSPath() +  s文件名 + ".txt";

			switch(s文件名) {
			case "案件ID":
				if(!StringUtils.isEmpty(案件ID)) {
					file_db.文件書込(path, 案件ID + "," + 案件ID);
				}
				break;
			case "案件名称":

				if(!StringUtils.isEmpty(bean.get案件名称())) {
					file_db.文件書込(path, 案件ID + "," + bean.get案件名称());
				}
				break;

			case "案件概要":

				if(!StringUtils.isEmpty(bean.get案件概要())) {
					file_db.文件書込(path, 案件ID + "," + bean.get案件概要());
				}
				break;
			case "案件場所":

				if(!StringUtils.isEmpty(bean.get案件場所())) {
					file_db.文件書込(path, 案件ID + "," + bean.get案件場所());
				}
				break;

			case "担当職種":

				if(!StringUtils.isEmpty(bean.get担当職種())) {
					file_db.文件書込(path, 案件ID + "," + bean.get担当職種());
				}
				break;
			case "所在工程":

				if(!StringUtils.isEmpty(bean.get所在工程())) {
					file_db.文件書込(path, 案件ID + "," + bean.get所在工程());
				}
				break;
			case "作業開始年月日":

				if(!StringUtils.isEmpty(bean.get作業開始年月日())) {
					file_db.文件書込(path, 案件ID + "," + bean.get作業開始年月日());
				}
				break;

			case "作業预计终了年月":

				if(!StringUtils.isEmpty(bean.get作業预计终了年月())) {
					file_db.文件書込(path, 案件ID + "," + bean.get作業预计终了年月());
				}
				break;

			case "作業实际终了年月":

				if(!StringUtils.isEmpty(bean.get作業实际终了年月())) {
					file_db.文件書込(path, 案件ID + "," + bean.get作業实际终了年月());
				}
				break;

			case "募集人数":

				if(!StringUtils.isEmpty(bean.get募集人数())) {
					file_db.文件書込(path, 案件ID + "," + bean.get募集人数());
				}
				break;

			case "チーム人数":

				if(!StringUtils.isEmpty(bean.getチーム人数())) {
					file_db.文件書込(path, 案件ID + "," + bean.getチーム人数());
				}
				break;

			case "開発言語":

				if(!StringUtils.isEmpty(bean.get開発言語())) {
					file_db.文件書込(path, 案件ID + "," + bean.get開発言語());
				}
				break;

			case "FrameWork":

				if(!StringUtils.isEmpty(bean.getFrameWork())) {
					file_db.文件書込(path, 案件ID + "," + bean.getFrameWork());
				}
				break;

			case "ツール":

				if(!StringUtils.isEmpty(bean.getツール())) {
					file_db.文件書込(path, 案件ID + "," + bean.getツール());
				}
				break;

			case "OS":

				if(!StringUtils.isEmpty(bean.getOS())) {
					file_db.文件書込(path, 案件ID + "," + bean.getOS());
				}
				break;

			case "DB":

				if(!StringUtils.isEmpty(bean.getDB())) {
					file_db.文件書込(path, 案件ID + "," + bean.getDB());
				}
				break;
			}
		}
		return 案件ID;
	}

	public void 更新案件_by案件Bean(案件Bean bean) {
		// 更新时
		// 将最新信息追加到指定文件
		文件db file_db = new 文件db("案件");
		//String ID = bean.getOld_名称();
		file_db.情報読み込み(fileName);
		String 案件ID = bean.get案件ID();

		if(!StringUtils.equals(bean.getOld_案件名称(), bean.get案件名称())) {
			String path = file_db.getSPath() +  "案件名称.txt";
			file_db.文件書込(path, 案件ID + "," + bean.get案件名称());

		}
		if(!StringUtils.equals(bean.getOld_案件概要(), bean.get案件概要())) {
			String path = file_db.getSPath() +  "案件概要.txt";
			file_db.文件書込(path, 案件ID + "," + bean.get案件概要());

		}
		if(!StringUtils.equals(bean.getOld_案件場所(), bean.get案件場所())) {
			String path = file_db.getSPath() +  "案件場所.txt";
			file_db.文件書込(path, 案件ID + "," + bean.get案件場所());
		}
		if(!StringUtils.equals(bean.getOld_担当職種(), bean.get担当職種())) {
			String path = file_db.getSPath() +  "担当職種.txt";
			file_db.文件書込(path, 案件ID + "," + bean.get担当職種());

		}
		if(!StringUtils.equals(bean.getOld_所在工程(), bean.get所在工程())) {
			String path = file_db.getSPath() +  "所在工程.txt";
			file_db.文件書込(path, 案件ID + "," + bean.get所在工程());

		}
		if(!StringUtils.equals(bean.getOld_作業開始年月日(), bean.get作業開始年月日())) {
			String path = file_db.getSPath() +  "作業開始年月日.txt";
			file_db.文件書込(path, 案件ID + "," + bean.get作業開始年月日());

		}
		if(!StringUtils.equals(bean.getOld_作業预计终了年月(), bean.get作業预计终了年月())) {
			String path = file_db.getSPath() +  "作業预计终了年月.txt";
			file_db.文件書込(path, 案件ID + "," + bean.get作業预计终了年月());
		}
		if(!StringUtils.equals(bean.getOld_作業实际终了年月(), bean.get作業实际终了年月())) {
			String path = file_db.getSPath() +  "作業实际终了年月.txt";
			file_db.文件書込(path, 案件ID + "," + bean.get作業实际终了年月());
		}
		if(!StringUtils.equals(bean.getOld_募集人数(), bean.get募集人数())) {
			String path = file_db.getSPath() +  "募集人数.txt";
			file_db.文件書込(path, 案件ID + "," + bean.get募集人数());
		}
		if(!StringUtils.equals(bean.getOld_チーム人数(), bean.getチーム人数())) {
			String path = file_db.getSPath() +  "チーム人数.txt";
			file_db.文件書込(path, 案件ID + "," + bean.getチーム人数());
		}
		if(!StringUtils.equals(bean.getOld_開発言語(), bean.get開発言語())) {
			String path = file_db.getSPath() +  "開発言語.txt";
			file_db.文件書込(path, 案件ID + "," + bean.get開発言語());
		}
		if(!StringUtils.equals(bean.getOld_FrameWork(), bean.getFrameWork())) {
			String path = file_db.getSPath() +  "FrameWork.txt";
			file_db.文件書込(path, 案件ID + "," + bean.getFrameWork());
		}
		if(!StringUtils.equals(bean.getOld_ツール(), bean.getツール())) {
			String path = file_db.getSPath() +  "ツール.txt";
			file_db.文件書込(path, 案件ID + "," + bean.getツール());
		}
		if(!StringUtils.equals(bean.getOld_OS(), bean.getOS())) {
			String path = file_db.getSPath() +  "OS.txt";
			file_db.文件書込(path, 案件ID + "," + bean.getOS());
		}
		if(!StringUtils.equals(bean.getOld_DB(), bean.getDB())) {
			String path = file_db.getSPath() +  "DB.txt";
			file_db.文件書込(path, 案件ID + "," + bean.getDB());
		}
	}

	public void 削除案件_by案件Bean(案件Bean bean) {
		String path = file_db.getSPath() +  "削除年月日.txt";
		//String ID = bean.getOld_名称();

		file_db.情報読み込み(fileName);
		String 案件ID = bean.get案件ID();

		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//设置日期格式
		String sDate = df.format(new Date()).toString();// new Date()为获取当前系统时间
		file_db.文件書込(path, 案件ID + "," + sDate);

		// 1、削除时（采取逻辑删除。就是并不是真的删除了。而是做上删除的标记）
		//    追加一个叫削除时间的文件
		//    -----------内容如下-------------
		//    【采番】，【削除时间】
		//    【采番】，【削除时间】
		//    --------------------------------

		// 2、検索時 ，自动附加【无删除记录】的条件）
		//    凡是上面有记录的。
		//    都不会取得信息
	}

	public static boolean allfieldIsNUll(Object o){
	    try{
	        for(Field field:o.getClass().getDeclaredFields()){
	            field.setAccessible(true);//把私有属性公有化
	            Object object = field.get(o);
	            if(object == null){
	            	continue;
	            }
	            if(object instanceof CharSequence){
	                if(!StringUtils.isEmpty((String)object)){
	                    return false;
	                }
	            }else{
	                if(!ObjectUtils.isEmpty((Object[]) object)){
	                    return false;
	                }
	            }

	        }
	    }catch (Exception e){
	        e.printStackTrace();
	    }
	    return true;
	}

	public List 登陆案件情報List(List<Map<String, String>> 経験_案件情報ListMap) {
		// 案件情報List为空就中指登陆
		if(CollectionUtils.isEmpty(経験_案件情報ListMap)) {
			return null;
		}
		List 案件情報IDList = new ArrayList();
		for(Map<String, String> 案件情报Map : 経験_案件情報ListMap) {
			案件Bean 案件bean = get案件BeanFrom案件情报Map(案件情报Map);
			案件情報IDList.add(追加案件_byFile_db_案件Bean(案件bean));
		}
		return 案件情報IDList;
	}

	private 案件Bean get案件BeanFrom案件情报Map(Map<String, String> 案件情报map) {
		案件Bean 案件bean = new 案件Bean();
		for(Entry<String, String> entry : 案件情报map.entrySet()) {
			String sValue = listToStr(entry.getValue());
			if(StringUtils.isEmpty(sValue)) {
				continue;
			}
			switch(entry.getKey()) {
			case "案件ID":if(entry.getValue()!=null)案件bean.set案件ID(sValue);break;
			case "案件名称":if(entry.getValue()!=null)案件bean.set案件名称(sValue);break;
			case "案件概要":if(entry.getValue()!=null)案件bean.set案件名称(sValue);break;
			case "案件場所":if(entry.getValue()!=null)案件bean.set案件場所(sValue);break;
			case "担当職種":if(entry.getValue()!=null)案件bean.set担当職種(sValue);break;
			case "所在工程":if(entry.getValue()!=null)案件bean.set所在工程(sValue);break;
			case "作業開始年月日":if(entry.getValue()!=null)案件bean.set作業開始年月日(sValue);break;
			case "作業预计终了年月":if(entry.getValue()!=null)案件bean.set作業预计终了年月(sValue);break;
			case "作業实际终了年月":if(entry.getValue()!=null)案件bean.set作業实际终了年月(sValue);break;
			case "募集人数":if(entry.getValue()!=null)案件bean.set募集人数(sValue);break;
			case "チーム人数":if(entry.getValue()!=null)案件bean.setチーム人数(sValue);break;
			case "開発言語":if(entry.getValue()!=null)案件bean.set開発言語(sValue);break;
			case "FrameWork":if(entry.getValue()!=null)案件bean.setFrameWork(sValue);break;
			case "ツール":if(entry.getValue()!=null)案件bean.setツール(sValue);break;
			case "OS":if(entry.getValue()!=null)案件bean.setOS(sValue);break;
			case "DB":if(entry.getValue()!=null)案件bean.setDB(sValue);break;
			}
		}
		return 案件bean;
	}

}

