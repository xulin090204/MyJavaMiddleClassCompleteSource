package com.mycompany.myapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.util.CollectionUtils;

import com.mycompany.myapp.service.impl.AndCalc;
import com.mycompany.myapp.service.impl.Calc;
import com.mycompany.myapp.service.impl.NotCalc;

public class 親Service {

	@SuppressWarnings("unchecked")
	protected List<String> get最終結果_by中間結果(Map<String,List<String>> 中間結果List) {

		List<String> 最終結果list = new ArrayList<String>();

		Calc calc = null;

		boolean isFirst = true;

		//for (List<String> 中間List : 中間結果List) {
		for (Entry<String, List<String>> 中間結果 : 中間結果List.entrySet()) {

			List 中間List = 中間結果.getValue();
			String sKey = 中間結果.getKey();

			if (StringUtils.equals(sKey, "削除年月日")) {
				calc = new NotCalc();
			}else {
				calc = new AndCalc();
			}

			// 如果中間結果为空，不需要进行論理計算，所以continue
			if (中間List == null) {

				continue;

			}

			// 第一个中間結果，不需要进行論理計算，所以continue
			if (isFirst == true) {

				最終結果list = new ArrayList<String>(中間List);
				isFirst = false;

				continue;
			}

			// 其他情况，需要进行【論理計算】
			// 論理計算：
			//           {1,2,3} and {2,3,4} = {2,3}
			//           {1,2,3} or {2,3,4}  = {1,2,3,4}
			//           {1,2,3} not {2,3,4} = {1}
			//           {2,3,4} not {1,2,3} = {4}

			最終結果list = calc.論理計算(最終結果list, 中間List);
		}

		return 最終結果list;
	}
/**
 *
 * @param s業務名 例　"案件名称"
 * @return
 */
	protected String ID採番(文件db file_db, String s項目名) {

		try {
			// ①採番
			return file_db.取得对象文件的记录数(file_db.getSPath() + s項目名 + ".txt")+1 +"";

		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 将str转成List
	 * 背景：因为我们要对应一对多的情况，就是一个ID要对应其他项目的多个ID的情况，所以会有内容为ID群的情况
	 * @param strs
	 * @return
	 */
	public static List<String> stringToList(String strs){
		if(StringUtils.isEmpty(strs)) {
			return null;
		}
		String str[] = strs.split("\\t");
		return Arrays.asList(str);
	}
	public static List<String> stringToList(String strs, String s分隔符){
		if(StringUtils.isEmpty(strs)) {
			return null;
		}
		String str[] = strs.split(s分隔符);
		return Arrays.asList(str);
	}
	/**
	 * 将List转成str
	 * 背景：因为我们要对应一对多的情况，就是一个ID要对应其他项目的多个ID的情况，所以会有内容为ID群的情况
	 * @param list
	 * @return
	 */
	public static String listToStr(List<String> list) {
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		String listString = "";
		for (String s : list)
		{
		    listString += s + "\t";
		}
		return listString;
	}

	public static String listToStr(Object value) {
		if (value instanceof String) {
			return (String)value;
		}
		if (value instanceof List) {
			return listToStr((List)value);
		}
		return null;
	}

	protected static List<String> getIDList_by小Map名andValue(String 小Map名, String value, String s計算方法, 文件db file_db) {

		List<String> IDList = new ArrayList();

		Map<String, Map> 大Map = file_db.getMap_data();

		Map<String, String> 小map = 大Map.get(小Map名);

		if (小map != null && !小map.isEmpty()) {
		} else {
			return null;
		}

		for (Map.Entry<String, String> entry : 小map.entrySet()) {

			String str1= entry.getValue().replace("\\", "");
			String str2= value.replace("\\", "");

			switch(s計算方法) {

			case ">=":
				if (str1.equals(str2)) {

					String id = entry.getKey();

					IDList.add(id);
				}

			case ">":

				if (NumberUtils.toInt(str1) > NumberUtils.toInt(str2)) {

					String id = entry.getKey();

					IDList.add(id);
				}

				break;

			case "<=":
				if (str1.equals(str2)) {

					String id = entry.getKey();

					IDList.add(id);
				}

			case "<":

				if (NumberUtils.toInt(str1) < NumberUtils.toInt(str2)) {

					String id = entry.getKey();

					IDList.add(id);
				}
				break;

			case "==":

				if (str1.equals(str2)) {

					String id = entry.getKey();

					IDList.add(id);
				}

				break;

			case "!=":

				if ( !str1.equals(str2)) {

					String id = entry.getKey();

					IDList.add(id);
				}

				break;

			case "like":

				if (value_like(entry.getValue(), value)) {

					String id = entry.getKey();

					IDList.add(id);
				}
			}


		}

		return IDList;
	}

	 static boolean value_like(String str1, String str2) {
		// java 两个字符串取交集
        HashSet<String> result = new HashSet<String>();
        int length1 = str1.length();
        int length2 = str2.length();
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                String char1 = str1.charAt(i) + "";
                String char2 = str2.charAt(j) + "";
                if (char1.equals(char2))
                {
                    result.add(char1);
                }
            }
        }

        return result.isEmpty()? false:true;
    }

