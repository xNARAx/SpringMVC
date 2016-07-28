package spring.mvc.study.menu.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.study.menu.service.MenuService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Value("#{comnProperties['comn.sample']}") String sampleProperties;
	
	@Autowired MenuService menuService;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String menuList(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "menu/list";
	}
	
	
	@RequestMapping(value = "/list.json", method = RequestMethod.GET)
	public @ResponseBody JsonResult  menuListJson(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

        Map resultMap = new HashMap();
        resultMap.put("list", 1);
        
        JsonResult jo = new JsonResult();
        jo.setResultMsg("성공");
        jo.setData(resultMap);
        
        return jo;
    }
	
	@RequestMapping(value = "/datalist.do", method = RequestMethod.GET)
	public String dataList(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		try {
			menuService.dataInsert();
			model.addAttribute("list", menuService.dataList() );
		} catch (Exception e) {
		     e.printStackTrace();
		}
		
		return "menu/list";
	}
    
    public class JsonResult {
    	String resultCode = "0000";
    	String resultMsg = "Success";
    	Object data;
    	
		public String getResultCode() {
			return resultCode;
		}
		public void setResultCode(String resultCode) {
			this.resultCode = resultCode;
		}
		public String getResultMsg() {
			return resultMsg;
		}
		public void setResultMsg(String resultMsg) {
			this.resultMsg = resultMsg;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
    }
}
