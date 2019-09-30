package com.mycompany.myapp.bean;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * 对于一个画面，一个bean就叫Form
 * 对于一个DAO，一个bean就叫DTO
 * @author haoyan
 *
 */
@Data
public class 技術者Bean {

	String 技術者ID;           				// 唯一标示

	List<String> 技術項目_ID;					// 可以有很多技术方向，例如OS，DB等等
	//Map<String,List<String>> 技术项目_情報;
	List<Map<String,Object>> 技術項目_情報; 	// 每个技术方向，可以有很多项目，例如OS，可以会windows，也可以会Linux
											// 每个技术项目, 都有自己的所属方向，和实绩时间
											// List<List<String>>的String是技术方向名，例如OS，DB
											//                           是技术项目名、实绩时间、等级、等等

	List<String> 経験_案件ID;   				// 对应案件信息，一名技术者通常会有多项案件経験，属于1对N的关系
	//Map<String,List<String>> 経験_案件情報;
	List<Map<String,String>> 経験_案件情報;	// List<List<String>>的String是案件名称、场所、概要、等等
	String 技術者_社員CD;      				// 对应社員信息

	String 姓名; 							// 技术者简历表示名，一般是简写
	String 性别;								// 与社員信息重复
	String 生年月日;							// 与社員信息重复
	String 最終卒業学校名;
	String 最終学位;
	String 卒業技能;

	String 会社名;
	String TEL;
	String FAX;
	String 最寄駅;
	String 就職開始年月;
	String 日本語読み能力;
	String 日本語書き能力;
	String 日本語会話能力;
	String 日本語レベル;
	String 英語読み能力;
	String 英語書き能力;
	String 英語会話能力;
	String 英検点数;
	String 仕事_留学_経験有無;
	String 仕事_留学_経験開始年月;
}
