package co.kr.fourteen.common.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rsa {

	//RSA
	public static String RSA_WEB_KEY = "_RSA_WEB_Key_"; // 개인키 session key
	public static String RSA_OTP_KEY = "_RSA_OTP_Key_"; // 개인키 session key
	public static String RSA_INSTANCE = "RSA"; 			// rsa transformation

	/**
	 * 복호화
	 * @param privateKey
	 * @param securedValue
	 * @return
	 * @throws Exception
	 */

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public String decryptRsa(PrivateKey privateKey, String securedValue) throws Exception {

		log.info(">>> Rsa 클래스에서 복호화 ");

		Cipher cipher = Cipher.getInstance(Rsa.RSA_INSTANCE);				//유조?
		byte[] encryptedBytes = hexToByteArray(securedValue);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		String decryptedValue = new String(decryptedBytes, "utf-8"); 		// 문자 인코딩 주의.
		return decryptedValue;
	}

	/**
	 * 16진 문자열을 byte 배열로 변환한다.
	 *
	 * @param hex
	 * @return
	 */
	public static byte[] hexToByteArray(String hex) {

		/*log.info(">>> Rsa 클래스에서 16진 문자열을 byte 배열로 변환 ");*/

		if (hex == null || hex.length() % 2 != 0) { return new byte[] {}; }

		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < hex.length(); i += 2) {
			byte value = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
			bytes[(int) Math.floor(i / 2)] = value;
		}
		return bytes;
	}

	/**
	 * rsa 공개키, 개인키 생성
	 *
	 * @param request
	 */
	public void initRsa(HttpServletRequest request, String type) {
		log.info(">>> Rsa 클래스에서 rsa 공개키, 개인키 생성 ");

		HttpSession session = request.getSession();

		KeyPairGenerator generator;

		try {
			generator = KeyPairGenerator.getInstance(Rsa.RSA_INSTANCE);
			generator.initialize(1024);

			KeyPair keyPair = generator.genKeyPair();
			KeyFactory keyFactory = KeyFactory.getInstance(Rsa.RSA_INSTANCE);
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();

			session.setAttribute("otp".equals(type) ? Rsa.RSA_OTP_KEY : Rsa.RSA_WEB_KEY, privateKey);							// session에 RSA 개인키를 세션에 저장

			RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			String publicKeyModulus = publicSpec.getModulus().toString(16);
			String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

			request.setAttribute("RSAModulus", publicKeyModulus);																// rsa modulus 를 request 에 추가
			request.setAttribute("RSAExponent", publicKeyExponent);																// rsa exponent 를 request 에 추가
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
