package co.kr.fourteen.ese.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.fourteen.ese.oracle.service.EseOracleService;
import lombok.extern.slf4j.Slf4j;

@Controller
//@RequiredArgsConstructor // @Autowired @Resource("") static이 아닌 final
@Slf4j
@RequestMapping(value="/oraclaMain/")
public class EseOracleController {


	@Autowired //final 키워드를 빼줘야한다
	//@Resource("") // 자바에서 쓰는 lib
	private EseOracleService eseoracleService;

	// 주소는 소문자로 시작한다
	@RequestMapping(value="eseOracleMain", method = RequestMethod.GET) // 주소호출
	public String eseOracleView() {
		log.info(">>>>>진입");
		return "ese/main/main";
	}

}
