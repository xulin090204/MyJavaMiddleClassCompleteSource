package com.mycompany.myapp;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.myapp.bean.技術者Bean;
import com.mycompany.myapp.bean.技術者検索Bean;
import com.mycompany.myapp.bean.案件Bean;
import com.mycompany.myapp.service.帳票Service;
import com.mycompany.myapp.service.impl.技術者Service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;

@Controller
public class 技術者Controller {

	private static final Logger logger = LoggerFactory.getLogger(技術者Controller.class);

	/**
	 * 这个函数可以让你绕开画面，直接执行你的contrller程序。
	 * @param args
	 */
	public static void main(String[] args) {
		技術者Bean 技術者bean = new 技術者Bean();

		Map<String,String> 案件情報map = new LinkedHashMap<String,String>();
		案件情報map.put("案件名称", "自动车保险");
		案件情報map.put("案件概要", "案件概要");
		案件情報map.put("案件場所", "場所");
		案件情報map.put("担当職種", "職種");
		案件情報map.put("所在工程", "所在工程");
		案件情報map.put("作業開始年月日", "作業開始年月日");
		案件情報map.put("作業预计终了年月", "業预计终了年月");
		案件情報map.put("作業实际终了年月", "作業实际终了年月");
		案件情報map.put("募集人数", "募集人数");
		案件情報map.put("チーム人数", "チーム人数");
		案件情報map.put("開発言語", "開発言語");
		案件情報map.put("FrameWork", "FrameWork");
		案件情報map.put("OS", "OS");
		案件情報map.put("DB", "DB");

		List 案件情報maplist = new ArrayList();
		案件情報maplist.add(案件情報map);
		技術者bean.set経験_案件情報(案件情報maplist);

		Map<String,String> 技術項目map = new LinkedHashMap<String,String>();
		技術項目map.put("技術方向", "技術方向");
		技術項目map.put("技術項目", "技術項目");
		技術項目map.put("资格_等级", "资格_等级");
		技術項目map.put("年数_开始年月", "年数_开始年月");
		技術項目map.put("備考説明", "備考説明");

		List 技術項目maplist = new ArrayList();
		技術項目maplist.add(技術項目map);
		技術者bean.set技術項目_情報(技術項目maplist);

		技術者bean.set技術者_社員CD("技術者_社員CD");
		技術者bean.set姓名("姓名");
		技術者bean.set性别("性别");
		技術者bean.set生年月日("生年月日");
		技術者bean.set最終卒業学校名("最終卒業学校名");
		技術者bean.set最終学位("最終学位");
		技術者bean.set卒業技能("卒業技能");
		技術者bean.set会社名("会社名");
		技術者bean.setTEL("TEL");
		技術者bean.setFAX("FAX");
		技術者bean.set最寄駅("最寄駅");
		技術者bean.set就職開始年月("就職開始年月");
		技術者bean.set日本語読み能力("日本語読み能力");
		技術者bean.set日本語書き能力("日本語書き能力");
		技術者bean.set日本語会話能力("日本語会話能力");
		技術者bean.set日本語レベル("日本語レベル");
		技術者bean.set英語読み能力("英語読み能力");

		技術者bean.set英語書き能力("英語書き能力");
		//技術者bean.set英語会話能力("英語会話能力");
		技術者bean.set英検点数("英検点数");
		技術者bean.set仕事_留学_経験有無("仕事_留学_経験有無");
		技術者bean.set仕事_留学_経験開始年月("仕事_留学_経験開始年月");

		new 技術者Controller().技術者save(技術者bean, null);
	}
	/**
	 *
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/技術者", method = RequestMethod.GET)
	public String 技術者(Locale locale, Model model) {
		logger.info("call 技術者");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("モード", "0");

		return "技術者検索"; // 技術者検索.jsp
	}

	@RequestMapping(value = "技術者edit", method = RequestMethod.GET)
	public String 技術者edit(案件Bean bean, Model model) {
		logger.info("call 案件edit");

//		model.addAttribute("titleName", "技術者編集");
//		model.addAttribute("モード", "編集");
//		model.addAttribute("s_ID", bean.getS_ID());
//		model.addAttribute("案件名称", bean.get案件名称());
//		model.addAttribute("案件概要", bean.get案件概要());
//		model.addAttribute("案件場所", bean.get案件場所());
//		model.addAttribute("担当職種", bean.get担当職種());
//		model.addAttribute("所在工程", bean.get所在工程());
//		model.addAttribute("作業開始年月日", bean.get作業開始年月日());
//		model.addAttribute("作業预计终了年月", bean.get作業预计终了年月());
//		model.addAttribute("作業实际终了年月", bean.get作業实际终了年月());
//		model.addAttribute("募集人数", bean.get募集人数());
System.out.println("");
		return "技術者明細";
	}


	@RequestMapping(value = "技術者save", method = RequestMethod.POST)
	public String 技術者save(@ModelAttribute("fbean") 技術者Bean bean, Model model) {

		技術者Service 技術者service = new 技術者Service();

		String sMsg = 技術者service.追加技術者_by技術者Bean(bean);
		if (StringUtils.isEmpty(sMsg)) {
			return "技術者検索";

		} else {
//			model.addAttribute("titleName", "案件追加");
//			model.addAttribute("s_ID", bean.getS_ID());
//			model.addAttribute("案件名称", bean.get案件名称());
//			model.addAttribute("案件概要", bean.get案件概要());
//			model.addAttribute("案件場所", bean.get案件場所());
//			model.addAttribute("担当職種", bean.get担当職種());
//			model.addAttribute("所在工程", bean.get所在工程());
//			model.addAttribute("作業開始年月日", bean.get作業開始年月日());
//			model.addAttribute("作業预计终了年月", bean.get作業预计终了年月());
//			model.addAttribute("作業实际终了年月", bean.get作業实际终了年月());
//			model.addAttribute("募集人数", bean.get募集人数());

			return "技術者明細";
		}
	}

    @RequestMapping(value="技術者report")
    @ResponseBody
    public String exportExcelTest(HttpServletResponse response, @ModelAttribute("fbean") 技術者Bean 技術者bean){
        // 获取workbook对象
        Workbook workbook = exportSheetByTemplate(技術者bean) ;
        // 判断数据
        if(workbook == null) {
            return "fail";
        }
        // 设置excel的文件名称
        // String excelName = "测试excel" ;
        String excelName = "report" ;
        // 重置响应对象
        response.reset();
        // 当前日期，用于导出文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH:mm:ss");
     //   String dateStr = "["+excelName+"-"+sdf.format(new Date())+"]";
        String dateStr = excelName+"-"+sdf.format(new Date());
        // 指定下载的文件名--设置响应头
        response.setHeader("Content-Disposition", "attachment;filename=" +dateStr+".xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 写出数据输出流到页面
        try {
            OutputStream output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            workbook.write(bufferedOutPut);
            bufferedOutPut.flush();
            bufferedOutPut.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "技術者明細";
    }

    /**
     * 模版单sheet导出示例
     * @return
     */
    public Workbook exportSheetByTemplate(技術者Bean 技術者bean){
        // 查询数据,此处省略
        // 设置导出配置
        // 获取导出excel指定模版
        TemplateExportParams params =
        		new TemplateExportParams(
        				"/Users/haoyan/Desktop/data/template/template技術者履歴書_kouyou.xlsx");
        // 标题开始行
        // params.setHeadingStartRow(0);
        // 标题行数
        // params.setHeadingRows(2);
        // 设置sheetName，若不设置该参数，则使用得原本得sheet名称
        // params.setSheetName("社員信息");
        params.setSheetName("sheet1");
        params.setColForEach(true);
        Map<String,Object> map = new HashMap<String,Object>() ;

        /**
         * 关于把数据到出到excle模版的问题，我也是瞎摸索了一番
         * 最后还是看到了帖子，得以解决：
         * https://note.youdao.com/ynoteshare1/index.html?id=26794c8eb4a285828663178c0ae854a2&type=note
         *     --20190407
         */
        map.put("作成日", "2019/04/01");
        map.put("姓名", 技術者bean.get姓名()==null?"":技術者bean.get姓名());
        map.put("性别", 技術者bean.get性别()==null?"":技術者bean.get性别());
        map.put("生年月日", 技術者bean.get生年月日()==null?"":技術者bean.get生年月日());
        map.put("最終卒業学校名", 技術者bean.get最終卒業学校名()==null?"":技術者bean.get最終卒業学校名());
        map.put("会社名", 技術者bean.get会社名()==null?"":技術者bean.get会社名());
        map.put("TEL", 技術者bean.getTEL()==null?"":技術者bean.getTEL());
        map.put("FAX", 技術者bean.getFAX()==null?"":技術者bean.getFAX());

        map.put("最寄駅", 技術者bean.get最寄駅()==null?"":技術者bean.get最寄駅());
        map.put("最終学位", 技術者bean.get最終学位()==null?"":技術者bean.get最終学位());
        map.put("就職開始年月", 技術者bean.getFAX()==null?"":技術者bean.get就職開始年月());
        map.put("日本語読み能力", 技術者bean.get日本語読み能力()==null?"":技術者bean.get日本語読み能力());
        map.put("日本語書き能力", 技術者bean.get日本語書き能力()==null?"":技術者bean.get日本語書き能力());
        map.put("日本語会話能力", 技術者bean.get日本語会話能力()==null?"":技術者bean.get日本語会話能力());
        map.put("日本語レベル", 技術者bean.get日本語レベル()==null?"":技術者bean.get日本語レベル());
        map.put("英語読み能力", 技術者bean.get英語読み能力()==null?"":技術者bean.get英語読み能力());
        map.put("英語書き能力", 技術者bean.get英語書き能力()==null?"":技術者bean.get英語書き能力());
        map.put("英語会話能力", 技術者bean.get英語会話能力()==null?"":技術者bean.get英語会話能力());
        map.put("英検点数", 技術者bean.get英検点数()==null?"":技術者bean.get英検点数());

        map.put("仕事_留学_経験有無", 技術者bean.get仕事_留学_経験有無()==null?"":技術者bean.get仕事_留学_経験有無());
        map.put("仕事_留学_経験開始年月", 技術者bean.get仕事_留学_経験開始年月()==null?"":技術者bean.get仕事_留学_経験開始年月());

//        map.put("OS技術項目1","Unix");
//        map.put("OS年数1","5");
//        map.put("OS技術項目2","Linux");
//        map.put("OS年数2","5");
//        map.put("OS技術項目3","Windows");
//        map.put("OS年数3","5");
//        map.put("OS技術項目4","Win2000/XP");
//        map.put("OS年数4","5");
//        map.put("OS技術項目5","");
//        map.put("OS年数5","");
//        map.put("OS技術項目6","");
//        map.put("OS年数6","");
//        map.put("OS技術項目7","");
//        map.put("OS年数7","");
//        map.put("OS技術項目8","");
//        map.put("OS年数8","");
//
//        map.put("DB技術項目1","SYBASE");
//        map.put("DB年数1","5");
//        map.put("DB技術項目2","Oracle");
//        map.put("DB年数2","5");
//        map.put("DB技術項目3","SQL Server");
//        map.put("DB年数3","5");
//        map.put("DB技術項目4","Access");
//        map.put("DB年数4","5");
//        map.put("DB技術項目5","MongoDB");
//        map.put("DB年数5","5");
//        map.put("DB技術項目6","PostgreSQL");
//        map.put("DB年数6","5");
//        map.put("DB技術項目7","MｙSQL");
//        map.put("DB年数7","5");
//        map.put("DB技術項目8","");
//        map.put("DB年数8","");
//
//        map.put("tool技術項目1","C");
//        map.put("tool年数1","5");
//        map.put("tool技術項目2","C++");
//        map.put("tool年数2","5");
//        map.put("tool技術項目3","C＃");
//        map.put("tool年数3","5");
//        map.put("tool技術項目4","ABAP");
//        map.put("tool年数4","5");
//        map.put("tool技術項目5","SQL");
//        map.put("tool年数5","5");
//        map.put("tool技術項目6","Excel");
//        map.put("tool年数6","5");
//        map.put("tool技術項目7","PL /SQL");
//        map.put("tool年数7","5");
//        map.put("tool技術項目8","PHP");
//        map.put("tool年数8","5");
//        map.put("tool技術項目9","JSP");
//        map.put("tool年数9","5");
//        map.put("tool技術項目10","JavaScript");
//        map.put("tool年数10","5");
//        map.put("tool技術項目11","HTML");
//        map.put("tool年数11","5");
//        map.put("tool技術項目12","VB.net");
//        map.put("tool年数12","5");
//        map.put("tool技術項目13","Java");
//        map.put("tool年数13","5");
//        map.put("tool技術項目14","SALESFORCE");
//        map.put("tool年数14","5");
//        map.put("tool技術項目15","VBScript");
//        map.put("tool年数15","5");
//        map.put("tool技術項目16","");
//        map.put("tool年数16","");
//
//        map.put("業種技術項目1","建設業");
//        map.put("業種年数1","");
//        map.put("業種技術項目2","官公庁・自治体");
//        map.put("業種年数2","");
//        map.put("業種技術項目3","製造業");
//        map.put("業種年数3","5");
//        map.put("業種技術項目4","流通業");
//        map.put("業種年数4","5");
//        map.put("業種技術項目5","ゲーム");
//        map.put("業種年数5","");
//        map.put("業種技術項目6","小売業");
//        map.put("業種年数6","");
//        map.put("業種技術項目7","金融・保険");
//        map.put("業種年数7","5");
//        map.put("業種技術項目8","");
//        map.put("業種年数8","");
//
//        map.put("業務技術項目1","財務会計");
//        map.put("業務年数1","5");
//        map.put("業務技術項目2","生産管理");
//        map.put("業務年数2","5");
//        map.put("業務技術項目3","人事・給与");
//        map.put("業務年数3","5");
//        map.put("業務技術項目4","販売・物流");
//        map.put("業務年数4","5");
//        map.put("業務技術項目5","組込みソフト");
//        map.put("業務年数5","5");
//        map.put("業務技術項目6","イメージ・画像処理");
//        map.put("業務年数6","5");
//        map.put("業務技術項目7","POSシステム");
//        map.put("業務年数7","5");
//        map.put("業務技術項目8","セキュリティ");
//        map.put("業務年数8","5");
//        map.put("業務技術項目9","認証");
//        map.put("業務年数9","5");
//        map.put("業務技術項目10","品質管理");
//        map.put("業務年数10","5");
//        map.put("業務技術項目11","環境管理");
//        map.put("業務年数11","5");
//        map.put("業務技術項目12","制御処理");
//        map.put("業務年数12","5");
//        map.put("業務技術項目13","性能評価");
//        map.put("業務年数13","5");
//        map.put("業務技術項目14","DB構築");
//        map.put("業務年数14","5");
//        map.put("業務技術項目15","LAN/NW構築");
//        map.put("業務年数15","5");
//        map.put("業務技術項目16","");
//        map.put("業務年数16","");
        帳票Service 帳票service = new 帳票Service();
        map = 帳票service.取得技术者简历出力信息(技術者bean, map);

        List<案件Bean> 案件list = new ArrayList<案件Bean>();
        案件Bean 案件bean = new 案件Bean();
        案件bean.set案件名称("1");
        案件bean.set案件概要("DB");
        案件bean.set案件場所("PostgreSQL");
        案件bean.set担当職種("1级");
        案件bean.set所在工程("201801");
        案件bean.set作業開始年月日("1");
        案件bean.set作業開始年月日("1");
        案件list.add(案件bean);
        // 导出excel
        return ExcelExportUtil.exportExcel(params, map);
    }

	@RequestMapping(value = "技術者search", method = RequestMethod.POST)
	@ResponseBody //将返回结果转成Json
	public List<技術者Bean> 技術者search(@RequestBody 技術者検索Bean 検索bean) {//@RequestBody 将Json转成Java对象

		logger.info("call 技術者search");

		技術者Service 技術者service = new 技術者Service();

		return 技術者service.検索技術者_by検索Bean(検索bean);
	}
}
