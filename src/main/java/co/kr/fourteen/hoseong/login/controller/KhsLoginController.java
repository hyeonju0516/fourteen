package co.kr.fourteen.hoseong.login.controller;

import co.kr.fourteen.hoseong.login.service.KhsLoginService;
import co.kr.fourteen.hoseong.user.vo.KhsUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping(value = "/khsLogin/")
public class KhsLoginController {

    @Autowired
    private KhsLoginService khsLoginService;

    /**
     * @Method userLogin
     * @Date 2024. 05. 25.
     * @Writter gak098(곽호성)
     * @EditHistory
     * @Discript login Page.
     * @Return String
     */
    @RequestMapping(value={"", "login"}, method = RequestMethod.GET)
    public String userLogin() { return "hoseong/login/login"; }

    /**
     * @Method userPostLogin
     * @Date 2024. 05. 29.
     * @Writter gak098(곽호성)
     * @EditHistory
     * @Discript login post Page.
     * @Return String
     */
    @RequestMapping(value="login", method = RequestMethod.POST)
    @ResponseBody
    public KhsUserVo userPostLogin(KhsUserVo vo, HttpSession session) {
        KhsUserVo resultVo = khsLoginService.selectLoginCheck(vo);

        session.setAttribute("userId", resultVo.getUserId());
        session.setAttribute("userLevel", resultVo.getUserLevel());
        return resultVo;
    }

    /**
     * @Method userLogin
     * @Date 2024. 05. 25.
     * @Writter gak098(곽호성)
     * @EditHistory
     * @Discript login Page.
     * @Return String
     */
    @RequestMapping(value={"", "login/googleOtpPop"}, method = RequestMethod.GET)
    public String googleOtpPop() {

        return "hoseong/otp/googleOtpPop";
    }

}
