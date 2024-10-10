package co.kr.fourteen.taengEe.freeBoard.controller;

import co.kr.fourteen.taengEe.freeBoard.service.KthFreeBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@RequestMapping(value = "/kth/freeBoard/")
public class KthFreeBoardController {

    @Autowired
    private KthFreeBoardService kthFreeBoardService;

    @RequestMapping(value = "freeBoard", method = RequestMethod.GET)
    public String freeBoard() {
        return "kth/freeBoard/freeBoard";
    }
}
