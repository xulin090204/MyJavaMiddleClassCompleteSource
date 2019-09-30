package com.mycompany.myapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.mycompany.myapp.bean.技術者Bean;
import com.mycompany.myapp.bean.技術者検索Bean;
import com.mycompany.myapp.service.文件db;
import com.mycompany.myapp.service.親Service;

public class 技術者Service extends 親Service{

	String[] fileName = {
			"技術者ID",
			"技術項目_ID",
			"経験_案件ID",
			"技術者_社員CD",
			"姓名",
			"性别",
			"生年月日",
			"最終卒業学校名",
			"最終学位",
			"卒業技能",
			"会社名",
			"TEL",
			"FAX",
			"最寄駅",
			"就職開始年月",
			"日本語読み能力",
			"日本語書き能力",
			"日本語会話能力",
			"日本語レベル",
			"英語読み能力",
			"英語書き能力",
			"英語会話能力",
			"英検点数",
			"仕事_留学_経験有無",
			"仕事_留学_経験開始年月"
			};

	文件db file_db = new 文件db("技術者");

	public String 追加技術者_by技術者Bean(技術者Bean bean) {
//		文件db file_db = new 文件db("技術者");
//
//		// ①チェック入力
//		file_db.情報読み込み(fileName);

		// ②追加処理
		追加技術者_byFile_db_技術者Bean(bean);

		return "";
	}

	private void 追加技術者_byFile_db_技術者Bean(技術者Bean bean) {

		String path;
		// 1、对技术者采番
		String 技术者ID = ID採番(file_db, "技術者ID");

		if(StringUtils.isEmpty(技术者ID)) {
			System.out.println("技术者ID:採番失敗！（参照：技術者Service.追加技術者_byFile_db_技術者Bean() line:52）");
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return;
			}
		}
		// 2、登陆该技术者所有经验案件，取得经验案件ID
		案件Service 案件service = new 案件Service();
		List<String> 经验案件IDlist = 案件service.登陆案件情報List(bean.get経験_案件情報());
		bean.set経験_案件ID(经验案件IDlist);

		// 3、登陆技术者所有技术情报，取得技术情报ID
		技術情報Service 技術情報service = new 技術情報Service();
		List<String> 技术情报IDlist = 技術情報service.登陆技術情报List(bean.get技術項目_情報());
		bean.set技術項目_ID(技术情报IDlist);

		// 详细信息登陆
		for(String s文件名 : fileName) {

			path = file_db.getSPath() +  s文件名 + ".txt";

			switch(s文件名) {
			case "技術者ID":
				if(!StringUtils.isEmpty(技术者ID)) {
					file_db.文件書込(path, 技术者ID + "," + 技术者ID);
				}
				break;
			case "技術項目_ID":
				// 然后把技术者ID与经验案件ID登陆
				if(!CollectionUtils.isEmpty(bean.get技術項目_ID())) {
					file_db.文件書込(path, 技术者ID + "," + listToStr(bean.get技術項目_ID()));
				}
				break;
			case "経験_案件ID":
				// 然后把技术者ID与技术情报ID登陆
				if(!CollectionUtils.isEmpty(bean.get経験_案件ID())) {
					file_db.文件書込(path, 技术者ID + "," + listToStr(bean.get経験_案件ID()));
				}
				break;
				// 最后把技术者ID与其他信息登陆
			case "技術者_社員CD":
				if(!StringUtils.isEmpty(bean.get技術者_社員CD())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get技術者_社員CD());
				}
				break;
			case "姓名":
				if(!StringUtils.isEmpty(bean.get姓名())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get姓名());
				}
				break;
			case "生年月日":
				if(!StringUtils.isEmpty(bean.get生年月日())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get生年月日());
				}
				break;
			case "最終卒業学校名":
				if(!StringUtils.isEmpty(bean.get最終卒業学校名())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get最終卒業学校名());
				}
				break;
			case "最終学位":
				if(!StringUtils.isEmpty(bean.get最終学位())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get最終学位());
				}
				break;
			case "卒業技能":
				if(!StringUtils.isEmpty(bean.get卒業技能())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get卒業技能());
				}
				break;
			case "会社名":
				if(!StringUtils.isEmpty(bean.get会社名())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get会社名());
				}
				break;

			case "TEL":
				if(!StringUtils.isEmpty(bean.getTEL())) {
					file_db.文件書込(path, 技术者ID + "," + bean.getTEL());
				}
				break;
			case "FAX":
				if(!StringUtils.isEmpty(bean.getFAX())) {
					file_db.文件書込(path, 技术者ID + "," + bean.getFAX());
				}
				break;
			case "最寄駅":
				if(!StringUtils.isEmpty(bean.get最寄駅())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get最寄駅());
				}
				break;
			case "就職開始年月":
				if(!StringUtils.isEmpty(bean.get就職開始年月())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get就職開始年月());
				}
				break;


			case "日本語読み能力":
				if(!StringUtils.isEmpty(bean.get日本語読み能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get日本語読み能力());
				}
				break;
			case "日本語書き能力":
				if(!StringUtils.isEmpty(bean.get日本語書き能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get日本語書き能力());
				}
				break;
			case "日本語会話能力":
				if(!StringUtils.isEmpty(bean.get日本語会話能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get日本語会話能力());
				}
				break;
			case "日本語レベル":
				if(!StringUtils.isEmpty(bean.get日本語レベル())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get日本語レベル());
				}
				break;
			case "英語読み能力":
				if(!StringUtils.isEmpty(bean.get英語読み能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get英語読み能力());
				}
				break;
			case "英語書き能力":
				if(!StringUtils.isEmpty(bean.get英語書き能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get英語書き能力());
				}
				break;
			case "英語会話能力":
				if(!StringUtils.isEmpty(bean.get英語会話能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get英語会話能力());
				}
				break;
			case "英検点数":
				if(!StringUtils.isEmpty(bean.get英検点数())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get英検点数());
				}
				break;
			case "仕事_留学_経験有無":
				if(!StringUtils.isEmpty(bean.get仕事_留学_経験有無())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get仕事_留学_経験有無());
				}
				break;
			case "仕事_留学_経験開始年月":
				if(!StringUtils.isEmpty(bean.get仕事_留学_経験開始年月())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get仕事_留学_経験開始年月());
				}
				break;
			}
		}
	}

