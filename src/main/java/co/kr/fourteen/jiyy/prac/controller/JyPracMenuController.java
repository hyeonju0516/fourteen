package co.kr.fourteen.jiyy.prac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.jiyy.prac.service.JyPracMenuService;
import co.kr.fourteen.jiyy.prac.service.PracAjaxService;
import co.kr.fourteen.jiyy.prac.vo.PracAjaxVo;
import co.kr.fourteen.jiyy.prac.vo.topMenuPracVo;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/jyprac")
@Slf4j
public class JyPracMenuController {

	@Autowired
	private JyPracMenuService jyPracMenuService;

	@Autowired
	private PracAjaxService pracAjaxService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String mainHomeView () {
		log.info("메인 홈 진입");
		return "jiyy/prac/home";
	}

	/**
	 * @Method headerMenuAndView
	 * @Date 2024.05.14
	 * @Writter JiYeon
	 * @Description headerMenu출력
	 * @EditHistory
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/headerMenu", method = RequestMethod.GET)
	public ModelAndView headerMenuAndView () {
		ModelAndView mv = new ModelAndView("jiyy/prac/pracMenuList");
		List<topMenuPracVo> list = jyPracMenuService.headerMenuView();
		mv.addObject("menuList",list);
		return mv;
	}

	@RequestMapping(value = "/pracAjax", method = RequestMethod.GET)
	public String pracAjax() {
		log.info("pracAjax 홈진입");
		return "jiyy/prac/pracAjax";
	}

	@RequestMapping(value = "/resultData", method = RequestMethod.POST)
	@ResponseBody
	public List<PracAjaxVo> resultData(@RequestParam(name="data") String data) {
		log.info("결과 진입");
		log.info("RequestParam Data확인::" + data);

		List<PracAjaxVo> list = pracAjaxService.selectList(data);
		log.info("pracAjaxService.selectList(data) 처리결과::" + list);

		return list;
	}


}
