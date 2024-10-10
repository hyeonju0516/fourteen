package co.kr.fourteen.seHyun.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping(value = "/ysh")
public class YshMainController {

    /**
     * @return String
     * @Method main
     * @Date 2024.05.01
     * @Writter seHyun
     * @EditHistory 2024.05.30 main 페이지 진입시 session 정보 확인
     * @Descript 메인 홈 진입
     * @Param HttpSession
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(HttpSession session, Model model) {
        log.info("yshMain진입***");

        // main페이지 진입시 session에 담긴 값 보기 위해서
        String userId = (String) session.getAttribute("userId");
        String userNm = (String) session.getAttribute("userNm");
        log.info("session.getAttribute('userId') 확인 ::" + userId);
        log.info("session.getAttribute('userNm') 확인 ::" + userNm);

        if (userId != null && userNm != null) {
            // session에 userId, userNm 정보가 있을 경우 model에 저장
            // login 값이 true/false 경우에 따라 view 페이지 결과가 달라질 예정
            model.addAttribute("userId", userId);
            model.addAttribute("userNm", userNm);
            model.addAttribute("login", true);
            return "ysh/main/main";
        } else {
            return "ysh/main/main";
            //return "redirect:user/login";
        }
    }

    /**
     * @return String
     * @Method logout
     * @Date 2024.05.30
     * @Writter seHyun
     * @EditHistory
     * @Descript 메인 홈 진입
     * @Param HttpSession
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String logout(HttpSession session) {
        log.info("logout진입***");
        // 세션 값 초기화
        session.invalidate();

        return "로그아웃 성공!!";
    }
}