package co.kr.fourteen.ese.main.controller;

import co.kr.fourteen.ese.user.service.EseUserService;
import co.kr.fourteen.ese.user.vo.EseUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping(value="/ese/")
public class EseMainController {


	@Autowired
	private EseUserService eseUserService;

	/**
	* @Method eseMain
	* @Date 2024. 05. 08.
	* @Writter ese(어성은 )
	* @EditHistory
	* @Discript Seongeun Main Page.
	 * @param EseUserVo, HttpServletRequest, RedirectAttributes
	* @Return String
	*/
	@RequestMapping(value="main", method = RequestMethod.GET) // 주소호출
	public String eseMain(EseUserVo userVo, HttpServletRequest request, RedirectAttributes rttr) {
		log.info(">>>>>진입");

		HttpSession session = request.getSession();

		if (session == null) {
			return "ese/user/login";
		} else {
			return "ese/main/main";
		}
	}



}
