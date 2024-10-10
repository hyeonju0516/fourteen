package co.kr.fourteen.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * SMS 수신을 위해 만들었음 계정변수가 들어가기때문에 상속금지
 *
 * @author lejewk
 *
 */

public final class SMSFactory {

	private Log log = LogFactory.getLog(SMSFactory.class);

	private String charsetType = "UTF-8";			// 문자셋은 UTF-8
	private String smsUrl = null;					// sms전송을 위한 서비스를 제공하는 cafe24 url
	private String userId = null;					// retensi에 대한 sms서비스를 구입한 닉네임
	private String secure = null;					// 인증키
	private String msg = null;						// 송신할 메시지
	private String receivePhoneNumber = null;		// 받을 폰번호 ex)000-0000-0000 에서 '-' 포함
	private String firstPhoneNumber = null;			// 전송할 첫번째 폰번호
	private String secondPhoneNumber = null;		// 전송할 두번째 폰번호
	private String thirdPhoneNumber = null;			// 전송할 세번째 폰번호
	private String rDate = null;					// 예약날짜
	private String rTime = null;					// 예약시간
	private String mode = null;						// ?? 설명없음
	private String testFlag = null;					// 테스트페이지 요청임. sms는 전송하지 않으나 단순한 테스트 페이지 용도
	// 테스트일경우 Y 문자로 셋팅
	private String destination = null;				// 메시지받는 사람의 이름
	private String repeatFlag = null;				// 반복설정을 원하면 Y 문자삽입
	private String repeatTime = null;				// 15분 이상부터 가능
	private String repeatNum = null;				// 반복 횟수 1~10회 까지
	private String returnUrl = null;				// 메시지 전송후 이동할 url. http를 앞에 붙이란다.
	private String noInteractive = null;			// 사용할경우 1 문자로 셋팅. 성공시 대화상자를 사용하지 않게한다?

	/**
	 * SMS 전송 클래스 생성자
	 * @param tempKey
	 * @param phone
	 * @throws Exception
	 **/

	public SMSFactory(String tempKey, String phone) throws Exception {
		smsUrl = "http://sslsms.cafe24.com/sms_sender.php";
		userId = base64Encode("remember1562");	//아이디
		secure = base64Encode("2717384e68cf08ab75b7e5923ecc0379");// 인증키
		msg = base64Encode(nullcheck(setMessage(tempKey.substring(0, 3) + " " + tempKey.substring(3, 6)), ""));
		receivePhoneNumber = base64Encode(nullcheck(phone, ""));
		firstPhoneNumber = base64Encode(nullcheck("010", ""));
		secondPhoneNumber = base64Encode(nullcheck("2486", ""));
		thirdPhoneNumber = base64Encode(nullcheck("3462", ""));
		rDate = base64Encode(nullcheck(rDate, ""));
		rTime = base64Encode(nullcheck(rTime, ""));
		mode = base64Encode("1");
		testFlag = base64Encode(nullcheck(testFlag, ""));
		destination = base64Encode(nullcheck(destination, ""));
		repeatFlag = base64Encode(nullcheck(repeatFlag, ""));
		repeatNum = base64Encode(nullcheck(repeatNum, ""));
		repeatTime = base64Encode(nullcheck(repeatTime, ""));
		returnUrl = base64Encode(nullcheck(returnUrl, ""));
		noInteractive = nullcheck(noInteractive, "");
	}

	/**
	 * null 체크.
	 *
	 * @param str
	 * @param Defaultvalue
	 * @return
	 * @throws Exception
	 **/

	public String nullcheck(String str, String Defaultvalue) throws Exception {
		String ReturnDefault = "";
		if(str == null) {
			ReturnDefault = Defaultvalue;
		} else if (str == "") {
			ReturnDefault = Defaultvalue;
		} else {
			ReturnDefault = str;
		}
		return ReturnDefault;
	}

	/**
	 * BASE64로 인코딩
	 *
	 * @param str
	 * @return
	 * @throws java.io.Exception
	 **/

	@SuppressWarnings("restriction")
	public String base64Encode(String str) throws Exception {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		byte[] strByte = str.getBytes();
		String result = encoder.encode(strByte);
		return result;
	}

	/**
	 * BASE64 디코딩
	 *
	 * @param str
	 * @return
	 * @throws java.io.Exception
	 **/

