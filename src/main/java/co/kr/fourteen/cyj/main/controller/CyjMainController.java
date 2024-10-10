package co.kr.fourteen.cyj.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/")
public class CyjMainController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * @Method cyjMain
	 * @Date 2024. 05. 04.
	 * @Writter sky(정영진)
	 * @EditHistory
	 * @Discript 메인 페이지
	 * @Return String
	 */

	@RequestMapping(value="cyjMain")
	public String cyjMain(Model model) {
		model.addAttribute("data", "안녕하세요");
		return "cyj/main/main";
	}

	/**
	 * @Method apiData
	 * @Date 2024. 05. 10.
	 * @Writter sky(정영진)
	 * @EditHistory
	 * @Discript Json return
	 * @Return ModelAndView
	 */

	@RequestMapping(value="testApiData")
	@ResponseBody
	public JSONObject apiData(@RequestParam Map<String, Object> map, HttpServletRequest req) {

		JSONObject json = new JSONObject();
		JSONObject data = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		// 공백 체크해서 공백이면 맨끝값인 디폴트값을 담는다
		String str = ServletRequestUtils.getStringParameter(req, "type", "");

		log.info("%%%%%%%%%% :" + map.get("code"));
		log.info(">>>>>>>>>> :" + str);
		log.info("########## :" + req.getParameter("type"));

		try {
			json.put("id", "KIMHYOJIN");
			json.put("age", "24");
			json.put("gender", "f");
			json.put("name", "김효진");
			json.put("phone", "010-1234-5678");
			json.put("equipmentno", "ASSETTEST");
			json.put("message", "RETURNOK");
			json.put("responseData", "{123, 456}");

			data.put("jsonObject", json);

			json = new JSONObject();
			json.put("BANK_CD", "088");
			json.put("SEARCH_ACCT_NO", "1231231234");
			json.put("ACNM_NO", "123456");
			json.put("ICHE_AMT", "0");
			json.put("TRSC_SEQ_NO", "0000001");

			jsonArray.add(json);

			data.put("jsonArray", jsonArray);
		} catch (Exception e) {
			json.put("result_code", "001");
			json.put("result_msg", "관리자에게 문의하세요");
			return data;
		}

		return data;
	}

	@RequestMapping(value="requestCall")
	@ResponseBody
	public String requestCall(@RequestBody String param, Model model) {

		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("url", "www.skysky.co.kr");
		dataMap.put("age", "20");
		dataMap.put("tel", "010-2486-3462");
		dataMap.put("message", "리턴 메세지");

		model.addAttribute("resultData", dataMap);
		return "JSON_VIEW";
	}


	@RequestMapping(value="requestCall/{rrrr}")
	public String requestCall2(@PathVariable(value="rrrr") String result, Model model) {
		log.info(">>>>>>>>>>>> result ::" + result);

		return result;
	}
}
