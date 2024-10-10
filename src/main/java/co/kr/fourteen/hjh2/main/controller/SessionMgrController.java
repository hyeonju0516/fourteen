package co.kr.fourteen.hjh2.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import co.kr.fourteen.hjh2.user.vo.Jhj2UserInfoVo;

public class SessionMgrController extends HandlerInterceptorAdapter {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info(">>>>>>>>>>> 인터 셉터 1단계 <<<<<<<<<<<<  url :: " + request.getRequestURI());
		/*boolean result = false, login 	= false;

		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login");
		Jhj2UserInfoVo user = (Jhj2UserInfoVo) obj;
		if(user != null) {
			login = true;
		}else {
			response.sendRedirect("/login");
		}*/

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

}
