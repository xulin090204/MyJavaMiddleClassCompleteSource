package com.mycompany.myapp.bean;

import java.util.List;

import lombok.Data;
@Data
public class 技術者検索Bean {
	String 姓名;
	String 性别;
	String 生年月日_开始;       //大于等于
	String 生年月日_终了;       //小于等于
	String 最終卒業学校名;
	String 最終学位;
	String 卒業技能;
	String 会社名;
	String TEL;
	String FAX;
	String 最寄駅;
	String 就職開始年月_开始;       //大于等于
	String 就職開始年月_终了;       //小于等于
	String 日本語読み能力;
	String 日本語書き能力;
	String 日本語会話能力;
	String 日本語レベル_开始;       //大于等于
	String 日本語レベル_终了;       //小于等于
	String 英語読み能力;
	String 英語書き能力;
	String 英語会話能力;
	String 英検点数_开始;       //大于等于
	String 英検点数_终了;       //小于等于
	String 仕事_留学_経験有無;
	String 仕事_留学_経験開始年月_开始;       //大于等于
	String 仕事_留学_経験開始年月_终了;	       //小于等于
	List 案件检索信息List;
	List 技術检索信息List;
}
