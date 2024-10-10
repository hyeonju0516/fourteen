package co.kr.fourteen.jiyy.prac.service;

import java.util.List;

import co.kr.fourteen.jiyy.prac.vo.PracAjaxVo;

public interface PracAjaxService {

	//두개이상의 데이터를 가져올 수 있기 때문에 list타입 선언, 이름도 리스트
	public List<PracAjaxVo> selectList(String regId);
}
