package co.kr.fourteen.hoseong.menu.controller;

import co.kr.fourteen.hoseong.menu.service.KhsMenuService;
import co.kr.fourteen.hoseong.menu.vo.KhsMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/hoseong/")
public class KhsMenuController {

	@Autowired
	private KhsMenuService menuService;

	/**
	 * @Method hsMainTopMenuList
	 * @Date 2024. 05. 06.
	 * @Writter gak098(곽호성)
	 * @EditHistory
	 * @Discript HoSeong mainTopMenuList Page.
	 * @Return String
	 */
	@RequestMapping(value="hsMainTopMenuList")
	public String hsMainTopMenuList(Model model) {
		List<KhsMenuVo> khsMenuVo = menuService.hsMainTopMenuList();

		model.addAttribute("menuList", khsMenuVo);
		return "hoseong/fragment/hsMainTopMenuList";
	}

}
