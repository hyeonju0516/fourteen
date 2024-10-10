package co.kr.fourteen.kcm.oracle.service.impl;

import org.springframework.stereotype.Service;

import co.kr.fourteen.kcm.oracle.mapper.KcmoracleMapper;
import co.kr.fourteen.kcm.oracle.service.KcmoracleService;
import co.kr.fourteen.kcm.oracle.vo.KcmOracleVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KcmoracleServiceImpl implements KcmoracleService {

	private final KcmoracleMapper kcmoracleMapper;

	@Override
	public String selectUserInfo(KcmOracleVo vo) {
		// TODO Auto-generated method stub

		//if(userId != "") { // "".equals(userId) 을 쓰는것이 실무에 더 적합
		//	eseoracleMapper.selectUserInfo(userId);
		//}

		// return "".equals(userId) ? eseoracleMapper.selectUserInfo(userId) : "" ;

		return "";
		// if 문 말고 삼항연산자로 할수 있다면 줄이는것이 좋다

	}


}
