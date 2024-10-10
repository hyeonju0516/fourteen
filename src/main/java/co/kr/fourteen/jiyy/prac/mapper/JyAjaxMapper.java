package co.kr.fourteen.jiyy.prac.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.jiyy.prac.vo.PracAjaxVo;

@OracleSqlMapperScan
public interface JyAjaxMapper {

	List<PracAjaxVo> dataResult(String jyData);

	public int userIdCheck(String userId);
}
