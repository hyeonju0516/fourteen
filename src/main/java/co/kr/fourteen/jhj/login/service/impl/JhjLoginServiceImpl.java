package co.kr.fourteen.jhj.login.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.jhj.login.mapper.JhjLoginMapper;
import co.kr.fourteen.jhj.login.service.JhjLoginService;
import co.kr.fourteen.jhj.user.vo.JhjUserVo;

@Service
public class JhjLoginServiceImpl implements JhjLoginService {

	private JhjLoginMapper jhjLoginMapper = null;

	@Autowired
	public JhjLoginServiceImpl(JhjLoginMapper jhjLoginMapper) {
		this.jhjLoginMapper = jhjLoginMapper;
	}

	@Override
	public JhjUserVo selectJhjUserPw(JhjUserVo vo) {
		JhjUserVo outVo = jhjLoginMapper.selectJhjUserPw(vo);
		return outVo;
	}

	@Override
	public Map<String, String> resetPw(JhjUserVo vo) {
		Map<String, String> response = new HashMap<>();
		jhjLoginMapper.selectJhjUserIdEmail(vo);

		// 아이디,이메일로 찾기
		JhjUserVo inputVo = jhjLoginMapper.selectJhjUserIdEmail(vo);

		if (inputVo != null) {
			String hashedPassword = BCrypt.hashpw(vo.getUserPw(), BCrypt.gensalt());
			vo.setUserPw(hashedPassword);
			jhjLoginMapper.updateJhjUserNewPw(vo);
			response.put("result","true");
		} else {
			response.put("result","false");
		}

		return response;
	}

	@Override
	public Map<String, String> findId(JhjUserVo vo) {
		Map<String, String> response = new HashMap<>();
		// 아이디 폰번호로 찾기
		List<JhjUserVo> idList = new ArrayList<JhjUserVo>();
		idList = (List<JhjUserVo>) jhjLoginMapper.selectjhjUserId(vo);
		StringBuilder sb = new StringBuilder();

		if (idList.size() > 1) {
			for (JhjUserVo id : idList) {
				if (sb.length() > 0) {
					sb.append(", ");  // 여러 ID가 있을 경우 쉼표로 구분
				}
				sb.append(id.getUserId());
			}
		} else {
			sb.append(idList.get(0).getUserId());
		}

		response.put("idList", sb.toString());
		return response;
	}
}