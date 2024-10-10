package co.kr.fourteen.seHyun.practice.menu.controller;

import co.kr.fourteen.seHyun.practice.menu.service.ShPracticeMenuService;
import co.kr.fourteen.seHyun.practice.menu.vo.ShPracticeMenuVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value="/sh/practice/menu")
@Slf4j
public class ShPracticeMenuController {

    @Autowired
    public ShPracticeMenuService shPracticeMenuService;

    /**
     * @Method mainTopMenuList
     * @Date 2024.05.09
     * @Writter seHyun
     * @Dscript 메인 탑 메뉴리스트
     * @param model
     * @EditHistory
     * @return String
     */
    @RequestMapping(value="/mainTopMenuList", method=RequestMethod.GET)
    public String mainTopMenuList(Model model) {
        log.info("mainTopMenuList()진입***");

        List<ShPracticeMenuVo> menuVo = shPracticeMenuService.listAll();
        log.info("shPracticeMenuService.listAll()처리결과::" + menuVo);

        model.addAttribute("menuList", menuVo);

        return "ysh/practice/menu/mainTopMenuList";
    }
}
