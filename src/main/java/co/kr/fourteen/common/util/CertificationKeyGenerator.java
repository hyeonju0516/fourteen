package co.kr.fourteen.common.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.kr.fourteen.common.util.mapper.CertifiMapper;


/**
 * sms인증시 전화번호에대한 키 제네레이터
 */

public class CertificationKeyGenerator {

	private Log log = LogFactory.getLog(CertificationKeyGenerator.class);

	public static CertificationKeyGenerator newInstance() {
		return new CertificationKeyGenerator();
	}

	private CertificationKeyGenerator(){}

	/**
	 * 인증키 생성 유틸
	 * 인증키는 아래와 같이 시간을 전번 뒤에 섞고 끝에서 6자리를 서브스트링한다.
	 * @param Number
	 * @return
	 */

	public String tempKeyGenarator(String Number) {
		String lastNumberString = null;
		String numberArray[] = Number.split("-");
		if(numberArray[2].charAt(0) == '0') lastNumberString = "1" + numberArray[2].substring(1, numberArray[2].length());
		else lastNumberString = numberArray[2];
		String last = Long.toString((Integer.parseInt(lastNumberString) * System.currentTimeMillis()));
		return last.substring(last.length() - 6, last.length());
	}

	/**
	 * 인증키를 디비에서 지우고 새로운 인증키를 생성하여 디비에 삽입한다.
	 * @param certifiMapper
	 * @param phone
	 */

	public void tempKeyGenerator(CertifiMapper certifiMapper, String phone, HttpSession session) throws Exception {
		//인증키 생성
		String tempKey = tempKeyGenarator(phone);
		log.info("인증 키 : " + tempKey);

		//인증키및 전화번호 파라미터화
		HashMap<Object, Object> param = new HashMap<Object, Object> ();
		param.put("tempKey", tempKey);
		param.put("phone", phone);

		//SMS를 보내기위해 작업
		SMSFactory smsFactory = new SMSFactory(tempKey, phone);

		// 문자 발송 막음(임시 방편)
		certifiMapper.insertCertificationKey(param);

		/*if(smsFactory.Send()) {
			//sms로 발송한 신규 인증키를 db에 삽입
			log.info("sms 전송 완료");
			certifiMapper.insertCertificationKey(param);
		}*/

		Date date = new Date();
		long validTime = date.getTime();
		validTime += 180000L;

		session.setAttribute("phone", phone);
		session.setAttribute("token", tempKey.replace(" ", ""));
		session.setAttribute("tokenValidTime", Long.valueOf(validTime));
	}

	public void tempKeyGenerator2(Map<String, Object> map, String phone) throws Exception {
		//인증키 생성
		String tempKey = map.toString();

		//SMS를 보내기위해 작업
		SMSFactory smsFactory = new SMSFactory(tempKey, phone);
		 smsFactory.Send();
	}

	/**
	 * 인풋키와 임시키를 비교하여 일치하는지 반환함
	 * @param thamesMemberDAO
	 * @param phone
	 * @param input
	 * @return
	*/

	public boolean isCorrectCertifiKey(CertifiMapper certifiMapper, String phone , String inputKey) {
		//db에서 dbKey를 가져와 저장할 임시변수
		String dbKey = "";

		//암호화된 전화번호로 임시키 가져옴
		dbKey = certifiMapper.getTempKey(phone);

		if(dbKey == null) return false;

		//임시키와 인풋키 공백제거
		dbKey = dbKey.trim();
		inputKey = inputKey.trim();

		//인풋키와 임시키 비교
		if(inputKey.equals(dbKey)) {
			//디비에 누적된 임시키 삭제
			certifiMapper.deleteTempKey(phone);
			return true;
		} else {
			return false;
		}
	}
}