package co.kr.fourteen.common.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base32;

public class GoogleOtp {

	public static void main(String[] args) {
		GoogleOtp otp = new GoogleOtp();
		//HashMap<String, String> map = otp.generate("youngjin309", "naver.com");
		//String otpkey = map.get("encodedKey");
		//String otpkey = "OV2IJZY4EG2MW55L";	// 구글
		String otpkey = "PIRCVNNP5UAMDHHS";	// 네이버
		//String url = map.get("url");

		System.out.println(otpkey);
		//System.out.println(url);

		// 우선 위의 과정으로 생성된 키/url을 otp앱에 등록하고나서 표시되는 번호와 생성된 키를 넣어주면 true가 나올 것이다.
		boolean check = otp.checkCode("198519", otpkey);

		System.out.println(check);
	}

	public HashMap<String, String> generate(String userName, String hostName) {
		HashMap<String, String> map = new HashMap<String, String>();
		byte[] buffer = new byte[5 + 5 * 5];
		new Random().nextBytes(buffer);
		Base32 codec = new Base32();
		byte[] secretKey = Arrays.copyOf(buffer, 10);
		byte[] bEncodedKey = codec.encode(secretKey);

		String encodedKey = new String(bEncodedKey);
		String url = getQRBarcodeURL("fourteen :: " + userName, hostName, encodedKey);

		// Google OTP 앱에 userName@hostName 으로 저장됨
		// key를 입력하거나 생성된 QR코드를 바코드 스캔하여 등록

		map.put("encodedKey", encodedKey);
		map.put("url", url);
		return map;
	}

	public boolean checkCode(String otpkey, String userCode) {
		long otpnum = Integer.parseInt(userCode); // Google OTP 앱에 표시되는 6자리 숫자
		long wave = new Date().getTime() / 30000; // Google OTP의 주기는 30초
		boolean result = false;
		try {
			Base32 codec = new Base32();
			byte[] decodedKey = codec.decode(otpkey);
			int window = 3;
			for(int i = -window; i <= window; ++i) {
				long hash = verify_code(decodedKey, wave + i);
				if(hash == otpnum) result = true;
			}
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static int verify_code(byte[] key, long t) throws NoSuchAlgorithmException, InvalidKeyException {
		byte[] data = new byte[8];
		long value = t;
		for(int i = 8; i-- > 0; value >>>= 8) {
			data[i] = (byte) value;
		}

		SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(signKey);
		byte[] hash = mac.doFinal(data);

		int offset = hash[20 - 1] & 0xF;

		// We're using a long because Java hasn't got unsigned int.
		long truncatedHash = 0;
		for(int i = 0; i < 4; ++i) {
			truncatedHash <<= 8;
			// We are dealing with signed bytes:
			// we just keep the first byte.
			truncatedHash |= (hash[offset + i] & 0xFF);
		}

		truncatedHash &= 0x7FFFFFFF;
		truncatedHash %= 1000000;

		return (int) truncatedHash;
	}

	public static String getQRBarcodeURL(String user, String host, String secret) {
		// QR코드 주소 생성
		String format = "https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=otpauth://totp/%s@%s%%3Fsecret%%3D%s&chld=H|0";
		return String.format(format, user, host, secret);
	}
}