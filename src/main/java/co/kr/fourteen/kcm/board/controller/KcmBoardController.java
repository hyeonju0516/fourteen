package co.kr.fourteen.kcm.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/kcm/board/")
public class KcmBoardController {

	/**
	 * @Method kcmBoard
	 * @Date 2024. 06. 06
	 * @Writter KCM
	 * @EditHistory
	 * @Discript 게시판 진입
	 * @Return String
	 */
	@RequestMapping(value = "kcmBoard", method = RequestMethod.GET) // 주소호출
	public String kcmBoard() {
		return "kcm/board/board";
	}

}
