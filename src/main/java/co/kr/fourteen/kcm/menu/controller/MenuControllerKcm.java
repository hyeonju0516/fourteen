package co.kr.fourteen.kcm.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.kcm.menu.service.MenuServiceKcm;
import co.kr.fourteen.kcm.menu.vo.MenuVoKcm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/kcm/menu/")
public class MenuControllerKcm {

	@Autowired
	private MenuServiceKcm menuService;

	/**
	 * @Method mainTopMenuList
	 * @Date 2024. 06. 06
	 * @Writter KCM
	 * @EditHistory
	 * @Discript menu 띄우기
	 * @Return ModelAndView
	 */
	@RequestMapping(value="mainTopMenuListKCM")
	public ModelAndView mainTopMenuList() {
		ModelAndView mv = new ModelAndView("kcm/menu/mainTopMenuListKCM");
		List<MenuVoKcm> menuVo = menuService.mainTopMenuList();
		mv.addObject("menuList", menuVo);
		return mv;
	}

}
