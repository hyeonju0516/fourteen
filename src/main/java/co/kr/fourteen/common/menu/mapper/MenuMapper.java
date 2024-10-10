package co.kr.fourteen.common.menu.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.common.menu.vo.MenuVo;

@OracleSqlMapperScan
public interface MenuMapper {

	public List<MenuVo> mainTopMenuList();

}
