package co.kr.fourteen.ese.history.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.ese.history.vo.EseHistoryVo;

import java.util.List;

@OracleSqlMapperScan
public interface EseHistoryMapper {

	public List<EseHistoryVo> historyList();
}
