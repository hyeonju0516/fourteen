package co.kr.fourteen.common.session.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionMgrController2 extends HandlerInterceptorAdapter {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override	// 컨트롤러/핸들러 객체를 실행하기 전에 필요한 기능을 구현할 때 사용한다 /가장 많이 사용
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean result = true;
		log.info(">>>>>>>>>>> 인터 셉터 2단계 <<<<<<<<<<<<  url :: " + request.getRequestURI());

		return result;
	}

	@Override	// 컨트롤러/핸들러가 정상적으로 실행된 이후에 추가기능을 구현할 때 사용한다/ 잘 안씀
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// log.info(">>>>>>>>>>> 인터 셉터 2단계 <<<<<<<<<<<<  url :: " + request.getRequestURI());
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// log.info(">>>>>>>>>>> 인터 셉터 3단계 <<<<<<<<<<<<  url :: " + request.getRequestURI());
		super.afterCompletion(request, response, handler, ex);
	}

}
