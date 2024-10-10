package co.kr.fourteen.seHyun.practice.main.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/sh/practice")
@Slf4j
public class ShPracticeController {

    /**
     * @Method home
     * @Date 2024.05.09
     * @Writter seHyun
     * @Descript 홈 진입
     * @EditHistory
     * @return String
     */
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String home() {
        log.info("home진입***");

        return "ysh/practice/home";
    }
}
