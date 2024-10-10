package co.kr.fourteen.hoseong.oracle.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.fourteen.hoseong.oracle.service.HoOracleService;
import co.kr.fourteen.hoseong.oracle.vo.HoOracleVo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HoOracleController {

	@Autowired
	private HoOracleService hoOracleService;

	@RequestMapping(value="/hoseong/list", method = RequestMethod.GET)
	public String hoOracleList(Model model) {

		List<HoOracleVo> list = hoOracleService.selectUserInfoList();

		model.addAttribute("list", list);
		return "hoseong/oracle/hoOracleList";
	}

	@RequestMapping(value="/hoseong/view/{userNo}", method = RequestMethod.GET)
	public String hoOracleView(@PathVariable("userNo") int userNo, Model model) {

		HoOracleVo result = hoOracleService.selectUserInfoToNo(userNo);

		model.addAttribute("info", result);
		return "hoseong/oracle/hoOracleView";
	}

	@RequestMapping(value="/hoseong/add", method = RequestMethod.GET)
	public String hoOracleAdd(Model model) {
		List<String> cityList = hoOracleService.selectCityList();

		model.addAttribute("cityList", cityList);
		return "hoseong/oracle/hoOracleAdd";
	}

	@RequestMapping(value="/hoseong/add", method = RequestMethod.POST)
	public ResponseEntity<Integer> hoOracleAddPost(@RequestBody HoOracleVo dto) {

		// 현재 userNo중 가장 큰 숫자 +1 가져오기
		int userNo = hoOracleService.selectMaxUserNo();
		dto.setUserNo(userNo);
		int isTrue = hoOracleService.insertUserInfo(dto);

		return ResponseEntity.ok(isTrue);
	}

	@RequestMapping(value="/hoseong/update/{userNo}", method = RequestMethod.GET)
	public String hoOracleUpdate(@PathVariable("userNo") int userNo, Model model) {

		HoOracleVo result = hoOracleService.selectUserInfoToNo(userNo);

		model.addAttribute("info", result);
		return "hoseong/oracle/hoOracleUpdate";
	}

	@RequestMapping(value="/hoseong/update", method = RequestMethod.POST)
	public ResponseEntity<Integer> hoOracleUpdate(@RequestBody HoOracleVo dto, Model model) {

		int isTrue = hoOracleService.updateUserInfo(dto);

		return ResponseEntity.ok(isTrue);
	}

	@RequestMapping(value="/hoseong/delete", method = RequestMethod.POST)
	public ResponseEntity<Integer> hoOracleDelete(@RequestBody HoOracleVo vo, Model model) {

		int isTrue = hoOracleService.deleteUserInfo(vo.getUserNo());

		return ResponseEntity.ok(isTrue);
	}

	@RequestMapping(value="/hoseong/isok", method = RequestMethod.POST)
	public ResponseEntity<Integer> hoOracleIsOk(@RequestBody HoOracleVo vo) {

		int isOk = hoOracleService.selectUserIdCount(vo);

		return ResponseEntity.ok(isOk);
	}

	@RequestMapping(value="/hoseong/checkCounty", method = RequestMethod.POST)
	public ResponseEntity<List<String>> hoOracleCheckCounty(@RequestBody HashMap<String, String> data) {

		List<String> countyList = hoOracleService.selectCountyList(data.get("cityName"));

		return ResponseEntity.ok(countyList);
	}

	@RequestMapping(value="/hoseong/checkDistrict", method = RequestMethod.POST)
	public ResponseEntity<List<String>> hoOracleCheckDistrict(@RequestBody HashMap<String, String> data) {

		List<String> countyList = hoOracleService.selectDistrictList(data.get("countyName"));

		return ResponseEntity.ok(countyList);
	}
}
