package co.kr.fourteen.hjh2.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.hjh2.main.service.Jhj2MenuService;
import co.kr.fourteen.hjh2.main.vo.Jhj2MenuVo;

@Controller
@RequestMapping(value = "/jhj2/")
public class Jhj2MainController {

	@Autowired
	private Jhj2MenuService menuService;

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main(HttpSession session) {
		if(session.getAttribute("loginUser") == null) return "redirect:/jhj2/user/join";
		return "jhj2/main/main";
	}

	@RequestMapping(value = "menuList", method = RequestMethod.GET)
	public ModelAndView menuList() {
		ModelAndView mv = new ModelAndView("jhj2/menu/mainTopMenuList");
		List<Jhj2MenuVo> menuList = menuService.mainTopMenuList();
		mv.addObject("menuList", menuList);
		return mv;
	}

	@RequestMapping(value = "partner", method = RequestMethod.GET)
	public String partner() {
		return "jhj2/main/partner";
	}

}
