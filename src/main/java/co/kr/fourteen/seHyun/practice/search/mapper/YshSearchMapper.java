package co.kr.fourteen.seHyun.practice.search.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.seHyun.practice.search.vo.YshSearchVo;

import java.util.List;

@OracleSqlMapperScan
public interface YshSearchMapper {
    public boolean idSearching(String userId);

    public List<YshSearchVo> joinChecking(String userName);
}
