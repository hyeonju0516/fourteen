package co.kr.fourteen.ese.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.ese.oracle.mapper.EseOracleMapper;
import co.kr.fourteen.ese.oracle.service.EseOracleService;
import co.kr.fourteen.ese.oracle.vo.EseOracleVo;

@Service
public class EseOracleServiceImpl implements EseOracleService {
	@Autowired
	private EseOracleMapper eseOracleMapper;

	@Override
	public String selectUserInfo(EseOracleVo vo) {
		// TODO Auto-generated method stub

		//if(userId != "") { // "".equals(userId) 을 쓰는것이 실무에 더 적합
		//	eseoracleMapper.selectUserInfo(userId);
		//}

		// return "".equals(userId) ? eseoracleMapper.selectUserInfo(userId) : "" ;

		return "";
		// if 문 말고 삼항연산자로 할수 있다면 줄이는것이 좋다

	}


}
