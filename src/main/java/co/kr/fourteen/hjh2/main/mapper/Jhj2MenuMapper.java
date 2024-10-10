package co.kr.fourteen.hjh2.main.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.hjh2.main.vo.Jhj2MenuVo;

@OracleSqlMapperScan
public interface Jhj2MenuMapper {

	public List<Jhj2MenuVo> mainTopMenuList();

}
