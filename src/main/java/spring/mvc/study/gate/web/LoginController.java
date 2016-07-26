package spring.mvc.study.gate.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.study.vo.LoginVO;
import spring.mvc.study.vo.UserVO;

/**
 * @Class Name : LoginController.java
 * @Description : Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 김나라
 * @since 2016. 07.12
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
@RequestMapping("/gate/login")
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping(value = "/login.do")
	public String login(@ModelAttribute("loginVO") LoginVO loginVO, ModelMap model) throws Exception {
		
		LOGGER.info("LoginController.login START...");
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("LoginController.login START...");
		}
		
		return "gate/login";
	}
	
	@RequestMapping(value = "/actionLogin.do")
	public String actionLogin(@ModelAttribute("UserVO") UserVO userVO, HttpServletRequest request, ModelMap model) throws Exception {
		
		LOGGER.info("LoginController.actionLogin START...");
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("LoginController.actionLogin START...");
		}
		
		// TODO : 로그인한 정보가 맞는지 처리 필요.
		UserVO resultVO = new UserVO(); //loginService.selectUserDetail(userVO);
		
        if (resultVO != null && resultVO.getUser_id() != null && !resultVO.getUser_id().equals("")) {
        	
        	LoginVO loginVO = new LoginVO();
			loginVO.setUser_id(resultVO.getUser_id());
			loginVO.setUser_nm(resultVO.getUser_nm());
			loginVO.setGrp_gubun(resultVO.getGrp_gubun());
			loginVO.setStore_id(resultVO.getStore_id());

        	// 2-1. 로그인 정보를 세션에 저장
        	request.getSession().setAttribute("loginVO", loginVO);

    		return "redirect:/menu/list.do";

        } else {
        	//model.addAttribute("message", messageSource.getMessage("fail.common.login"));
        	//return "egovframework/mbl/com/uat/uia/EgovLoginUsr";
        	return "gate/login";
        }
	}
}
