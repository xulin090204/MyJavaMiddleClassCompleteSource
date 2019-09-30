package com.mycompany.myapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.mycompany.common.PROPERTY;
import com.mycompany.myapp.bean.技術者Bean;

public class 帳票Service {
	final static int OS技術項目 = 0;
	final static int DB技術項目 = 1;
	final static int tool技術項目 = 2;
	final static int 業種技術項目 = 3;
	final static int 業務技術項目 = 4;

	// 初始的时候都是0
	int[] 出力項目计数器 = new int[]{0,0,0,0,0};
	// 每个项目最多出力数
	int[] max出力項目计数器 = new int[]{8,8,16,8,16};

	public Map 取得技术者简历出力信息(技術者Bean 技術者bean, Map<String, Object> 出力信息Map) {

		// 取这个人的所有【技术项目信息】
		// 循环读入每个【技术项目信息】
		for(Map<String, Object> 技術項目map:技術者bean.get技術項目_情報()) {

			// 对每个【技术项目信息】做分类判断
			int iType = 对每个技术项目信息做分类判断(技術項目map);

			// 设置【出力信息Map】
			设置出力信息Map(iType, 出力信息Map);

			// 分别给每个分类设置计数器。
			更新出力項目计数器(iType);

		// 循环结束
		}
		// 循环取得每个出力项目的计数器。
		// 如果未达到出力数字，需要补充项目（使简历看上去饱满）
		// 循环结束
		// 返回【出力信息Map】
		return 出力信息Map;
	}

	private void 更新出力項目计数器(int iType) {
		switch(iType) {
		case 0:
			出力項目计数器[0] = 出力項目计数器[0]+1;
			break;
		case 1:
			出力項目计数器[1] = 出力項目计数器[1]+1;
			break;
		case 2:
			出力項目计数器[2] = 出力項目计数器[2]+1;
			break;
		case 3:
			出力項目计数器[3] = 出力項目计数器[3]+1;
			break;
		case 4:
			出力項目计数器[4] = 出力項目计数器[4]+1;
			break;
		}
	}

	/**
	 * 设置出力信息Map
	 * @param iType iOS技術項目=0  iDB技術項目=1 tool技術項目=2 業種技術項目=3 業務技術項目=4
	 * @param 出力信息Map
	 */
	private void 设置出力信息Map(int iType, Map 出力信息Map) {
		switch(iType){
		case OS技術項目:
			出力信息Map.put("OS技術項目".concat(出力項目计数器[OS技術項目]+1+""), 经验程度判断(iType, 出力信息Map));
			break;
		case DB技術項目:
			出力信息Map.put("OS技術項目".concat(出力項目计数器[DB技術項目]+1+""), 经验程度判断(iType, 出力信息Map));
			break;
		case tool技術項目:
			出力信息Map.put("OS技術項目".concat(出力項目计数器[tool技術項目]+1+""), 经验程度判断(iType, 出力信息Map));
			break;
		case 業種技術項目:
			出力信息Map.put("OS技術項目".concat(出力項目计数器[業種技術項目]+1+""), 经验程度判断(iType, 出力信息Map));
			break;
		case 業務技術項目:
			出力信息Map.put("OS技術項目".concat(出力項目计数器[業務技術項目]+1+""), 经验程度判断(iType, 出力信息Map));
			break;
		}
	}
	private String 经验程度判断(int iType, Map 出力信息Map) {
		switch(iType){
		case OS技術項目:
		case DB技術項目:
		case tool技術項目:
		case 業種技術項目:
		case 業務技術項目:
//			出力信息Map.put("OS技術項目".concat(出力項目计数器[OS技術項目]+1+""), 经验程度判断(iType, 出力信息Map));
//			if(取得经验年数(出力信息Map.get("开始年月"))) {
//				return "◎";
//			}
//			if(is有自信(出力信息Map.get(""))) {
//				return "○";
//			}
//			if(is没什么自信(出力信息Map.get(""))) {
//				return "△";
//			}
			switch(取得经验月数(出力信息Map.get("开始年月"))){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				return "△";
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				return "○";
			default:
				return "◎";
			}
		}
		return "";
	}

	private int 取得经验月数(Object object) {
		if (! (object instanceof String)) return 0;
		// 先取得经验月数
		int iMonth = 取得距今月数((String) object);

		return iMonth;
	}

	private int 取得距今月数(String sDate) {
		// 以防出现yyyy/MM的情况
		// 也防止出现 yyyyMMdd的情况
		sDate.replace("/", "");
		String sFromDate = sDate.length()==10?sDate:sDate.concat("01");
		// 开始时间都是从01日开始算的。
		int days = 0;
		try {
			days = daysBetween(new SimpleDateFormat("yyyyMMdd").parse(sFromDate), new Date());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days / 30;
	}

	/**
	 *
	 * @param 技術項目map 每个技术项目有5个值，参照【技術情報Bean】
	 * @return
	 */
	private int 对每个技术项目信息做分类判断(Map<String,Object> 技術項目map) {
		/*
		No	技术方向			出力项目	每个项目最多
		1	OS	的话，就是		OS技術項目	8
		2	DB	的话，就是		DB技術項目	8
		3	ツール	的话，就是		tool技術項目	16
		4	建設業 	等存在的话，就是		業種技術項目	8
		5	財務会計 	等存在的话，就是		業務技術項目	16
		*/
		List<String> os技術方向 = PROPERTY.取得OS技术方向项目名();
		List<String> db技術方向 = PROPERTY.取得DB技术方向项目名();
		List<String> tool技術方向 = PROPERTY.取得tool技术方向项目名();
		List<String> 業種技術方向 = PROPERTY.取得業種技术方向项目名();
		List<String> 業務技術方向 = PROPERTY.取得業務技术方向项目名();
		List 技術方向List= (List)技術項目map.get("技術方向");
		String s技術方向 = null;
		if( !CollectionUtils.isEmpty(技術方向List)) {
			s技術方向 = (String) 技術方向List.get(0);
		}
		if (os技術方向.contains(s技術方向)){
			return OS技術項目;
		}
		if (db技術方向.contains(s技術方向)){
			return DB技術項目;
		}
		if (tool技術方向.contains(s技術方向)){
			return tool技術項目;
		}
		if (業種技術方向.contains(s技術方向)){
			return 業種技術項目;
		}
		if (業務技術方向.contains(s技術方向)){
			return 業務技術項目;
		}

		// 如果未登陆就算做Tool一类
		return tool技術項目;
	}


   public static final int daysBetween(Date early, Date late) {

       java.util.Calendar calst = java.util.Calendar.getInstance();
       java.util.Calendar caled = java.util.Calendar.getInstance();
       calst.setTime(early);
        caled.setTime(late);
        //设置时间为0时
        calst.set(java.util.Calendar.HOUR_OF_DAY, 0);
        calst.set(java.util.Calendar.MINUTE, 0);
        calst.set(java.util.Calendar.SECOND, 0);
        caled.set(java.util.Calendar.HOUR_OF_DAY, 0);
        caled.set(java.util.Calendar.MINUTE, 0);
        caled.set(java.util.Calendar.SECOND, 0);
       //得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
               .getTime().getTime() / 1000)) / 3600 / 24;

       return days;
  }
}
