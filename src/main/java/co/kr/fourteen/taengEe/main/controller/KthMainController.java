package co.kr.fourteen.taengEe.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.fourteen.taengEe.main.service.KthService;
import co.kr.fourteen.taengEe.main.vo.KthVo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class KthMainController {

	@Autowired
	private KthService kthService;

	@RequestMapping(value="/kth/main/main", method= RequestMethod.GET)
	public String kthMain() {
		return "kth/main/main";
	}

	@RequestMapping(value="/kth/sub01", method= RequestMethod.GET)
	public String kthSub01() {
		return "kth/main/sub01";
	}

	@RequestMapping(value="/kth/sub01", method= RequestMethod.POST)
	public String add(@RequestBody KthVo vo, Model model) {

		log.error("===========> vo : " + vo);

		return "kth/main/sub01";
	}

	@RequestMapping(value="/kth/list", method= RequestMethod.GET)
	public String getList(Model model) {

		List<KthVo> list = kthService.selectUserInfoList();

		model.addAttribute("list", list);
		return "kth/main/list";
	}

	@RequestMapping(value="/kth/main/join", method= RequestMethod.GET)
	public String join() {
		return "kth/main/join";
	}

//	@RequestMapping(value="requestCall/{rrrr}")
//	public String requestCall(@RequestBody String param, Model model) {
//		return "JSON_VIEW";
//	}
//
//	@RequestMapping(value="requestCall/{rrrr}")
//	public void requestCall2(@PathVariable(value="rrrr") String result, Model model) {
//		log.info("");
//	}
}
