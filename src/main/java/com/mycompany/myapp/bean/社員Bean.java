package com.mycompany.myapp.bean;

import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data

public class 社員Bean implements Serializable{
	String s_ID; //唯一标识，无法替代，只做存根

	/**
	 * 加@Excel(name="番号", orderNum="1")
	 * 是为了从模版取值
	 * 参照 https://www.jianshu.com/p/da948d527a83
	 *
	 * 因为今后一定会采用从Excel模版取值的技术。
	 *  --20190407
	 */
	@Excel(name="番号", orderNum="1")
	String 番号;
	@Excel(name="姓名", orderNum="2")
	String 姓名;
	@Excel(name="電話番号", orderNum="3")
	String 電話番号;
	@Excel(name="性別", orderNum="4")
	String 性別;
	@Excel(name="生年月日", orderNum="5")
	String 生年月日;
	@Excel(name="入社年月日", orderNum="6")
	String 入社年月日;
	@Excel(name="契約種類", orderNum="7")
	String 契約種類;

	String old_番号;
	String old_姓名;
	String old_電話番号;
	String old_性別;
	String old_生年月日;
	String old_入社年月日;
	String old_契約種類;
}
