package co.kr.fourteen.jiyy.prac.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.jiyy.prac.vo.PracAjaxVo;

@OracleSqlMapperScan
public interface PracAjaxMapper {

	public List<PracAjaxVo> selectList(String regId);
}
