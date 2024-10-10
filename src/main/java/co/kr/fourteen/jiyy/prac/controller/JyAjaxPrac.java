package co.kr.fourteen.jiyy.prac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.jiyy.prac.service.JyAjaxService;
import co.kr.fourteen.jiyy.prac.vo.PracAjaxVo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class JyAjaxPrac {

	@Autowired
	private JyAjaxService jyAjaxService;

	@RequestMapping(value = "/jyAjax", method = RequestMethod.GET)
		public String jyAjaxVeiw() {

		log.info("ajax뷰 진입");
		return "jiyy/prac/jyAjax2";
		}

	/**
	 * @Methid jyAjaxData
	 * @Date 2024.05.21
	 * @Descript ajax로 메뉴네임 출력해보기
	 * @param jyData
	 * @return List
	 */

	@RequestMapping(value = "/jyAjax/data", method = RequestMethod.GET)
	@ResponseBody
		public List<PracAjaxVo> jyAjaxData(@RequestParam(name="jyData") String jyData){
		log.info("지연데이터:::::"+ jyData);

		List<PracAjaxVo> result = jyAjaxService.dataResult(jyData);
		log.info("result:::"+ result);
		return result;
	}

	/**
	 * @Method jyUserIdCheck
	 * @Date 2024.05.23
	 * @Descript userId 중복체크
	 * @param userId
	 * @return ModelAndView
	 */

	@RequestMapping(value = "jyAjax/userId", method = RequestMethod.GET)
	@ResponseBody
		public ModelAndView jyUserIdCheck(@RequestParam(name="userId") String userId) {
		log.info("userIdCheck:::::"+ userId);
		ModelAndView mv = new ModelAndView("JSON_VIEW");
		boolean result = jyAjaxService.userIdCheck(userId);
		mv.addObject("result", result);
		log.info("result:::"+result);
		return mv;
	}
}
