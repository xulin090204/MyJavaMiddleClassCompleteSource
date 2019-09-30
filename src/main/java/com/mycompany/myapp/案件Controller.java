package com.mycompany.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.bean.案件Bean;
import com.mycompany.myapp.bean.案件検索Bean;
import com.mycompany.myapp.service.impl.案件Service;

/**
 * Handles requests for the application home page.
 */
@Controller
public class 案件Controller {

	private static final Logger logger = LoggerFactory.getLogger(案件Controller.class);

	/**
	 * 这个函数可以让你绕开画面，直接执行你的contrller程序。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		案件Bean bean = new 案件Bean();
		bean.set案件名称("自动车保险");
		bean.set案件概要("案件概要");
		bean.set案件場所("場所");
		bean.set担当職種("職種");
		bean.set所在工程("所在工程");
		bean.set作業開始年月日("作業開始年月日");
		bean.set作業预计终了年月("作業预计终了年");
		bean.set作業实际终了年月("作業实际终了年月");
		bean.set募集人数("募集人数");
		bean.setチーム人数("チーム人数");
		bean.set開発言語("開発言語");
		bean.setFrameWork("FrameWork");
		bean.setツール("ツール");
		bean.setOS("setOS");
		bean.setDB("setDB");
		new 案件Controller().案件save(bean, null);
	}

	@RequestMapping(value = "/案件", method = RequestMethod.GET)
	public String 案件(Locale locale, Model model) {
		logger.info("call 案件");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("モード", "0");

		return "案件検索";
	}

	@RequestMapping(value = "案件search", method = RequestMethod.POST)
	@ResponseBody //将返回结果转成Json
	public List<案件Bean> 案件search(@RequestBody 案件検索Bean 検索bean) {//@RequestBody 将Json转成Java对象

		logger.info("call 案件search");

		案件Service 案件service = new 案件Service();

		return 案件service.検索案件_by検索Bean(検索bean);
	}

	@RequestMapping(value = "案件edit", method = RequestMethod.GET)
	public String 案件edit(案件Bean bean, Model model) {
		logger.info("call 案件edit");

		model.addAttribute("titleName", "案件編集");
		model.addAttribute("モード", "編集");
		model.addAttribute("案件ID", bean.get案件ID());
		model.addAttribute("案件名称", bean.get案件名称());
		model.addAttribute("案件概要", bean.get案件概要());
		model.addAttribute("案件場所", bean.get案件場所());
		model.addAttribute("担当職種", bean.get担当職種());
		model.addAttribute("所在工程", bean.get所在工程());
		model.addAttribute("作業開始年月日", bean.get作業開始年月日());
		model.addAttribute("作業预计终了年月", bean.get作業预计终了年月());
		model.addAttribute("作業实际终了年月", bean.get作業实际终了年月());
		model.addAttribute("募集人数", bean.get募集人数());

		return "案件明細";

	}

	@RequestMapping(value = "add案件", method = RequestMethod.GET)
	public ModelAndView add案件() {
		logger.info("call add案件");

		ModelAndView modelAndView1 = new ModelAndView("案件明細");
		modelAndView1.getModel().put("titleName", "案件追加");

		return modelAndView1;
	}

	@RequestMapping(value = "案件save", method = RequestMethod.POST)
	public String 案件save(@ModelAttribute("fbean") 案件Bean bean, Model model) {

		案件Service 案件service = new 案件Service();

		String sMsg = 案件service.追加案件_by案件Bean(bean);
		if (StringUtils.isEmpty(sMsg)) {
			return "案件検索";

		} else {
			model.addAttribute("titleName", "案件追加");
			model.addAttribute("案件ID", bean.get案件ID());
			model.addAttribute("案件名称", bean.get案件名称());
			model.addAttribute("案件概要", bean.get案件概要());
			model.addAttribute("案件場所", bean.get案件場所());
			model.addAttribute("担当職種", bean.get担当職種());
			model.addAttribute("所在工程", bean.get所在工程());
			model.addAttribute("作業開始年月日", bean.get作業開始年月日());
			model.addAttribute("作業预计终了年月", bean.get作業预计终了年月());
			model.addAttribute("作業实际终了年月", bean.get作業实际终了年月());
			model.addAttribute("募集人数", bean.get募集人数());

			return "案件明細";
		}
	}

	@RequestMapping(value = "案件update", method = RequestMethod.POST)
	public String 案件update(@ModelAttribute("fbean") 案件Bean bean, HttpSession session, Model model) {

		案件Service 案件service = new 案件Service();

		案件service.更新案件_by案件Bean(bean);
		model.addAttribute("モード", "1");

		return "案件検索";
	}

	@RequestMapping(value = "back案件検索", method = RequestMethod.POST)
	public String back案件検索() {

		return "案件検索";
	}
}