	@SuppressWarnings("restriction")
	public String base64Decode(String str) throws Exception {
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		byte[] strByte = decoder.decodeBuffer(str);
		String result = new String(strByte);
		return result;
	}

	/**
	 * sms를 전송한다.
	 * @throws Exception
	 **/

	@SuppressWarnings({ "rawtypes", "unchecked", "unused", "resource" })
	public boolean Send() throws Exception {
		String[] hostInfo = smsUrl.split("/");
		String host = hostInfo[2];
		String path = "/" + hostInfo[3];
		int port = 80;

		// 데이터 맵핑 변수 정의
		String arrKey[] = new String[] {
			"user_id", "secure", "msg", "rphone", "sphone1", "sphone2", "sphone3", "rdate", "rtime",
			"mode", "testflag", "destination", "repeatFlag", "repeatNum", "repeatTime"
		};

		String valKey[]= new String[arrKey.length];

		valKey[0] = userId;
		valKey[1] = secure;
		valKey[2] = msg;
		valKey[3] = receivePhoneNumber;
		valKey[4] = firstPhoneNumber;
		valKey[5] = secondPhoneNumber;
		valKey[6] = thirdPhoneNumber;
		valKey[7] = rDate;
		valKey[8] = rTime;
		valKey[9] = mode;
		valKey[10] = testFlag;
		valKey[11] = destination;
		valKey[12] = repeatFlag;
		valKey[13] = repeatNum;
		valKey[14] = repeatTime;

		//printValKey(valKey);

		String boundary = "";
		Random rnd = new Random();
		String rndKey = Integer.toString(rnd.nextInt(32000));

		MessageDigest md = MessageDigest.getInstance("MD5");

		byte[] bytData = rndKey.getBytes();
		md.update(bytData);
		byte[] digest = md.digest();

		for(int i=0; i<digest.length; i++) {
			boundary = boundary + Integer.toHexString(digest[i] & 0xFF);
		}

		boundary = "---------------------" + boundary.substring(0, 10);

		// 본문 생성
		String data = "";
		String index = "";
		String value = "";

		for(int i=0; i<arrKey.length; i++) {
			index =  arrKey[i];
			value = valKey[i];
			data += "--" + boundary + "\r\n";
			data += "Content-Disposition: form-data; name=\"" + index + "\"\r\n";
			data += "\r\n" + value + "\r\n";
			data +="--" + boundary + "\r\n";
		}

		InetAddress addr = InetAddress.getByName(host);
		Socket socket = new Socket(host, port);

		// 헤더 전송
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), charsetType));
		wr.write("POST " + path + " HTTP/1.0\r\n");
		wr.write("Content-Length: " + data.length() + "\r\n");
		wr.write("Content-type: multipart/form-data, boundary=" + boundary + "\r\n");
		wr.write("\r\n");

		// 데이터 전송
		wr.write(data);
		wr.flush();

		// 결과값 얻기
		BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream(), charsetType));
		String line;
		String alert = "";
		ArrayList tmpArr = new ArrayList();

		while((line = rd.readLine()) != null) {
			tmpArr.add(line);
		}

		wr.close();
		rd.close();

		String tmpMsg = (String)tmpArr.get(tmpArr.size() - 1);
		String[] rMsg = tmpMsg.split(",");
		String Result = rMsg[0];									//발송결과
		String Count = "";											//잔여건수

		if(rMsg.length > 1) Count= rMsg[1];

		//발송결과 알림
		if(Result.equals("success")) {
			alert = "성공적으로 발송하였습니다.";
			alert += " 잔여건수는 " + Count + " 건 입니다.";
			log.info(alert);
			return true;
		} else if(Result.equals("reserved")) {
			alert = "성공적으로 예약되었습니다";
			alert += " 잔여건수는 " + Count+" 건 입니다.";
			return true;
		} else if(Result.equals("3205")) {
			alert = "잘못된 번호형식입니다.";
			return false;
		} else {
			alert = "[Error]" + Result;
			return false;
		}
	}

	/**
	 * 전송시 메시지 가공
	 */
	private String setMessage(String msg) {
		return "본인확인 인증키는 [ " + msg + " ] 입니다.";
	}

	/**
	 * valKey 출력용함수
	 */
	public void printValKey(String ar[]) {
		for(int i=0; i<ar.length; i++) {
			log.info("valKey[" + i + "] : " + ar[i]);
		}
	}
}