package co.kr.fourteen.seHyun.user.controller;

import co.kr.fourteen.seHyun.user.service.YshUserService;
import co.kr.fourteen.seHyun.user.vo.YshUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/ysh/user")
@Slf4j
public class YshUserController {

    @Autowired
    private YshUserService yshUserService;

    /**
     * @return String
     * @Method join
     * @Date 2024.05.21
     * @Writter seHyun
     * @EditHistory
     * @Descript 회원가입 진입
     */
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join() {
        log.info("join진입***");

        return "ysh/user/join";
    }

    /**
     * @return Map<String, Object>
     * @Method idDoubleCheck
     * @Date 2024.05.21
     * @Writter seHyun
     * @EditHistory
     * @Descript 아이디 중복체크
     * @Param String
     */
    @RequestMapping(value = "/idDoubleCheck", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> idDoubleCheck(@RequestParam String userId) {
        log.info("idDoubleCheck진입***");
        log.info("RequestParam userId ::" + userId);

        int result = yshUserService.idDoubleCheck(userId);
        log.info("yshUserService.idDoubleCheck(userId) 처리완료 ::" + result);

        /*HashMap<String, Object>() == HashMap<>()*/
        Map<String, Object> map = new HashMap<>();

        map.put("result", result);

        return map;
    }

    /**
     * @return String
     * @Method findId
     * @Date 2024.05.22
     * @Writter seHyun
     * @EditHistory
     * @Descript 아이디 찾기 진입
     */
    @RequestMapping(value = "/findId", method = RequestMethod.GET)
    public String findId() {
        log.info("findId 진입***");

        return "ysh/user/findId";
    }

    /**
     * @return ModelAndView
     * @Method findIdCheck
     * @Date 2024.05.22
     * @Writter seHyun
     * @EditHistory
     * @Descript 아이디 찾기
     * @Param String
     */
    @RequestMapping(value = "/findIdCheck", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView findIdCheck(@RequestParam String userName) {
        log.info("findIdCheck 진입***");
        log.info("RequestBody userName확인 ::" + userName);

        ModelAndView mv = new ModelAndView("JSON_VIEW");

        String result = yshUserService.findId(userName);
        log.info("yshUserService.findId(userName) 처리완료 ::" + result);

        mv.addObject("result", result);

        return mv;
    }

    /**
     * @return void
     * @Method userJoin
     * @Date 2024.05.30
     * @Writter seHyun
     * @EditHistory 0601 이메일+도메일 합쳐서 하나로 만듦
     * @Descript 회원가입
     * @Param YshUserVo
     */
    @RequestMapping(value = "/userJoin", method = RequestMethod.POST)
    @ResponseBody
    public void userJoin(YshUserVo vo) {
        log.info("userJoin진입***");
        log.info("RequestBody확인 :: " + vo);

        // 이메일 형식으로 변경. 이메일+도메일 합쳐서 Email 저장.
        vo.setUserEmail(vo.getUserEmail() + '@' + vo.getUserDomail());
        log.info("vo.setUserEmail확인 ::" + vo.getUserEmail());

        yshUserService.userJoin(vo);
        log.info("yshUserService.userJoin(vo) 처리완료 ::");
    }

    /**
     * @return String
     * @Method login
     * @Date 2024.05.30
     * @Writter seHyun
     * @EditHistory
     * @Descript 로그인 폼 진입
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        log.info("login진입***");

        return "ysh/user/login";
    }

    /**
     * @return YshUserVo
     * @Method loginRequest
     * @Date 2024.05.30
     * @Writter seHyun
     * @EditHistory
     * @Descript 로그인 시도
     */
    @RequestMapping(value = "/loginRequest", method = RequestMethod.POST)
    @ResponseBody
    public YshUserVo loginRequest(YshUserVo vo, HttpSession session) {
        log.info("loginRequest***");
        log.info("vo확인 ::" + vo);

        YshUserVo result = yshUserService.userLogin(vo);
        log.info("yshUserService.userLogin(vo) 처리완료 ::" + result);

        session.setAttribute("userId", result.getUserId());
        session.setAttribute("userNm", result.getUserNm());

        return result;
    }
}