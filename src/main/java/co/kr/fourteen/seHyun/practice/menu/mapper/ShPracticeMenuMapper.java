package co.kr.fourteen.seHyun.practice.menu.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.seHyun.practice.menu.vo.ShPracticeMenuVo;

import java.util.List;

@OracleSqlMapperScan
public interface ShPracticeMenuMapper {

    public List<ShPracticeMenuVo> listAll();
}
