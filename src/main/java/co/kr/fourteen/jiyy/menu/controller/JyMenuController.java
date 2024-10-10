package co.kr.fourteen.jiyy.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.jiyy.menu.service.JyMenuService;
import co.kr.fourteen.jiyy.menu.vo.JyMenuVo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/jyMenu")
public class JyMenuController {

	@Autowired
	private JyMenuService jyMenuService;

	@RequestMapping(value = "/mainTopMenu", method = RequestMethod.GET)
	public ModelAndView meinTopMenu() {
		ModelAndView mv = new ModelAndView("jiyy/include/mainTopMenu");
		//변수에 view를 담아서 사용할 수 있다.데이터와 뷰를 모두 반환.
		List<JyMenuVo> menuVo = jyMenuService.mainTopMenu();
		mv.addObject("mnList",menuVo);
		log.info("mnList"+ menuVo);
		return mv;
	}
}