//	public List<技術者Bean> 検索技術者_by検索Bean(技術者検索Bean bean) {
//		/**
//		get中間結果_by技術者検索Bean(技術者检索Bean)
//		|
//		|——中间结果IDList=取得中间结果(List)
//		|——中间结果案件List=检索处理_案件List(案件List)
//		|——中间结果技术List=检索处理_技术List(技术List)
//		|——中间结果IDList.addAll(中间结果案件List);
//		|——中间结果IDList.addAll(中间结果技术List);
//		|——最终结果IDList=取得最终结果(中间结果IDList)
//		|——取得技术者信息_根据最终结果IDList(最终结果IDList)
//		*/
//		file_db.情報読み込み(fileName);
//
//		Map<String,List<String>> 中間結果IDList = get中間結果_by技術者検索Bean(bean);
//		List 中间结果案件List=检索处理_案件List(bean.get案件检索信息List());
//		List 中间结果技術List=检索处理_技術List(bean.get技術检索信息List());
//
//		Calc calc = new AndCalc();
//		List<String> 最終結果IDList = new ArrayList();
//		List 中間結果技術者List = get最終結果_by中間結果(中間結果IDList);
//		最終結果IDList = calc.論理計算(中間結果技術者List, 中间结果案件List);
//		最終結果IDList = calc.論理計算(最終結果IDList, 中间结果技術List);
//
//		return 取得検索結果_by最終結果(最終結果IDList);
//	}

	public List<技術者Bean> 検索技術者_by検索Bean(技術者検索Bean bean){
//		1、调用以下函数、取得满足技术者基本信息的中间结果
//
//		   函数名：get中間結果_by技術者検索Bean
//		   参数：技術者検索Bean
//		   返回值类型：Map<String,List<String>>
		Map<String,List<String>> 中間結果IDList = get中間結果_by技術者検索Bean(bean);

//		2、调用以下函数、取得满足经验案件检索信息的中间结果
//
//		   函数名：检索处理_案件List
//		   参数：List<Map>
//		   返回值类型：List<String>
		List 中间结果案件List=检索处理_案件List(bean.get案件检索信息List());

//		3、调用以下函数、取得满足技术检索信息的中间结果
//
//		   函数名：检索处理_技術List
//		   参数：List<Map>
//		   返回值类型：List<String>
		List 中间结果技術List=检索处理_技術List(bean.get技術检索信息List());

//		4、调用以下函数、取得满足所有技术者基本信息的结果
//
//		   函数名：get最終結果_by中間結果
//		   参数：List<Map>
//		   返回值类型：List<String>
		List<String> 最終結果IDList = new ArrayList();
		List 中間結果技術者List = get最終結果_by中間結果(中間結果IDList);

//		5、取得满足所有三种条件的最终结果
		Calc calc = new AndCalc();
		最終結果IDList = calc.論理計算(中間結果技術者List, 中间结果案件List);
		最終結果IDList = calc.論理計算(最終結果IDList, 中间结果技術List);

//		6、调用以下函数、取得最终检索出技术者的关联信息
//
//		   函数名：取得検索結果_by最終結果
//		   参数：List<Map>
//		   返回值类型：List<String>
//		7、返回处理6的结果
		return 取得検索結果_by最終結果(最終結果IDList);

	}
	/**
	 * 情况1:
	 * 要求你有什么技术，且对这个技术要有特殊要求。
	 *
	 * 情况2:
	 * 要求你有什么技术，或者有其他技术也可。
	 *
	 * @param 案件检索信息List
	 * @return
	 */
	private List 检索处理_技術List(List<Map> 技術检索信息List) {
		List 最終結果list = new ArrayList();
		for(Map 技術检索信息 : 技術检索信息List) {
			// Java 6年，他们之间的关系应该用【且】来计算
			List 满足该技术的技术者IDList = get最終結果_by中間結果 (检索处理(技術检索信息, file_db));

			// 技术与技术之间的关系，也要用【且】来计算。
			Calc calc = new AndCalc();
			最終結果list = calc.論理計算(最終結果list, 满足该技术的技术者IDList);
		}
		return 最終結果list;
	}

	/**
	 * 情况1:
	 * 要求你干过什么案件，且这个案件要有什么样的背景。
	 *
	 * 情况2:
	 * 要求你干过什么案件，或者干过其他类似案件都可。
	 *
	 * @param 案件检索信息List
	 * @return
	 */
	private List 检索处理_案件List(List<Map> 案件检索信息List) {
		List 最終結果list = new ArrayList();
		for(Map 案件检索信息 : 案件检索信息List) {
			// 每次返回的都是对一个案件的检索结果、他们之间的关系应该用【且】来计算
			List 满足该案件的技术者IDList = get最終結果_by中間結果 (检索处理(案件检索信息, file_db));
			// Calc calc = new AndCalc();
			// 最終結果list = calc.論理計算(最終結果list, 满足该案件的技术者IDList);

			// 多条案件的处理结果，他们之间的关系应该用【或】来计算
			最終結果list.addAll(满足该案件的技术者IDList);
		}
		return 最終結果list;
	}

	private Map<String, List<String>> get中間結果_by技術者検索Bean(技術者検索Bean bean) {

		Map<String,List<String>> 中間結果list = new HashMap();
		/**
			2、姓名;
			3、性别;
			4、生年月日_开始;       //大于等于
			5、生年月日_终了;       //小于等于
			6、最終卒業学校名;
			7、最終学位;
			8、卒業技能;
			9、会社名;
			10、TEL;
			11、FAX;
			12、最寄駅;
			13、就職開始年月_开始;       //大于等于
			14、就職開始年月_终了;       //小于等于
			15、日本語読み能力;
			16、日本語書き能力;
			17、日本語会話能力;
			18、日本語レベル_开始;       //大于等于
			19、日本語レベル_终了;       //小于等于
			20、英語読み能力;
			21、英語書き能力;
			22、英語会話能力;
			23、英検点数_开始;       //大于等于
			24、英検点数_终了;       //小于等于
			25、仕事_留学_経験有無;
			25、仕事_留学_経験開始年月_开始;       //大于等于
			26、仕事_留学_経験開始年月_终了;	       //小于等于
		 *
		 */
		if (StringUtils.isNotEmpty(bean.get姓名())) {
			中間結果list.put("姓名",getIDList_by小Map名andValue("姓名", bean.get姓名(), "like",file_db));
		}

		return 中間結果list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<技術者Bean> 取得検索結果_by最終結果(List<String> 最終結果idList) {

		List<技術者Bean> 技術者BeanList = new ArrayList();

		for (String 案件id : 最終結果idList) {

			技術者BeanList.add(取得技術者情報_by技術者id(案件id));
		}

		return 技術者BeanList;
	}

	private 技術者Bean 取得技術者情報_by技術者id(String 案件id) {

		Map<String, Map> 大Map = file_db.getMap_data();

		技術者Bean 技術者bean = new 技術者Bean();

		//案件bean.setS_ID(案件id);

		for (Map.Entry<String, Map> entry : 大Map.entrySet()) {

			if (entry == null) {

				continue;

			}

			Map<String, String> 小Map;

			String 小Map名 = entry.getKey();

			switch (小Map名) {

			case "姓名":
				小Map = entry.getValue();
		//		技術者bean.set案件名称(小Map.get(案件id));
				break;
			case "性别":
				小Map = entry.getValue();
		//		技術者bean.set案件概要(小Map.get(案件id));
				break;
			case "生年月日":
				小Map = entry.getValue();
		//		技術者bean.set作業開始年月日(小Map.get(案件id));
				break;
			case "会社名":
				小Map = entry.getValue();
		//		技術者bean.set案件場所(小Map.get(案件id));
				break;
			case "就職開始年月":
				小Map = entry.getValue();
		//		技術者bean.set募集人数(小Map.get(案件id));
				break;
			}
		}
		return 技術者bean;
	}
}
