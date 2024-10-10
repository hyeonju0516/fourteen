package co.kr.fourteen.seHyun.practice.search.controller;

import co.kr.fourteen.seHyun.practice.search.service.YshSearchService;
import co.kr.fourteen.seHyun.practice.search.vo.YshSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value="/yshPractice/search")
@Slf4j
public class YshSearchController {

    @Autowired
    private YshSearchService yshSearchService;

    /**
     * @Method idSearch
     * @Date 2024.05.21
     * @Writter seHyun
     * @EditHistory
     * @Descript id검색 폼 진입
     * @return String
     */
    @RequestMapping(value="/idSearch", method=RequestMethod.GET)
    public String idSearch() {
        log.info("idSearch진입***");

        return "ysh/practice/search/idSearch";
    }

    /**
     * @Method idSearching
     * @Date 2024.05.21
     * @Writter seHyun
     * @EditHistory
     * @Descript id 조회하기 (사용가능여부)
     * @Param String
     * @return int
     */
    @RequestMapping(value="/idSearching", method=RequestMethod.GET)
    @ResponseBody
    public int idSearching(@RequestParam String userId) {
        log.info("idSearching진입***");
        log.info("RequestParam userId 확인 ::" + userId);

        return yshSearchService.idSearching(userId);
    }

    @RequestMapping(value="/idSearch/joinCheck", method=RequestMethod.GET)
    public String joinCheck() {
        log.info("joinCheck진입***");

        return "ysh/practice/search/check/joinCheck";
    }

    @RequestMapping(value="/idSearch/joinChecking", method=RequestMethod.GET)
    @ResponseBody
    public String joinChecking(@RequestParam String userNm) {
        log.info("joinChecking진입***");
        YshSearchVo vo = new YshSearchVo();
        vo.setIpAddr("123123");
        log.error("확인 :: {}", vo);
        log.info("RequestParam userName 확인 ::" + userNm);

        /*List<YshSearchVo> result = yshSearchService.joinChecking(userName);*/
        /*log.info("yshSearchService.joinChecking(userName) 처리완료 ::" + result);*/

        return "ab";
    }

    @RequestMapping(value="/idSearch/joinChecking", method=RequestMethod.POST)
    @ResponseBody
    public String postJoinChecking(@RequestBody YshSearchVo vo) {
        log.info("post***");

        log.error("확인 :: {}", vo);
        log.info("RequestParam userName 확인 ::" + vo);

        /*List<YshSearchVo> result = yshSearchService.joinChecking(userName);*/
        /*log.info("yshSearchService.joinChecking(userName) 처리완료 ::" + result);*/

        return "asdsad";
    }
}
