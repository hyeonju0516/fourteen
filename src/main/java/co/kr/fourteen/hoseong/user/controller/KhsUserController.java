package co.kr.fourteen.hoseong.user.controller;

import co.kr.fourteen.hoseong.user.service.KhsUserService;
import co.kr.fourteen.hoseong.user.vo.KhsUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
@RequestMapping(value = "/khs/user/")
public class KhsUserController {

    @Autowired
    private KhsUserService khsUserService;

    /**
     * @Method userJoin
     * @Date 2024. 05. 18.
     * @Writter gak098(곽호성)
     * @EditHistory
     * @Discript 회원가입 Page.
     * @Return String
     */
    @RequestMapping(value="join", method = RequestMethod.GET)
    public String userJoin() { return "hoseong/user/join"; }

    /**
     * @Method userPostJoin
     * @Date 2024. 05. 25.
     * @Writter gak098(곽호성)
     * @EditHistory
     * @Discript 회원가입 Page.
     * @Return KhsuserVo
     */
    @RequestMapping(value="join", method = RequestMethod.POST)
    @ResponseBody
    public boolean userPostJoin(KhsUserVo vo) {
        boolean result = khsUserService.insertUser(vo);

        return result;
    }

    /**
     * @Method userIdCheck
     * @Date 2024. 05. 18.
     * @Writter gak098(곽호성)
     * @EditHistory
     * @Discript 회원가입 IdCheck Page.
     * @Return String
     */
    @ResponseBody
    @RequestMapping(value="join/idckeck", method = RequestMethod.GET)
    public int userIdCheck(@RequestParam String userId) {
        int result = khsUserService.selectUserIdCheck(userId);

        return result;
    }

}
