package co.kr.fourteen.seHyun.menu.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.seHyun.menu.vo.YshMenuVo;

@OracleSqlMapperScan
public interface YshMenuMapper {

	public List<YshMenuVo> mainTopMenuList();
}
