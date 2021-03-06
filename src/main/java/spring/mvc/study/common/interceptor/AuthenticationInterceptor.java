package spring.mvc.study.common.interceptor;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import spring.mvc.study.common.annotation.Authentication;
import spring.mvc.study.vo.LoginVO;


public class AuthenticationInterceptor implements HandlerInterceptor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationInterceptor.class);
	

	@SuppressWarnings({ "rawtypes", "null" })
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("====================== Interceptor preHandle =========================");
			
			LOGGER.debug("[request.url] {}",request.getRequestURL());
			Enumeration enu = request.getParameterNames();
			String strName;

			while (enu.hasMoreElements()) {
				strName= (String) enu.nextElement();
				LOGGER.debug("[request.param] {} = {}",strName, request.getParameter(strName));
			}
		}
		
		Authentication auth = null;
		if(handler instanceof HandlerMethod) {
			auth = ((HandlerMethod) handler).getMethodAnnotation(Authentication.class);
			
			// "@Authentication(authentication=false)"
			boolean is_auth = (auth == null) ? true: auth.authentication();
			if(!is_auth)  return true;
			is_auth = true;
			
			LoginVO loginVO = null;
			
			if (RequestContextHolder.getRequestAttributes() != null) {
				if (RequestContextHolder.getRequestAttributes().getAttribute("loginVO", RequestAttributes.SCOPE_SESSION) != null) {
					loginVO = (LoginVO)RequestContextHolder.getRequestAttributes().getAttribute("loginVO", RequestAttributes.SCOPE_SESSION);
					
					if(LOGGER.isDebugEnabled()){
						LOGGER.debug("[SESSION.USERID] {}", loginVO.getUser_id() );
						LOGGER.debug("[SESSION.USERID] {}", loginVO.getUser_nm() );	
					}
				}
			}
			
			if(loginVO == null){
				ModelAndView modelAndView = new ModelAndView("redirect:/gate/login/login.do");
				throw new ModelAndViewDefiningException(modelAndView);
			}
			
		}
		
		
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("controller find...");	
		}
		
		return true;
	}
	
	@Override public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model) throws Exception {
		
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("====================== Interceptor postHandle =========================");
		}

	}

	@Override public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception { }

}
