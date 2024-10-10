package co.kr.fourteen.kcm.oracle.controller;

import org.springframework.stereotype.Controller;

import co.kr.fourteen.kcm.oracle.service.KcmoracleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor // @Autowired @Resource("") static이 아닌 final
@Slf4j
public class KcmoracleController {


	//@Autowired final 키워드를 빼줘야한다
	//@Resource("") // 자바에서 쓰는 lib
	private final KcmoracleService kcmoracleService;

	// 주소는 소문자로 시작한다
	//@RequestMapping(value="/main") // 주소호출
	//public String main() {
	// public String eseOracleView(Model model) {

//		log.info(">>>>>진입");
//
//		// String phone = eseoracleService.selectUserInfo("test");
//
//		// log.info(">>>>>> phone :: " + phone);
//		// model.addAttribute("result", phone);
//		return "ok";
//	}

}


