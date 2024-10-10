package co.kr.fourteen.taengEe.prac03.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.taengEe.prac03.vo.KthPrac03Vo;

@OracleSqlMapperScan
public interface KthPrac03Mapper {

	public void addInfo(KthPrac03Vo vo);

	public List<KthPrac03Vo> list();

}