	 /**
	  *
		检索处理_案件(案件Map)
		|
		|——遍历案件Map的每一项
		          if  key中没有「_开始」「_终了」字样，就用"like"
		          if  key中有「_开始」字样，就用">="
		          if  key中有「_终了」字样，就用"<="
	  *
	  * @param 检索对象Map
	  * @param file_db
	  * @return
	  */
	public static Map<String,List<String>> 检索处理(Map<String, String> 检索对象Map, 文件db file_db){
		Map<String,List<String>> 检索结果 = new HashMap();
		for (Map.Entry<String, String> entry : 检索对象Map.entrySet()) {
			String s存储项目=null;

			// 如果检索条件中没有入力项、就叫下一个。
			if ( !StringUtils.isNotEmpty(entry.getValue())) {
				continue;
			}
			boolean b包含开始 = is检索项目后面包含开始(entry.getKey());
			boolean b包含终了 = is检索项目后面包含终了(entry.getKey());
			if(b包含开始|| b包含终了) {
				s存储项目 = 去掉检索项目后面的开始或终了(entry.getKey());

			}else {
				s存储项目 = entry.getKey();
				// 就用"like"
				检索结果.put(s存储项目, getIDList_by小Map名andValue("案件概要", entry.getValue(), "like", file_db));
			}
			if(b包含开始){
				// 就用">="
				检索结果.put(s存储项目, getIDList_by小Map名andValue("案件概要", entry.getValue(), ">=", file_db));
			}
			if(b包含终了){
				// 就用"<="
				检索结果.put(s存储项目, getIDList_by小Map名andValue("案件概要", entry.getValue(), "<=", file_db));
			}

		}
		return 检索结果;

	}

	private static String 去掉检索项目后面的开始或终了(String key) {
		String s处理后的结果 = null;
		if(is检索项目后面包含开始(key)|| is检索项目后面包含终了(key)) {
			s处理后的结果 = key.substring(0, key.length()-3-1);
		}
		return null;
	}
	/**
	 *
	 * @param s检索项目
	 * @return
	 */
	private static boolean is检索项目后面包含终了(String s检索项目) {
		int i位置 = s检索项目.indexOf("_");
		if(i位置 == -1) {
			return false;
		}
		if(s检索项目.length()<2) {
			return false;
		}

		if(s检索项目.substring(s检索项目.length()-2, s检索项目.length()-1).equals("终了")) {
			return true;
		}
		return false;
	}
	/**
	 *
	 * @param s检索项目
	 * @return
	 */
	private static boolean is检索项目后面包含开始(String s检索项目) {
		int i位置 = s检索项目.indexOf("_");
		if(i位置 == -1) {
			return false;
		}
		if(s检索项目.length()<2) {
			return false;
		}

		if(s检索项目.substring(s检索项目.length()-2, s检索项目.length()-1).equals("开始")) {
			return true;
		}
		return false;
	}

}
