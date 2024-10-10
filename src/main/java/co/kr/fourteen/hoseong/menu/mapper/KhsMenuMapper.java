package co.kr.fourteen.hoseong.menu.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.hoseong.menu.vo.KhsMenuVo;

import java.util.List;

@OracleSqlMapperScan
public interface KhsMenuMapper {

	/**
	 * @Method hsMainTopMenuList
	 * @Date 2024. 05. 06.
	 * @Writter gak098(곽호성)
	 * @EditHistory
	 * @Discript HoSeong mainTopMenuList Page.
	 * @Return String
	 */
	public List<KhsMenuVo> hsMainTopMenuList();

}
