package co.kr.fourteen.ese.history.controller;

import co.kr.fourteen.ese.history.service.EseHistoryService;
import co.kr.fourteen.ese.history.vo.EseHistoryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
@RequestMapping(value="/ese/")
public class EseHistoryController {

	@Autowired
	private EseHistoryService eseHistoryService;


	/**
	* @Method eseHistory
	* @Date 2024. 05. 13.
	* @Writter ese(어성은 )
	* @Param Model
	* @EditHistory
	* @Discript Seongeun Company history Page.
	* @Return String
	*/
	@RequestMapping(value="history", method = RequestMethod.GET) // 주소호출
	public String eseHistory(Model model) {
        List<EseHistoryVo> historyList = eseHistoryService.historyList();
        model.addAttribute("historyList", historyList);

        if (historyList != null) {
            for (EseHistoryVo vo : historyList) {
            	log.info("Year: " + vo.getYear() + ", Event: " + vo.getEvent());
            }
        } else {
        	log.info("historyList is null");
        }

        return "ese/company/history";
    }


}
