package co.kr.fourteen.taengEe.login.controller;

import co.kr.fourteen.taengEe.login.service.KthLoginService;
import co.kr.fourteen.taengEe.login.vo.KthLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping(value = "/kth/login/")
public class KthLoginController {

    @Autowired
    private KthLoginService kthLoginService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        log.info("=========== 로그인 페이지 진입 :: ");
        return "kth/login/login";
    }

    @RequestMapping(value = "loginCheck", method = RequestMethod.POST)
    @ResponseBody
    public KthLoginVo loginCheck(KthLoginVo vo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String loginId = (request.getParameter("userId") != null ) ? request.getParameter("userId") : "";
        String password = (request.getParameter("userPw") != null ) ? request.getParameter("userPw") : "";
        log.info("=========== 아이디 비번" + vo);
        KthLoginVo isMember = kthLoginService.loginCheck(vo);
        if(BCrypt.checkpw(password, isMember.getUserPw()))
        session.setAttribute("userId", vo.getUserId());
        session.setAttribute("userNm", vo.getUserNm());
        return isMember;
    }
}
