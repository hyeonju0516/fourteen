package co.kr.fourteen.hoseong.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/hoseong/")
public class KhsMainController {

	/**
	* @Method hoMain
	* @Date 2024. 04. 29.
	* @Writter gak098(곽호성)
	* @EditHistory
	* @Discript main Page.
	* @Return String
	*/
	@RequestMapping(value="hoMain", method = RequestMethod.GET)
	public String hoMain() {
		return "hoseong/main/hoMain";
	}

	/**
	* @Method hoseongHome
	* @Date 2024. 04. 29.
	* @Writter gak098(곽호성)
	* @EditHistory
	* @Discript home Page.
	* @Return String
	*/
	@RequestMapping(value="main/hoseongHome", method = RequestMethod.GET)
	public String hoseongHome() {
		return "hoseong/main/hoseongHome";
	}

	/**
	 * @Method hsMain
	 * @Date 2024. 05. 04.
	 * @Writter gak098(곽호성)
	 * @EditHistory
	 * @Discript home Page.
	 * @Return String
	 */
	@RequestMapping(value="main/hsMain", method = RequestMethod.GET)
	public String hsMain() {
		return "hoseong/main/hsMain";
	}
}
