package co.kr.fourteen.hoseong.otp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@RequestMapping(value = "/khsOtp/")
public class KhsOtpController {
    /**
     * @Method googleOtpPop
     * @Date 2024. 06. 01.
     * @Writter gak098(곽호성)
     * @EditHistory
     * @Discript googleOtpPop Page.
     * @Return String
     */
    @RequestMapping(value={"", "login/googleOtpPop"}, method = RequestMethod.GET)
    public String googleOtpPop() {

        return "hoseong/otp/googleOtpPop";
    }

}
