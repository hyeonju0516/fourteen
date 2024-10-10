package co.kr.fourteen.taengEe.prac03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.fourteen.taengEe.prac03.service.KthPrac03Service;
import co.kr.fourteen.taengEe.prac03.vo.KthPrac03Vo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/kth/main/prac03")
public class KthPrac03Controller {

	@Autowired
	private KthPrac03Service kthPrac03Service;

	/**
	 * @Method add
	 * @Date 2024.05.01
	 * @Writter taengEe
	 * @EditHistory
	 * @Descript 유저 정보 입력 페이지 접속
	 * @param
	 * @return String
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "/kth/main/prac03/add";
	}

	/**
	 * @Method addInfo
	 * @Date 2024.05.01
	 * @Writter taengEe
	 * @EditHistory
	 * @Descript 유저 정보 입력 페이지 접속 시, DB에 데이터 전송
	 * @param
	 * @return String
	 */
	@RequestMapping(value = "/addInfo", method = RequestMethod.POST)
	@ResponseBody
	public String addInfo(KthPrac03Vo vo) {
		log.info("========> vo : " + vo);
		kthPrac03Service.addInfo(vo);

		return "ok";
	}

	/**
	 * @Method list
	 * @Date 2024.05.01
	 * @Writter taengEe
	 * @EditHistory
	 * @Descript 리스트 페이지 접속 시, 데이터 뿌리기
	 * @param Model
	 * @return String
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<KthPrac03Vo> list = kthPrac03Service.list();
		model.addAttribute("list", list);

		return "/kth/main/prac03/list";
	}

}
