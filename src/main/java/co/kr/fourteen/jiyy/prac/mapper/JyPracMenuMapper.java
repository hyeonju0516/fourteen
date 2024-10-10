package co.kr.fourteen.jiyy.prac.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.jiyy.prac.vo.topMenuPracVo;

@OracleSqlMapperScan
public interface JyPracMenuMapper {

	public List<topMenuPracVo> headerMenuView();
}
