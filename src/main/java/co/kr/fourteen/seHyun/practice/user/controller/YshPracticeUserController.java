package co.kr.fourteen.seHyun.practice.user.controller;

import co.kr.fourteen.seHyun.practice.user.service.YshPracticeUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/yshPractice/user")
@Slf4j
public class YshPracticeUserController {

    @Autowired
    private YshPracticeUserService yshPracticeUserService;

    /**
     * @return String
     * @Method joinBool
     * @Date 2024.05.19
     * @Writter seHyun
     * @EditHistory
     * @Descript 회원가입 진입
     */
    @RequestMapping(value = "/joinBool", method = RequestMethod.GET)
    public String joinBool() {
        log.info("joinBool진입***");

        return "ysh/practice/user/joinBool";
    }

    /**
     * @return Boolean
     * @Method idDoubleCheckBool
     * @Date 2024.05.20
     * @Writter seHyun
     * @EditHistory
     * @Descript 회원가입 시 ID중복체크
     * @Param String
     */
    @RequestMapping(value = "/idDoubleCheckBool", method = RequestMethod.GET)
    @ResponseBody
    public Boolean idDoubleCheckBool(@RequestParam String userId) {
        log.info("idDoubleCheckBool진입***");
        log.info("RequestParam 확인 ::" + userId);

        boolean result = yshPracticeUserService.idDoubleCheckBool(userId);
        log.info("yshUserService.idDoubleCheckBool(userId) 처리완료 ::" + result);

        return result;
    }

    /**
     * @return String
     * @Method joinInt
     * @Date 2024.05.20
     * @Writter seHyun
     * @EditHistory
     * @Descript 회원가입 진입
     */
    @RequestMapping(value = "/joinInt", method = RequestMethod.GET)
    public String joinInt() {
        log.info("joinInt진입***");

        return "ysh/practice/user/joinInt";
    }

    /**
     * @return int
     * @Method idDoubleCheckInt
     * @Date 2024.05.20
     * @Writter seHyun
     * @EditHistory
     * @Descript 회원가입 시 ID중복체크
     * @Param Map
     */
    @RequestMapping(value = "/idDoubleCheckInt", method = RequestMethod.GET)
    @ResponseBody
    public int idDoubleCheckInt(@RequestParam Map<String, String> request) {
        log.info("idDoubleCheckInt진입***");
        log.info("RequestBody확인 ::" + request);

        String userId = request.get("userId");

        int result = yshPracticeUserService.idDoubleCheckInt(userId);
        log.info("yshUserService.idDoubleCheckInt(userId) 처리완료 ::" + result);

        return result;
    }
}
