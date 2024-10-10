package co.kr.fourteen.jiyy.menu.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.jiyy.menu.vo.JyMenuVo;

@OracleSqlMapperScan
public interface JyMenuMapper {

	public List<JyMenuVo> mainTopMenu();
}
