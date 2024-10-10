package co.kr.fourteen.ese.main.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.ese.main.vo.EseMenuVo;

import java.util.List;

@OracleSqlMapperScan
public interface EseMenuMapper {

	// GNB 리스트
	public List<EseMenuVo> seMainTopMenuList();

}
