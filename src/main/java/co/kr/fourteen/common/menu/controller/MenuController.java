package co.kr.fourteen.common.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.common.menu.service.MenuService;
import co.kr.fourteen.common.menu.vo.MenuVo;

@Controller
@RequestMapping(value="/menu/")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value="mainTopMenuList")
	public ModelAndView mainTopMenuList() {
		ModelAndView mv = new ModelAndView("cmm/menu/mainTopMenuList");
		List<MenuVo> menuVo = menuService.mainTopMenuList();
		mv.addObject("menuList", menuVo);
		return mv;
	}

}
