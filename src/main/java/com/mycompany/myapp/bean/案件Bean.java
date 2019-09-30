package com.mycompany.myapp.bean;

import lombok.Data;

@Data

public class 案件Bean {


//	String 名称;  // 案件名称　例。XXX银行案件
//	String 概要;  // 案件概要　例，新商品追加に従っう画面追加対応
//	String 場所;  // 案件場所　例，茅場町
//	String 時期;  // 案件時期　例，３ヶ月
//	String 人数;  // 案件人数　例，３人
//	String 职种;  // 案件职种　例，PGPT
//	String 工程;  // 案件工程　例，開発・IT・ST・保守
//	String 开始时间;  // 案件开始时间　例，20190501
//	String old_名称;
//	String old_概要;
//	String old_場所;
//	String old_時期;
//	String old_人数;
//	String old_职种;
//	String old_工程;
//	String old_开始时间;
	String 案件ID;
	String 案件名称;
	String 案件概要;
	String 案件場所;
	String 担当職種;
	String 所在工程;
	String 作業開始年月日;
	String 作業预计终了年月; //主要应对提前退场、或者案件延期的情况
	String 作業实际终了年月;
	String 募集人数;
	String チーム人数;
	String 開発言語;
	String FrameWork;
	String ツール;
	String OS;
	String DB;

	String old_案件名称;
	String old_案件概要;
	String old_案件場所;
	String old_担当職種;
	String old_所在工程;
	String old_作業開始年月日;
	String old_作業预计终了年月;
	String old_作業实际终了年月;
	String old_募集人数;
	String old_チーム人数;
	String old_開発言語;
	String old_FrameWork;
	String old_ツール;
	String old_OS;
	String old_DB;



}