package co.kr.fourteen.seHyun.menu.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.seHyun.menu.service.YshMenuService;
import co.kr.fourteen.seHyun.menu.vo.YshMenuVo;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="/ysh/menu")
@Slf4j
public class YshMenuController {

	@Autowired
	public YshMenuService yshMenuService;


	/**
	 * @Method mainTopMenuList
	 * @Date 2024.05.05
	 * @Writter seHyun
	 * @EditHistory
	 * @Descript 메인 상단 메뉴리스트 뿌리기
	 * @return ModelAndView
	 */
	@RequestMapping(value="/mainTopMenuList", method=RequestMethod.GET)
	public ModelAndView mainTopMenuList() {
		log.info("mainTopMenuList진입***");

		ModelAndView mv = new ModelAndView("ysh/menu/mainTopMenuList");
		List<YshMenuVo> menuVo = yshMenuService.mainTopMenuList();
		log.info("yshMenuService.mainTopMenuList() 처리완료::" + menuVo);

		mv.addObject("menuList", menuVo);

		return mv;
	}

	/**
	 * @Method yshCeoGreeting
	 * @Date 20204.05.15
	 * @Writter seHyun
	 * @EditHistory
	 * @Descript CEO인사말 보기
	 * @return String
	 */
	@RequestMapping(value="/sub/yshCeoGreeting", method=RequestMethod.GET)
	public String yshCeoGreeting() {
		log.info("yshCeoGreeting진입***");

		return "ysh/menu/sub/yshCeoGreeting";
	}

	/**
	 * @Method seHyunBoard
	 * @Date 2024.05.06
	 * @Writter seHyun
	 * @EditHistory
	 * @Descript 세현게시판 진입
	 * @return String
	 */
	@RequestMapping(value="/yshBoard", method=RequestMethod.GET)
	public String seHyunBoard() {
		log.info("yshBoard***");

		return "ysh/menu/yshBoard";
	}

	/**
	 * @Method yshNotice
	 * @Date 2024.05.06
	 * @Writter seHyun
	 * @EditHistory
	 * @Descript 공지사항게시판 진입
	 * @return String
	 */
	@RequestMapping(value="/sub/yshNotice", method=RequestMethod.GET)
	public String yshNotice() {
		log.info("yshNotice진입***");

		return "ysh/menu/sub/yshNotice";
	}

	/**
	 * @Method yshInquire
	 * @Date 2024.05.06
	 * @Writter seHyun
	 * @EditHistory
	 * @Descript 문의게시판 진입
	 * @return String
	 */
	@RequestMapping(value="/sub/yshInquire", method=RequestMethod.GET)
	public String yshInquire() {
		log.info("yshInquire진입***");

		return "ysh/menu/sub/yshInquire";
	}
}
