package co.kr.fourteen.kcm.menu.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.kcm.menu.vo.MenuVoKcm;

@OracleSqlMapperScan
public interface MenuMapperKcm {

	public List<MenuVoKcm> mainTopMenuList();

}
