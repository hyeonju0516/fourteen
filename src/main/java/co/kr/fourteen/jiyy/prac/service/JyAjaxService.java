package co.kr.fourteen.jiyy.prac.service;

import java.util.List;

import co.kr.fourteen.jiyy.prac.vo.PracAjaxVo;

public interface JyAjaxService {

	public List<PracAjaxVo> dataResult(String jyData);

	public boolean userIdCheck(String userId);

}
