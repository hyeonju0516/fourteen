package co.kr.fourteen.taengEe.user.controller;

import co.kr.fourteen.taengEe.user.service.KthUserService;
import co.kr.fourteen.taengEe.user.vo.KthUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/kth/user/")
@Slf4j
public class KthUserController {

    @Autowired
    private KthUserService kthUserService;

    @RequestMapping(value = "join", method = RequestMethod.GET)
    public String join() {
        return "kth/user/join";
    }

    @RequestMapping(value = "join02", method = RequestMethod.GET)
    public String join02() {
        return "kth/user/join02";
    }

    @RequestMapping(value = "doubleCheckId", method = RequestMethod.GET)
    @ResponseBody
    public String doubleCheckId(@RequestParam String userId) {
        log.info("==========> id : " + userId);
        boolean result = kthUserService.doubleCheckId(userId);
        String isOk = "";
        if(result) isOk = "1";
        else isOk = "0";
        return isOk;
    }

    @RequestMapping(value = "doubleCheckId2", method = RequestMethod.GET)
    @ResponseBody
    public int doubleCheckId2(@RequestParam String userId) {
        log.info("==========> " + userId);
        boolean result = kthUserService.doubleCheckId2(userId);
        int isOk;
        if(!result) isOk = 1;
        else isOk = 0;
        return isOk;
    }

    @RequestMapping(value = "joinCheck", method = RequestMethod.POST)
    @ResponseBody
    public String joinCheck(KthUserVo vo) {
        log.info("==========> vo : " + vo);
        kthUserService.joinCheck(vo);
        return "ok";
    }



//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String login() {
//        return "kth/user/login";
//    }

//    @RequestMapping(value = "joinCheck", method = RequestMethod.POST)
//    @ResponseBody
//    public String joinCheck(KthUserVo vo) {
//        log.info("==========> vo : " + vo);
//
//        return "";
//    }
}
