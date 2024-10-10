package co.kr.fourteen.jhj.oracle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.kr.fourteen.jhj.oracle.service.HyOracleService;
import co.kr.fourteen.jhj.oracle.vo.HyOracleVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HyOracleController {

	private final HyOracleService hyOracleService;

	@RequestMapping(value = "/hyOracleView")
	public String hyOracleView(Model model) {
		log.info(">>> 컨트롤러 진입");

		String phone = hyOracleService.selectUserInfo("test");
		log.info(">>> phone " + phone);

		model.addAttribute("result", phone);
		return "jhj/oracle/hyOracleView";
	}

	@RequestMapping(value="/hyOracleInput", method = RequestMethod.POST)
	public String hyOracleInput(@RequestParam String id, String name, String addr, String email, String phone) {
		log.info(">>> hyOracleInput 진입");
		log.info(">>> id : " + id);
		log.info(">>> name : " + name);
		log.info(">>> addr : " + addr);
		log.info(">>> email : " + email);
		log.info(">>> phone : " + phone);

		co.kr.fourteen.jhj.oracle.vo.HyOracleVo hyOracleVo = new HyOracleVo();

		hyOracleVo.setId(id);
		hyOracleVo.setName(name);
		hyOracleVo.setEmail(email);
		hyOracleVo.setPhone(phone);
		hyOracleVo.setAddr(addr);

		hyOracleService.insertUserInfo(hyOracleVo);

		return "jhj/oracle/hyOracleComplete";
	}
}
